package com.petroandrushchak.db;

import com.petroandrushchak.model.User;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserTransformer {

    public static List<User> getUsers(ResultSet result) throws SQLException {
        List<User> users = new ArrayList<>();
        while (result.next()) {
            int id = result.getInt("id");
            String firstName = result.getString("fisrtName");
            String secondName = result.getString("secondName");
            users.add(new User(id, firstName, secondName));
        }
        return users;
    }
}
