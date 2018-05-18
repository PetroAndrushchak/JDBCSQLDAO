package com.petroandrushchak.db;

public enum Table {

    USERS("users");

    private String tableName;

    Table(String tableName) {
        this.tableName = tableName;
    }

    public String tableName() {
        return tableName;
    }


}
