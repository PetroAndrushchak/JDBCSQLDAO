package com.petroandrushchak.dao;

import com.petroandrushchak.db.ConnectionManager;
import com.petroandrushchak.db.Table;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOManager implements AutoCloseable{

    private Connection con;

    private DAOManager(){
    }

    public static DAOManager getInstance() {
        return DAOManagerSingleton.INSTANCE.get();
    }

    private void open() {
        try {
            if (this.con == null || this.con.isClosed())
                this.con = ConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public void close() {
        try {
            if (this.con != null && !this.con.isClosed())
                this.con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public  DAO  getDAO(Table table) {
        DAO dao = null;
        open();
        try {
            switch (table) {
                case USERS:
                    dao = new UserDAO(this.con);
                    break;
                default:
                    throw new SQLException("Trying to link to an unexistant table.");
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return dao;
    }


    private static class DAOManagerSingleton {

        static final ThreadLocal<DAOManager> INSTANCE;

        static {
            ThreadLocal<DAOManager> dm;
            try {
                dm = new ThreadLocal<DAOManager>() {
                    @Override
                    protected DAOManager initialValue() {
                        try {
                            return new DAOManager();
                        } catch (Exception e) {
                            return null;
                        }
                    }
                };

            } catch (Exception e) {
                dm = null;
            }
            INSTANCE = dm;
        }
    }
}
