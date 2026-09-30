package com.hostelfood.service;

import com.hostelfood.dao.UserDAO;
import com.hostelfood.entity.User;

public class LoginService {

    private UserDAO userDAO = new UserDAO();

    public User login(String username, String password) {

        User user = userDAO.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}