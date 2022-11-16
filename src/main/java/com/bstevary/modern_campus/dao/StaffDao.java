package com.bstevary.modern_campus.dao;

import com.bstevary.modern_campus.beans.StaffBean;
import com.bstevary.modern_campus.config.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDao {
    private static final String INSERT_USERS_SQL = "INSERT INTO Staff  (PF_No, Status, Contacts, F_Name, S_Name, L_Name, Email, R_NAME, N_ID, Dept_ID, Salary) VALUES "
            + " (?, ?, ?,?, ?, ?,?, ?, ?,?);";

    private static final String SELECT_USER_BY_ID = "select * from Staff where PF_No =?";
    private static final String SELECT_ALL_USERS = "select * from Staff";
    private static final String DELETE_USERS_SQL = "delete from Staff where PF_No = ?;";
    private static final String UPDATE_USERS_SQL = "update Staff set name PF_No= ?, Status= ?, Contacts= ?, F_Name= ?, S_Name= ?, L_Name= ?, Email= ?, R_NAME= ?, N_ID= ?, Dept_ID= ?, Salary= ?";

    public StaffDao() {
    }

    Database database = new Database();
    public void insertUser(StaffBean user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getPF_No());
            preparedStatement.setString(2, user.getStatus());
            preparedStatement.setString(3, user.getContacts());
            preparedStatement.setString(4, user.getF_Name());
            preparedStatement.setString(5, user.getS_Name());
            preparedStatement.setString(6, user.getL_Name());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setString(8, user.getR_NAME());
            preparedStatement.setString(9, user.getN_ID());
            preparedStatement.setString(10, user.getDept_ID());
            preparedStatement.setString(11, user.getSalary());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public StaffBean selectUser(String id) {
        StaffBean user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = database.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
//PF_No, Status, Contacts, F_Name, S_Name, L_Name, Email, Role_ID, N_ID, Dept_ID, Salary
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String PF_No = rs.getString("PF_No");
                String Status = rs.getString("Status");
                String Contacts = rs.getString("Contacts");
                String F_Name = rs.getString("F_Name");
                String S_Name = rs.getString("S_Name");
                String L_Name = rs.getString("L_Name");
                String Email = rs.getString("Email");
                String R_NAME = rs.getString("R_NAME");
                String N_ID = rs.getString("N_ID");
                String Dept_ID = rs.getString("Dept_ID");
                String Salary = rs.getString("Salary");

                user = new StaffBean( PF_No, Status, Contacts, F_Name, S_Name, L_Name, Email, R_NAME, N_ID, Dept_ID, Salary);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<StaffBean> selectAllUsers() {

        // using try-with-resources to avoid closing resources (boilerplate code)
        List<StaffBean> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = database.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String PF_No = rs.getString("PF_No");
                String Status = rs.getString("Status");
                String Contacts = rs.getString("Contacts");
                String F_Name = rs.getString("F_Name");
                String S_Name = rs.getString("S_Name");
                String L_Name = rs.getString("L_Name");
                String Email = rs.getString("Email");
                String R_NAME = rs.getString("R_NAME");
                String N_ID = rs.getString("N_ID");
                String Dept_ID = rs.getString("Dept_ID");
                String Salary = rs.getString("Salary");
                users.add(new StaffBean(PF_No, Status, Contacts, F_Name, S_Name, L_Name, Email, R_NAME, N_ID, Dept_ID, Salary));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteUser(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(StaffBean user) throws SQLException {
        boolean rowUpdated;

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            System.out.println("updated USer:"+statement);
            statement.setString(1, user.getPF_No());
            statement.setString(2, user.getStatus());
            statement.setString(3, user.getContacts());
            statement.setString(4, user.getF_Name());
            statement.setString(5, user.getS_Name());
            statement.setString(6, user.getL_Name());
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getR_NAME());
            statement.setString(9, user.getN_ID());
            statement.setString(10, user.getSalary());


            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }



}
