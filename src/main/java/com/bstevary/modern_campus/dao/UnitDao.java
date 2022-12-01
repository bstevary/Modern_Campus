package com.bstevary.modern_campus.dao;

import com.bstevary.modern_campus.beans.RegistrationBean;
import com.bstevary.modern_campus.beans.UnitBean;
import com.bstevary.modern_campus.config.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnitDao {
Database database;
String SELECT_ALL_USERS, INSERT_NEW_UNIT_SQL,UPDATE_UNIT_SQL,DELETE_UNIT_SQL;
public void addUnit(UnitBean newUnit)throws SQLException{
                   try (Connection connection = database.getConnection();
                     PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_UNIT_SQL)) {
                    preparedStatement.setString(1, newUnit.getUnit_ID());
                    preparedStatement.setString(2, newUnit.getCode_Name());
                    preparedStatement.setString(3,newUnit.getInstructor());
                    preparedStatement.setDouble(4,newUnit.getCost());
                    preparedStatement.setString(5, newUnit.getDept_ID());
                    preparedStatement.setString(6, newUnit.getDescriptions());
                    System.out.println(preparedStatement);
                    preparedStatement.executeUpdate();

                } catch (SQLException e) {
                    printSQLException(e);
                }

    }
    public boolean updateUnit(UnitBean unit) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_UNIT_SQL);) {
            System.out.println("updated USer:"+statement);

            statement.setString(1, unit.getUnit_ID());
            statement.setString(2, unit.getCode_Name());
            statement.setString(3, unit.getInstructor());
            statement.setDouble(4, unit.getCost());
            statement.setString(5, unit.getDept_ID());
            statement.setString(6, unit.getDescriptions());


            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    public boolean deleteUnit(String Unit_ID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_UNIT_SQL);) {
            statement.setString(1,Unit_ID);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    public List<UnitBean> selectAllUnits() {
        List<UnitBean> unitBeans = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = database.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
               //
                String Unit_ID = rs.getString("Unit_ID");
                String Code_Name = rs.getString("Code_Name");
                String Instructor = rs.getString("Instructor");
                double Cost = rs.getDouble("Cost");
                String Dept_ID = rs.getString("Dept_ID");
                String Descriptions = rs.getString("Descriptions");
                unitBeans.add(new UnitBean(Unit_ID, Code_Name, Instructor , Dept_ID, Descriptions,Cost));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return unitBeans;
    }
    private void printSQLException(SQLException e) {

    }

    public boolean registerOneUnit(RegistrationBean units) throws SQLException{


        return false;
    }


}

