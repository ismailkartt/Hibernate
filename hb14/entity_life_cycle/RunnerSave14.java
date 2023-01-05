package com.hb14.entity_life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {
    public static void main(String[] args) {

        Student14 student1 = new Student14(); // Transient State
        student1.setName("İsmail Bey");
        student1.setMathGrade(100);

        Student14 student2 = new Student14();
        student1.setName("Mustafa Bey");
        student1.setMathGrade(100);

        Student14 student3 = new Student14();
        student1.setName("Miraç Bey");
        student1.setMathGrade(100);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student14.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1); // Persisted State

        student1.setName("Güncellenmiş İsmail Bey");

        session.evict(student1); // Detached state e geçti (session.close() gibi)

        session.update(student1); // detached olmuş student1 objesini persisted state e alır
        session.merge(student1); // detached olmuş student1 objesini persisted state e alır



        tx.commit();
        session.close();
        sf.close();




    }
}
