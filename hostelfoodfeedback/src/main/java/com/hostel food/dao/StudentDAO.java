package com.hostelfood.dao;

import com.hostelfood.entity.Student;
import com.hostelfood.util.HibernateUtil;
import org.hibernate.Session;

public class StudentDAO {

    public Student findById(Integer studentId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Student.class, studentId);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}