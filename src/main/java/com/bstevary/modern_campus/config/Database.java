package com.bstevary.modern_campus.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUname() {
        return dbUname;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    private String dbUrl = "jdbc:mysql://localhost:3306/Modern_Campus";
    private String dbUname = "bstevary";
    private String dbPassword = "Eble@2016!036&0206";
    private String dbDriver = "com.mysql.cj.jdbc.Driver";


    public void loadDriver() {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnectionOnly() {
        Connection connection = null ;
        try {
            connection = DriverManager.getConnection(dbUrl,dbUname,dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl,dbUname,dbPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

}
