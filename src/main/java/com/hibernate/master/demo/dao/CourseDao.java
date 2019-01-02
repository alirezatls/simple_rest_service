package com.hibernate.master.demo.dao;

import com.hibernate.master.demo.entity.Course;

import java.util.List;

public interface CourseDao {

    Course getById(Long id);

    void removeById(Long id);

    Course saveCourse(Course course);

    List<Course> getAllCourse();

    void playWithEntityManager();
}
