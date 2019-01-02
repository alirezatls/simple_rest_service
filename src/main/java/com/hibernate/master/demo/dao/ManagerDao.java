package com.hibernate.master.demo.dao;

import com.hibernate.master.demo.entity.GroupManager;

import java.util.List;

public interface ManagerDao {

    GroupManager getManagerById(int id);

    void saveOrUpdateManager(GroupManager gp);

    void removeManagerById(int id);

    List<GroupManager> getAllManager();
}
