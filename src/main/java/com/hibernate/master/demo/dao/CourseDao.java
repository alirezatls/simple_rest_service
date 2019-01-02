package com.hibernate.master.demo.dao;

import com.hibernate.master.demo.entity.Course;

public interface CourseDao {

    Course getById(Long id);

    void removeById(Long id);

    void saveOrUpdate(Course course);

    void playWithEntityManager();
}
