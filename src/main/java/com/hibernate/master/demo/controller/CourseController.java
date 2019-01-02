package com.hibernate.master.demo.controller;

import com.hibernate.master.demo.dao.CourseDao;
import com.hibernate.master.demo.entity.Course;
import exception.NoSuchCourseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseDao courseDao;

    @GetMapping(path = "/rs/co/courses/{id}")
    public Course findCrs(@PathVariable Long id) {
        Course course = courseDao.getById(id);
        if(course == null)
            throw new NoSuchCourseException("No Such Course-> "+id);
        else
            return course;
    }

    @GetMapping(path = "/rs/co/courses")
    public List<Course> findAllCrs() {
        return courseDao.getAllCourse();
    }

    @PostMapping(path = "/rs/co/courses")
    public ResponseEntity<Object> postCourse(@RequestBody Course co) {
        Course course = courseDao.saveCourse(co);

        UriComponents uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").
                buildAndExpand(course.getId());
        return ResponseEntity.created(uri.toUri()).build();
    }
}
