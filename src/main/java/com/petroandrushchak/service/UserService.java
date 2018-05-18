package com.petroandrushchak.service;

import com.petroandrushchak.dao.DAOManager;
import com.petroandrushchak.dao.UserDAO;
import com.petroandrushchak.model.User;

import java.util.List;

import static com.petroandrushchak.db.Table.USERS;

public class UserService {

    public List<User> getAllUsers(){
        DAOManager dao = DAOManager.getInstance();
        UserDAO userDAO = dao.getDAO(USERS);
        dao.close();
        return userDAO.getAllUsers();

    }
}
