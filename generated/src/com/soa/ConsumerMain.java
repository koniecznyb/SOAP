package com.soa;

import com.soa.ws.Authorization;
import com.soa.ws.SecuredService;

import javax.sound.midi.Soundbank;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


        System.out.println("KONSUMPCJA Z SECURED");

        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("soap", "as".toCharArray());
            }
        });
        SecuredService securedService = new SecuredService();
        Authorization authorization = securedService.getExamplePort();

        System.out.println(authorization.hello("Working"));


    }
}