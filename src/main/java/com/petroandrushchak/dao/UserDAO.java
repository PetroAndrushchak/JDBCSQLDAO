package com.petroandrushchak.dao;

import com.petroandrushchak.db.Table;
import com.petroandrushchak.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class UserDAO extends DAO {

    private final static String TABLENAME = Table.USERS.tableName();

    UserDAO(Connection con) {
        super(con, TABLENAME);
    }

    public List<User> getAllUsers() {
        String query = "SELECT * FROM " + this.tableName;

        PreparedStatement statement = con.prepareStatement(query);

    }
}
