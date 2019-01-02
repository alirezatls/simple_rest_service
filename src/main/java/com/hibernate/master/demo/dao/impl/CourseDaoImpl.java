package com.hibernate.master.demo.dao.impl;

import com.hibernate.master.demo.dao.CourseDao;
import com.hibernate.master.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {

    @Autowired
    EntityManager em;

    @Override
    public Course getById(Long id) {
        return em.find(Course.class,id);
    }

    @Override
    public void removeById(Long id) {
        Course course = getById(id);
        em.remove(course);
    }

    @Override
    public void saveOrUpdate(Course course) {
        Course co = getById(course.getId());
        if(co.getId() == null)
            em.persist(course); //save a object
        else
            em.merge(course); //update a object
    }

    @Override
    public List<Course> getAllCourse() {
        TypedQuery<Course> co = em.createQuery("select c from Course c", Course.class);
        return co.getResultList();
    }

    @Override
    public void playWithEntityManager() {
      //  Course course1 = new Course("computer architecture");
     //   em.persist(course1);
     //   course1.setName("HTML5");
     //   em.flush();

        Course course2 = new Course("Js");
        em.persist(course2);
        em.flush();
        course2.setName("Angular");
        em.refresh(course2);
    }


}
