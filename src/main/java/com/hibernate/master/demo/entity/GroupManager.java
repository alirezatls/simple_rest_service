package com.hibernate.master.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable
public class GroupManager {
    @Id
    @GeneratedValue
    private Integer managerId;
    private String name;
    private String family;
    @JsonIgnore
    @OneToMany(mappedBy = "groupManager",fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    public GroupManager() {
    }

    public GroupManager(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
