package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setRoll_no(6);
        s1.setName("scot");
        s1.setAge(1);

//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(org.example.Student.class);
//        cfg.configure("hibernate.cfg.xml");


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();                                        //cfg.buildSessionFactory();


        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(s1);
        transaction.commit();

        session.close();
        sf.close();


    }
}