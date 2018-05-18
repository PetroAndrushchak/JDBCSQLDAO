package com.petroandrushchak.service;

import com.petroandrushchak.dao.DAO;
import com.petroandrushchak.dao.DAOManager;
import com.petroandrushchak.dao.UserDAO;
import com.petroandrushchak.model.User;

import java.sql.SQLException;
import java.util.List;

import static com.petroandrushchak.db.Table.USERS;

public class UserService {

    public List<User> getAllUsers(){

        try(DAOManager dao = DAOManager.getInstance()){
            UserDAO userDAO = (UserDAO)(dao.getDAO(USERS));
            return userDAO.getAllUsers();
        }
    }
}
