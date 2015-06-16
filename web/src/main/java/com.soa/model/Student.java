package com.soa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soa.TestResource;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by redi on 28.04.15.
 */

public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private String indexNo;

    TestResource testResource;

    @JsonIgnore
    public Set<Subject> getSubjects() {
        return subjects;
    }

    private Set<Subject> subjects = new HashSet<Subject>(0);

    public Student(String jan, String nowak, String s) {
        this.firstName = jan;
        this.lastName = nowak;
        this.indexNo = s;
    }


    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, String indexNo, TestResource testResource) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.indexNo = indexNo;
        this.testResource = testResource;
    }

    public Student(Long id, String firstName, String lastName, String indexNo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.indexNo = indexNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }
}
