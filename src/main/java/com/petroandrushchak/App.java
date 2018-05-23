package com.petroandrushchak;

import com.petroandrushchak.dao.DAOManager;
import com.petroandrushchak.model.User;
import com.petroandrushchak.service.UserService;

import java.io.Console;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

public class App {

    public static void main(String[] args) {

        UserService userService = new UserService();
        List<User> users = userService.getAllUsers();
        System.out.println(users);
    }
}
