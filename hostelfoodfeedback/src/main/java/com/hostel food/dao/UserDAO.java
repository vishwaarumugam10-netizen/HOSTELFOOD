package com.hostelfood.dao;

import com.hostelfood.entity.User;
import com.hostelfood.util.HibernateUtil;
import org.hibernate.Session;

public class UserDAO {

    public User findByUsername(String username) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                    "FROM com.hostelfood.entity.User WHERE username = :username",
                    User.class)
                    .setParameter("username", username)
                    .uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}