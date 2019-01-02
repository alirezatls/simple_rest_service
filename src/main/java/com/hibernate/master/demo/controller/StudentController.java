package com.hibernate.master.demo.controller;

import com.hibernate.master.demo.dao.StudentDao;
import com.hibernate.master.demo.dao.repository.StudentRepository;
import com.hibernate.master.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentDao studentDao;

    @GetMapping(path = "/rs/ow/{id}")
    public Student findStd(@PathVariable int id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.get();
    }

    @GetMapping(path = "/rs/ow/students")
    public List<Student> findAllStd() {
        return studentDao.getAllStudent();
    }
}
