package com.hibernate.master.demo.dao.impl;

import com.hibernate.master.demo.dao.ManagerDao;
import com.hibernate.master.demo.entity.GroupManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class ManagerDaoImpl implements ManagerDao {

    @Autowired
    EntityManager entityManager;

    @Override
    public GroupManager getManagerById(int id) {
        return entityManager.find(GroupManager.class,id);
    }

    @Override
    public void saveOrUpdateManager(GroupManager gp) {
        if(gp.getManagerId() == null)
            entityManager.persist(gp);
        else
            entityManager.merge(gp);
    }

    @Override
    public void removeManagerById(int id) {
        GroupManager manager = getManagerById(id);
        entityManager.remove(manager);
    }

    @Override
    public List<GroupManager> getAllManager() {
        return null;
    }
}
