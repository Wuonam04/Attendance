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
        //Stream2 stream2 = new Stream2("qwert3", "akama23");
        //stream2.setNemis("qwert3");
        Mark mark = new Mark("225RRU",7, "yes");
        //session.save(mark);                          //comments are reserved
        
        mark.setWEEK_1("yes");
        session.update(mark);
        
        session.getTransaction().commit();
        session.close();
    }

}
