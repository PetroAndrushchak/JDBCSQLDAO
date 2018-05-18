package com.petroandrushchak.dao;

import com.petroandrushchak.db.Table;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DAOManager {

    //Private
    private DataSource src;
    private Connection con;

    private DAOManager() throws Exception {
        try {
            InitialContext ctx = new InitialContext();
            this.src = (DataSource) ctx.lookup("jndi/MYSQL");
        } catch (Exception e) {
            throw e;
        }
    }


    public static DAOManager getInstance() {
        return DAOManagerSingleton.INSTANCE.get();
    }

    public void open() throws SQLException {
        try {
            if (this.con == null || this.con.isClosed())
                this.con = src.getConnection();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void close() throws SQLException {
        try {
            if (this.con != null && !this.con.isClosed())
                this.con.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public  DAO  getDAO(Table table) {
        DAO dao = null;
        try {
            switch (table) {
                case USERS:
                    dao = new UserDAO(this.con);
                default:
                    throw new SQLException("Trying to link to an unexistant table.");
            }
        } catch (SQLException e) {
            System.out.println("dfsdf");
        }
        return dao;
    }


    private static class DAOManagerSingleton {

        public static final ThreadLocal<DAOManager> INSTANCE;

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
