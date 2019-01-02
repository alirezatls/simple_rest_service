package com.hibernate.master.demo.dao;

import com.hibernate.master.demo.entity.GroupManager;
import com.hibernate.master.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerDaoTest {

    @Autowired
    ManagerDao managerDao;

    @Test
    @Transactional
    public void getManagerById() {
        GroupManager manager = managerDao.getManagerById(200);
        List<Student> students = manager.getStudents();
        for (Student s: students) {
            System.out.println(s);
        }
        assertEquals("alipoor",manager.getFamily());
    }

    @Test
    @DirtiesContext
    public void saveOrUpdateManager() {
    }

    @Test
    @DirtiesContext
    public void removeManagerById() {
    }

    @Test
    public void getAllManager() {
    }
}