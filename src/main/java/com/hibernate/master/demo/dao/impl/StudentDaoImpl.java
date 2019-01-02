package com.hibernate.master.demo.dao.impl;

import com.hibernate.master.demo.dao.StudentDao;
import com.hibernate.master.demo.dao.repository.StudentRepository;
import com.hibernate.master.demo.entity.Address;
import com.hibernate.master.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao{

    @Autowired
    EntityManager em;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getStudentById(int id) {
        return em.find(Student.class,id);
    }

    @Override
    public Student saveStudent(Student s) {
        return studentRepository.save(s);
    }

    @Override
    public Integer removeStudentById(int id) {
        return studentRepository.deleteStudentByStudentId(id);
    }

    @Override
    public List<Student> getAllStudent() {
        TypedQuery<Student> st = em.createQuery("select s from Student s", Student.class);
        return st.getResultList();
    }
}
