package com.petroandrushchak;

import com.petroandrushchak.dao.DAOManager;
import com.petroandrushchak.model.User;
import com.petroandrushchak.service.UserService;

import java.io.Console;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/petroandrushchakusersdb";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {

        UserService userService = new UserService();
        List<User> users = userService.getAllUsers();
        System.out.println(users);
    }
}
