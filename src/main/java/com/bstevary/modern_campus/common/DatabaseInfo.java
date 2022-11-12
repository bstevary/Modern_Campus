package com.bstevary.modern_campus.common;

public class DatabaseInfo {
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
}
