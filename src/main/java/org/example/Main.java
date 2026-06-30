package org.example;

import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {

        HiberSession hs = new HiberSession();

        Session session = hs.getSession();
//        CREATE (Insert)    it uses persist()

        session.beginTransaction();

        Student st = new Student();

        st.setName("Prince");
        st.setPhone(999999999);
        st.setPassword("1234");

        session.persist(st);

        session.getTransaction().commit();

        System.out.println("Data Saved");

//      READ (Fetch Data)       it uses get()

        Student stu = session.get(Student.class, 1);

        if(stu != null)
        {
            System.out.println(stu.getId());
            System.out.println(stu.getName());
            System.out.println(stu.getPhone());
            System.out.println(stu.getPassword());
        }

//        UPDATE      it uses merge()
        session.beginTransaction();

        Student stud = session.get(Student.class,2);

        if(stud != null)
        {
            stud.setName("Prince Aswani");
            stud.setPhone(987654321);

            session.merge(stud);
        }

        session.getTransaction().commit();

//        DELETE      it uses remove()
        session.beginTransaction();

        Student stude = session.get(Student.class,1);

        if(stude != null)
        {
            session.remove(stude);
        }

        session.getTransaction().commit();

        session.close();
    }
}