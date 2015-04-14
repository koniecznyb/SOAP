package com.soa;

import java.util.List;

public class ConsumerMain{
    public static void main(String [] args){

        MainClassService mainClassService = new MainClassService();
        MainClass mainClass = mainClassService.getMainClassPort();

        System.out.println("first name: " + mainClass.hello("Name"));

        List<Student> studentList = mainClass.getStudentList("Name");

        for(Student s : studentList){
            System.out.println("First name: " + s.getFirstName());
            System.out.println("Last name: " + s.getLastName());
            System.out.println("Subjects: " + s.getSubjects().getSubject());

        }


        System.out.println(mainClass.hello("Baart"));
    }
}