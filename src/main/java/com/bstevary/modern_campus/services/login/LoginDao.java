package com.bstevary.modern_campus.services.login;

import com.bstevary.modern_campus.common.DatabaseInfo;

import java.sql.*;

public class LoginDao {
    public static String PamSes = null;
    boolean status = false;
    DatabaseInfo Database = new DatabaseInfo();
    public void loadDriver(String dbDriver) {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        Connection con = null ;
        try {
            con = DriverManager.getConnection(Database.getDbUrl(),Database.getDbUname(),Database.getDbPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public boolean validateStudent(loginBean loginBean) {
        System.out.println("almost valid s");
                String sql = "select * from Student_Login where Username = ? and User_PWD = ?";
        return validator(loginBean,  sql);
    }


    public boolean validateStaff(loginBean loginBean) {
        boolean status = false;
        String sql = "select * from Staff_Login where Username = ? and User_PWD = ?";
        return validator(loginBean, sql);
    }

    private boolean validator(loginBean loginBean,  String sql) {
            loadDriver(Database.getDbDriver());
            Connection con = getConnection();
            PreparedStatement ps;

        try {
                ps = con.prepareStatement(sql);
                ps.setString(1,loginBean.getUsername());
                ps.setString(2, loginBean.getPassword());
                ResultSet rs = ps.executeQuery();
                status = rs.next();

        } catch (SQLException e) {
            e.printStackTrace();


        }

     return status;
    }

   }
