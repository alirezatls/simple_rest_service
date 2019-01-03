package com.hibernate.master.demo.dao.impl;

import com.hibernate.master.demo.dao.ManagerDao;
import com.hibernate.master.demo.dao.repository.ManagerRepository;
import com.hibernate.master.demo.entity.GroupManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ManagerDaoImpl implements ManagerDao {

    @Autowired
    EntityManager entityManager;

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public GroupManager getManagerById(int id) {
        return entityManager.find(GroupManager.class,id);
    }

    @Override
    public GroupManager saveManager(GroupManager gp) {
        return managerRepository.save(gp);
    }

    @Override
    public Integer removeManagerById(int id) {
        return managerRepository.deleteByManagerId(id);
    }

    @Override
    public List<GroupManager> getAllManager() {
        TypedQuery<GroupManager> managers = entityManager.createQuery("select m from GroupManager m", GroupManager.class);
        List<GroupManager> resultList = managers.getResultList();
        return resultList;
    }
}
