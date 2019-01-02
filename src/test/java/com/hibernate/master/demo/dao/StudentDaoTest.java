package com.hibernate.master.demo.dao;

import com.hibernate.master.demo.entity.Address;
import com.hibernate.master.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {

    @Autowired
    StudentDao studentDao;

    @Autowired
    AddressDao addressDao;

    @Test
    @Transactional
    public void getStudentById() {
        Student student = studentDao.getStudentById(1000);
        System.out.println(student.getAddress());
        System.out.println(student.getGroupManger());
        System.out.println(student.getCourseList());
        assertEquals("alireza",student.getName());
    }

    @Test
    @DirtiesContext
    public void saveOrUpdateStudent() {
    }

    @Test
    @DirtiesContext
    public void removeStudentById() {
    }

    @Test
    public void getAllStudent() {
    }
}