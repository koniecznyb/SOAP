package com.soa.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by redi on 15.06.15.
 */
public class Subject {
    private Integer id;
    private String name;
    private Set<Student> students = new HashSet<Student>(0);

    protected Subject(){};

    public Subject(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
