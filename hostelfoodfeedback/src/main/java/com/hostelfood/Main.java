package com.hostelfood;

import com.hostelfood.entity.User;
import com.hostelfood.service.LoginService;

public class Main {

    public static void main(String[] args) {

        LoginService loginService = new LoginService();

        User user = loginService.login("student01", "1234");

        if (user != null) {
            System.out.println("Login successful!");
            System.out.println("Username: " + user.getUsername());
            System.out.println("Role: " + user.getRole());
        } else {
            System.out.println("Login failed!");
        }
    }
}
