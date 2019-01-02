package com.hibernate.master.demo.dao.impl;

import com.hibernate.master.demo.dao.AddressDao;
import com.hibernate.master.demo.dao.repository.AddressRepository;
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

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address getAddressById(int id) {
        return em.find(Address.class,id);
    }

    @Override
    public Address saveAddress(Address a) {
        return addressRepository.save(a);
    }

    @Override
    public Integer removeAddressById(int id) {
        return addressRepository.deleteAddressByAddressId(id);
    }

    @Override
    public List<Address> getAllAddress() {
        TypedQuery<Address> type = em.createQuery("select a from Address a", Address.class);
        List<Address> resultList = type.getResultList();
        return resultList;
    }
}
