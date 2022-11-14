package com.bstevary.modern_campus.dao;

import com.bstevary.modern_campus.beans.loginBean;
import com.bstevary.modern_campus.config.Database;

import java.sql.*;

public class LoginDao {

    boolean status = false;
    com.bstevary.modern_campus.config.Database Database;

    public boolean validateStudent(loginBean loginBean) {
        String sql = "select * from Student_Login where Username = ? and User_PWD = ?";
        return validator(loginBean,  sql);
    }


    public boolean validateStaff(loginBean loginBean) {
        boolean status = false;
        String sql = "select * from Staff_Login where Username = ? and User_PWD = ?";
        return validator(loginBean, sql);
    }

    private boolean validator(loginBean loginBean,  String sql) {
            Database.loadDriver();
            Connection connection = Database.getConnection();
            PreparedStatement ps;

        try {
                ps = connection.prepareStatement(sql);
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
