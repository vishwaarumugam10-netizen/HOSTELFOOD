package com.hostelfood.dao;

import com.hostelfood.entity.MenuSuggestion;
import com.hostelfood.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MenuSuggestionDAO {

    public void save(MenuSuggestion suggestion) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.persist(suggestion);
            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    public List<MenuSuggestion> findAll() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                    "FROM MenuSuggestion", MenuSuggestion.class)
                    .list();

        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public void update(MenuSuggestion suggestion) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.merge(suggestion);
            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}