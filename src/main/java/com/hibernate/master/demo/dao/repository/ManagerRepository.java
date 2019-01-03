package com.hibernate.master.demo.dao.repository;

import com.hibernate.master.demo.controller.GroupManagerController;
import com.hibernate.master.demo.entity.GroupManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<GroupManager,Integer> {

    Integer deleteByManagerId(Integer managerId);
}
