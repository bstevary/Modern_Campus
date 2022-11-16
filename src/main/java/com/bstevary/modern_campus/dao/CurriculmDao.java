package com.bstevary.modern_campus.dao;

import com.bstevary.modern_campus.beans.CurriculmBean;
import com.bstevary.modern_campus.beans.UnitBean;
import com.bstevary.modern_campus.config.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CurriculmDao {
    Database database;
    //ALFRED
    //getting of units ( Curriculum view for a student )
    public Connection getUnits() throws SQLException {
        Connection connection=database.getConnection();

        try{
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM units");


            while(rs.next()){
                String Unit_ID=rs.getString("Unit_ID");
                String Code_Name=rs.getString("Code_Name");
                String Instructor=rs.getString("Instructor");
                double Cost=rs.getDouble("Cost");

               // UnitBean user=new CurriculmBean(Unit_ID, Code_Name, Instructor, Cost);

            }
            connection.close();


        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }


}
