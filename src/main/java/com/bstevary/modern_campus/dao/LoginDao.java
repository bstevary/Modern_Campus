package com.bstevary.modern_campus.dao;

import com.bstevary.modern_campus.beans.loginBean;
import com.bstevary.modern_campus.config.Database;

import java.sql.*;

public class LoginDao {
   Database database = new Database() ;

    public boolean validateStudent(loginBean loginBean) {
        String sql = "select * from Student_Login where Username = ? and User_PWD = ?";
        return validator(loginBean,  sql);
    }


    public boolean validateStaff(loginBean loginBean) {
         String sql = "select * from Staff_Login where Username = ? and User_PWD = ?";
        return validator(loginBean, sql);
    }

    private boolean validator(loginBean loginBean,  String sql) {
            boolean status = false;
            Connection connection = database.getConnection();
            PreparedStatement preparedStatement;

        try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,loginBean.getUsername());
                preparedStatement.setString(2, loginBean.getPassword());
                ResultSet resultSet = preparedStatement.executeQuery();
                status = resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();


        }

     return status;
    }

   }
