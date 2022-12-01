package com.bstevary.modern_campus.dao;

import com.bstevary.modern_campus.beans.CurriculmBean;
import com.bstevary.modern_campus.config.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CurriculmDao {
    Database database;
    //ALFRED
    //getting of units ( Curriculum view for a StudentSRV )
    public CurriculmBean curriculum(String Reg_No) throws SQLException {
        Connection connection=database.getConnection();
        CurriculmBean curriculmBean= null;

        try{
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM Caricullum");


            while(rs.next()){
                String Unit_ID=rs.getString("Caricullum_ID");
                String Code_Name=rs.getString("Semester");
                String Instructor=rs.getString("Yrs_O_Stdy");
                double Cost=rs.getDouble("Unit_ID");

               curriculmBean =new CurriculmBean(Unit_ID, Code_Name, Instructor, Unit_ID);

            }
            connection.close();


        }catch(Exception e){
            e.printStackTrace();
        }
        return curriculmBean;
    }
    public CurriculmBean curricul4Coure(String Reg_No) throws SQLException {
        Connection connection=database.getConnection();
        CurriculmBean curriculmBean= null;

        try{
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM Caricullum");


            while(rs.next()){
                String Unit_ID=rs.getString("Caricullum_ID");
                String Code_Name=rs.getString("Semester");
                String Instructor=rs.getString("Yrs_O_Stdy");
                double Cost=rs.getDouble("Unit_ID");

                curriculmBean =new CurriculmBean(Unit_ID, Code_Name, Instructor, Unit_ID);

            }
            connection.close();


        }catch(Exception e){
            e.printStackTrace();
        }
        return curriculmBean;
    }

}
