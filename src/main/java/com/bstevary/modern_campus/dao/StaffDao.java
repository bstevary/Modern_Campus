package com.bstevary.modern_campus.dao;

import com.bstevary.modern_campus.config.Database;
import com.bstevary.modern_campus.beans.Staff;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaffDao {
    Database database;

    public ResultSet staffList() throws SQLException {
        Connection con = database.getConnection();
        String sql = "select * from Staff ";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }
    public boolean addStaff(Staff staff){

        return false;
    }
}
