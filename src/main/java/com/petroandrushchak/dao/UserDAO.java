package com.petroandrushchak.dao;

import com.petroandrushchak.db.Table;
import com.petroandrushchak.db.UserTransformer;
import com.petroandrushchak.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends DAO {


    UserDAO(Connection con) {
        super(con, Table.USERS.tableName());
    }

    public List<User> getAllUsers() {
        String query = "SELECT * FROM " + this.tableName;

        try(PreparedStatement statement = con.prepareStatement(query);
            ResultSet result = statement.executeQuery();
        ) {
            return UserTransformer.getUsers(result);

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
