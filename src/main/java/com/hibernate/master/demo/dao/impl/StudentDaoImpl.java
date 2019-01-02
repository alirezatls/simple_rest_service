package com.hibernate.master.demo.dao.impl;

import com.hibernate.master.demo.dao.StudentDao;
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

    @Override
    public Student getStudentById(int id) {
        return em.find(Student.class,id);
    }

    @Override
    public void saveOrUpdateStudent(Student s) {
        if(s.getStudentId() == null)
            em.persist(s);
        else
            em.merge(s);
    }

    @Override
    public void removeStudentById(int id) {
        Student student = getStudentById(id);
        em.remove(student);
    }

    @Override
    public List<Student> getAllStudent() {
      return null;
    }
}
