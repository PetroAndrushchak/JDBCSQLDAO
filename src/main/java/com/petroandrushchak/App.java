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





//
//        Connection conn = null;
//        Statement stmt = null;
//
//        try {
//            System.out.println("Connecting to database...");
//
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//
//            System.out.println("Creating statement...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT id, name FROM users";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
//                //Retrieve by column name
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//
//                //Display values
//                System.out.print("ID: " + id);
//                System.out.print(", Name: " + name);
//            }
//
//            rs.close();
//            stmt.close();
//            conn.close();
//
//        } catch (SQLException se) {
//            //Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            //Handle errors for Class.forName
//            e.printStackTrace();
//        } finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            }// nothing we can do
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//
//
//        }
    }
}