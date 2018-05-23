package com.petroandrushchak.dao;

import java.sql.Connection;

public abstract class DAO<T> {

    String tableName;
    Connection con;

    DAO(Connection con, String tableName) {
        this.tableName = tableName;
        this.con = con;
    }

}
