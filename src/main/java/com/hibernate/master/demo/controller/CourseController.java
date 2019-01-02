package com.hibernate.master.demo.controller;

import com.hibernate.master.demo.dao.CourseDao;
import com.hibernate.master.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseDao courseDao;

    @GetMapping(path = "/rs/co/{id}")
    public Course findCrs(@PathVariable Long id) {
        return courseDao.getById(id);
    }

    @GetMapping(path = "/rs/co/courses")
    public List<Course> findAllCrs() {
        return courseDao.getAllCourse();
    }
}
