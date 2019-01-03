package com.hibernate.master.demo.controller;

import com.hibernate.master.demo.dao.StudentDao;
import com.hibernate.master.demo.dao.repository.StudentRepository;
import com.hibernate.master.demo.entity.Student;
import com.hibernate.master.demo.exception.EmptyListException;
import com.hibernate.master.demo.exception.NoSuchStudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentDao studentDao;

    @GetMapping(path = "/rs/st/{id}")
    public Student findStd(@PathVariable int id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.get();
    }

    @GetMapping(path = "/rs/st/students")
    public List<Student> findAllStd() {

        List<Student> students = studentDao.getAllStudent();
        if (students.size() == 0)
            throw new EmptyListException("No Content");
        else
            return students;
    }

    @PostMapping(path = "/rs/st/students")
    public ResponseEntity<Object> postStudent(@Valid @RequestBody Student std) {
        Student student = studentDao.saveStudent(std);

        UriComponents uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(student.getStudentId());

        return ResponseEntity.created(uri.toUri()).build();
    }

    @DeleteMapping(path = "/rs/st/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable int id) {
        Integer state = studentDao.removeStudentById(id);
        if(state<=0)
            throw new NoSuchStudentException("No Such Student");
        else
            return ResponseEntity.ok().build();
    }
}
