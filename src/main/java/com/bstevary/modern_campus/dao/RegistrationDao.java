package com.bstevary.modern_campus.dao;

import com.bstevary.modern_campus.beans.CurriculmBean;
import com.bstevary.modern_campus.beans.RegistrationBean;
import com.bstevary.modern_campus.beans.UnitBean;
import com.bstevary.modern_campus.config.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RegistrationDao {
    private final String SELECT_STUDENT_UNITS ="SELECT Unit_ID FROM Caricullum WHERE Course_ID=? AND Semester = ? AND Yrs_O_Stdy = ?" ;
    Database database;

    public static boolean registerUnits(String reg_no, String unit_ID) {
        return false;
    }

    public static boolean sessionReport(String reg_no) {
        return false;
    }

    public boolean approveUnits(List<RegistrationBean> units){
        boolean status = false;
        try {
            Connection connection = database.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement prepStmt = connection.prepareStatement(
                    "insert into product(code,name,price,available) values (?,?,?,?");
            Iterator<RegistrationBean> it = units.iterator();
            while(it.hasNext()){
                RegistrationBean p = it.next();
                prepStmt.setString(1,p.getUnit_ID() );
                prepStmt.setString(2,p.getStatus() );
                prepStmt.setString(3,p.getReg_No()   );
                prepStmt.setString(4,p.getTerm_ID());
                prepStmt.addBatch();

            }
            int [] numUpdates=prepStmt.executeBatch();
            for (int i=0; i < numUpdates.length; i++) {
                if (numUpdates[i] == -2)
                    System.out.println("Execution " + i +
                            ": unknown number of rows updated");
                else {
                    status = true;
                    System.out.println("Execution " + i +
                            "successful: " + numUpdates[i] + " rows updated");
                }
            }
            connection.commit();
        } catch(SQLException b) {

        }

        return status;
    }
    public  List<UnitBean> listStudentUnits(CurriculmBean register) {
        List<UnitBean> studentUnits = new ArrayList<>();
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_UNITS);) {
             preparedStatement.setString(1,register.getCourse_ID());
             preparedStatement.setString(2, register.getSemester());
             preparedStatement.setString(3, register.getYrs_O_Stdy());

            System.out.println(preparedStatement);

           ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String Unit_ID = rs.getString("Unit_ID");
                studentUnits.add(new RegistrationDao().alx(Unit_ID,connection));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return studentUnits;
    }

    public UnitBean alx(String unit_ID,Connection connection ) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_UNITS);
            System.out.println(preparedStatement);
        preparedStatement.setString(1,unit_ID);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
                String Unit_ID = rs.getString("Unit_ID");
                String Cost = rs.getString("Cost");
                String Descriptions = rs.getString("Descriptions");
            return new UnitBean(Unit_ID,Cost,Descriptions);



    }

    private void printSQLException(SQLException e) {
    }

}
