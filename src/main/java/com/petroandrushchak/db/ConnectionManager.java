package com.petroandrushchak.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/petroandrushchakusersdb";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
