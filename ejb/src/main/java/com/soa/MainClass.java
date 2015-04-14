package com.soa;

import com.soa.model.Student;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by redi on 2015-04-13.
 */
@Stateless
@WebService
public class MainClass {

    @WebMethod
    public String hello(@WebParam(name="userName") String name){
        return "Welcome " + name;
    }

    @WebMethod
    public Student getStudent(@WebParam(name="getStudent") String pesel){
        Student s = new Student(pesel);
        s.setFirstName("Jan");
        s.setLastName("Ban");
        s.addSubject("Soa");
        s.addSubject("soa2");
        s.addSubject("soa3");
        return s;
    }

    @WebMethod
    public List<Student> getStudentList(@WebParam(name="Lista")String name){


        List <Student> lista = new ArrayList<Student>();
        lista.add(getStudent("1"));
        lista.add(getStudent("2"));
        lista.add(getStudent("3"));
        lista.add(new Student("4"));
        return lista;

    }
}
