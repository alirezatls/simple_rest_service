package com.hibernate.master.demo.dao.impl;

import com.hibernate.master.demo.dao.AddressDao;
import com.hibernate.master.demo.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
@Transactional(isolation = Isolation.READ_COMMITTED,
        rollbackFor = Throwable.class,
        propagation = Propagation.REQUIRED)
public class AddressDaoImpl implements AddressDao {

    @Autowired
    EntityManager em;

    @Override
    public Address getAddressById(int id) {
        return em.find(Address.class,id);
    }

    @Override
    public void saveOrUpdateAddress(Address a) {
        if (a.getAddressId() == null)
            em.persist(a);
        else
            em.merge(a);
    }

    @Override
    public void removeAddressById(int id) {
        Address address = getAddressById(id);
        em.remove(address);
    }

    @Override
    public List<Address> getAllAddress() {
        TypedQuery<Address> type = em.createQuery("select a from Address a", Address.class);
        List<Address> resultList = type.getResultList();
        return resultList;
    }
}
