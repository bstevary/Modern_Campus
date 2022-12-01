package com.bstevary.modern_campus.dao;

import com.bstevary.modern_campus.beans.TranscriptBean;
import com.bstevary.modern_campus.beans.UnitBean;
import com.bstevary.modern_campus.config.Database;

import java.sql.*;

public class TranscriptDao {
    Database database;
    private static final String LOAD_YOUR_TRANSCRIPT ="SELECT * FROM transcript WHERE Reg_No = ? ";
    //CHECKS ON THE STATUS OF THE UNITS FOR A SPECIFIC STUDENT AND UNIT
    //input = unit_id_ and reg no. obtained from user input
    public TranscriptBean view_MY_Transcript(  String reg_NO) throws SQLException {
        TranscriptBean transcript = null;
        Connection connection=database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LOAD_YOUR_TRANSCRIPT);
            preparedStatement.setString(1, reg_NO);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String CODE= resultSet.getString("CODE");
                String Reg_No=resultSet.getString("Reg_No");
                String Unit_ID=resultSet.getString("Unit_ID");
                String Exam_Marks=resultSet.getString("Exam_Marks");
                String Cat_Marks=resultSet.getString("Cat_Marks");
                String Term_ID=resultSet.getString("Term_ID");
                String Status =resultSet.getString("Status");
                transcript=new TranscriptBean(CODE, Reg_No,Unit_ID, Exam_Marks, Cat_Marks, Term_ID,Status);
            }
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return transcript;
    }
    public String unitRegistrationStatus (  String reg_No){
        String unitStatus = "pending";
        try {
            Connection connection = database.getConnection();
            String sql = " SELECT * FROM Student_Enrollment student_reg_no =?  ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                      preparedStatement.setString(1, reg_No);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String Current_Status = resultSet.getString("status");

                unitStatus = Current_Status;

            }
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return unitStatus;
    }

    public Connection registerUnits(){
        Connection connection=database.getConnection();
        try{
            Statement st1=connection.createStatement();
            Statement st6=connection.createStatement();
            Statement st7=connection.createStatement();
            Statement st8=connection.createStatement();

            ResultSet rs1=st1.executeQuery("SELECT * FROM units WHERE Unit_ID NOT IN(SELECT Unit_ID FROM student_enrollment)");
            ResultSet rs6=st6.executeQuery("SELECT * FROM term WHERE Term_ID='T1'");
            ResultSet rs7=st7.executeQuery("SELECT * FROM student WHERE F_Name='Mohammed'");



            while(rs1.next()){
                while(rs6.next()) {
                    while (rs7.next()) {
                        String Reg_No = rs7.getString("Reg_No");
                        String Unit_ID = rs1.getString("Unit_ID");
                        String Term_ID = rs6.getString("Term_ID");

                        UnitBean user = new UnitBean(Reg_No, Unit_ID, Term_ID);

                        String sql="INSERT INTO student_enrollment(Row_ID, Reg_No, Unit_ID, Term_ID)" + "VALUES (?, ?, ?, ?)";

                        PreparedStatement statement=connection.prepareStatement(sql);
                        statement.setString(1, "C11");
                        // statement.setString(2, user.Reg_No);
                        // statement.setString(3, user.Unit_ID);
                        //statement.setString(4, user.Term_ID);
                        statement.executeUpdate();

                    }
                }
            }
            connection.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
            }}

