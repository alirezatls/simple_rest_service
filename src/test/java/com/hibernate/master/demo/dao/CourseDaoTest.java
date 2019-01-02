package com.hibernate.master.demo.dao;

import com.hibernate.master.demo.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDaoTest {

    @Autowired
    CourseDao courseDao;

    @Test
    public void getById() {
        Course course = courseDao.getById(1001L);
        assertEquals("OS",course.getName());
    }

    @Test
    @DirtiesContext
    public void removeById() {
        courseDao.removeById(1003L);
        assertNull(courseDao.getById(1003L));
    }

    @Test
    @DirtiesContext
    public void saveOrUpdate() {
        Course course = courseDao.getById(1L);
        course.setName("Rest Ws");
        //courseDao.saveOrUpdate(course);

        assertEquals("Rest Ws",course.getName());
    }
    @Test
    public void playWithEntityManagerTest() {
        courseDao.playWithEntityManager();
    }
}