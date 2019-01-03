package com.hibernate.master.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 2,message = "name shulde be atleast 2 character")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> studentList = new ArrayList<>();

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
