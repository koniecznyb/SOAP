package com.soa;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by redi on 15.06.15.
 */
public class Hibernate {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try{
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex){
            System.out.println("session creation failed");
            throw new ExceptionInInitializerError(ex);

        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
