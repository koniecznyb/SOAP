package com.soa.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by redi on 2015-04-13.
 */
public class Student {

    private String firstName;
    private String lastName;
    private String pesel;

    private List<String> subjects;

    public Student(){
        firstName = "sadsa";

    }

    public Student(String pesel){
        this.pesel = pesel;
        subjects = new ArrayList<String>();
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @XmlElementWrapper(name="subjects")
    @XmlElement(name="subject")
    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(String subject){
        if(subjects == null){
            subjects = new ArrayList<String>();
            subjects.add(subject);
        }
        else{
            subjects.add(subject);
        }
    }
}
