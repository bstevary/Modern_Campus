package com.bstevary.modern_campus.dao;

import com.bstevary.modern_campus.beans.TranscriptBean;
import com.bstevary.modern_campus.config.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TranscriptDao {
    Database database;
    private static final String LOAD_YOUR_TRNASCRIPT ="SELECT * FROM transcript ";
    public TranscriptBean viewTranscript() throws SQLException {
        TranscriptBean transcript = null;
        Connection connection=database.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery(LOAD_YOUR_TRNASCRIPT);
            while (resultSet.next()){
                String CODE= resultSet.getString("CODE");
                String Reg_No=resultSet.getString("Reg_No");
                String Unit_ID=resultSet.getString("Unit_ID");
                String Exam_Marks=resultSet.getString("Exam_Marks");
                String Cat_Marks=resultSet.getString("Cat_Marks");
                String Term_ID=resultSet.getString("Term_ID");
                String Status =resultSet.getString("Status");
                transcript=new TranscriptBean(CODE,Unit_ID, Reg_No, Exam_Marks, Cat_Marks, Term_ID,Status);
            }
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return transcript;
    }


            }

