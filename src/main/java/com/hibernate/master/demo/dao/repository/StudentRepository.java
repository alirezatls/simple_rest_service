package com.hibernate.master.demo.dao.repository;

import com.hibernate.master.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
