package com.hibernate.master.demo.dao;

import com.hibernate.master.demo.entity.Student;

import java.util.List;

public interface StudentDao {

    Student getStudentById(int id);

    Student saveStudent(Student s);

    Integer removeStudentById(int id);

    List<Student> getAllStudent();
}
