package org.example;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Scanner;

public class Login {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name : ");
        String name = sc.next();

        String hql = "Select s from Student s where s.name = ?1";

        HiberSession hs = new HiberSession();
        Session session = hs.getSession();
//        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        session.beginTransaction();

        Query<Student> query = session.createQuery(hql, Student.class);

        query.setParameter(1, name);

        try {

            Student std = query.getSingleResult();

            System.out.println("ID : " + std.getId());
            System.out.println("Name : " + std.getName());
            System.out.println("Phone : " + std.getPhone());
            System.out.println("Password : " + std.getPassword());

        } catch (Exception e) {

            System.out.println("Student Not Found");

        }

        session.close();
    }
}