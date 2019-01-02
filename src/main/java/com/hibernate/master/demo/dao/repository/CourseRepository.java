package com.hibernate.master.demo.dao.repository;

import com.hibernate.master.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
