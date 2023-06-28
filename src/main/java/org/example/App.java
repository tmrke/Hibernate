package org.example;


import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            session.createQuery(" delete Person where name LIKE 'Chel' and  age < 20").executeUpdate();

            session.getTransaction().commit();
        }
    }
}
