package com.petroandrushchak.dao;

import java.sql.Connection;

public abstract class DAO<T> {

    protected final String tableName;
    protected Connection con;

    protected DAO(Connection con, String tableName) {
        this.tableName = tableName;
        this.con = con;
    }

}
