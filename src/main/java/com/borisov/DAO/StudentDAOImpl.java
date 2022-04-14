package com.borisov.DAO;

import com.borisov.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentDAOImpl implements StudentDAO{

    private final SessionFactory sessionFactory;

    public StudentDAOImpl() {
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    @Override
    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Student> studentList = session.createQuery("from Student", Student.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return studentList;
    }

    @Override
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }
}
