package org.example;


import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        try (
                SessionFactory sessionFactory = configuration.buildSessionFactory();
                Session session = sessionFactory.getCurrentSession()
        ) {
            session.beginTransaction();

            Person person = new Person("Cascade Person", 30);
            Item item = new Item("Cascade Item", person);

            person.setItems(new ArrayList<>(Collections.singletonList(item)));

            session.persist(person);

            session.getTransaction().commit();
        }
    }
}
