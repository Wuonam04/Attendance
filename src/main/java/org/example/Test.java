package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Stream stream = new Stream("akama");//done deal
        Stream2 stream2 = new Stream2("qwert3", "akama23");
        stream2.setNemis("qwert3");
        session.save(stream2);                          //comments are reserved
        
        session.getTransaction().commit();
        session.close();
    }

}
