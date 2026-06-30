package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberSession {

    Configuration cfg =
            new Configuration().configure("hibernate.cfg.xml");

    SessionFactory sf = cfg.buildSessionFactory();

    Session session = sf.openSession();

    public Session getSession() {
        return session;
    }
}