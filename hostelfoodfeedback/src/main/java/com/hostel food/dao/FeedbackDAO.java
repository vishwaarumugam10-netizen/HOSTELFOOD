package com.hostelfood.dao;

import com.hostelfood.entity.Feedback;
import com.hostelfood.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class FeedbackDAO {

    public boolean exists(Integer studentId, String mealType, LocalDate date) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Long count = session.createQuery(
                    "SELECT COUNT(f) FROM Feedback f " +
                    "WHERE f.student.studentId = :studentId " +
                    "AND f.mealType = :mealType " +
                    "AND f.feedbackDate = :date",
                    Long.class)
                    .setParameter("studentId", studentId)
                    .setParameter("mealType", mealType)
                    .setParameter("date", date)
                    .uniqueResult();

            return count != null && count > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void save(Feedback feedback) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.persist(feedback);
            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    public List<Feedback> findAll() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                    "FROM Feedback", Feedback.class)
                    .list();

        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}