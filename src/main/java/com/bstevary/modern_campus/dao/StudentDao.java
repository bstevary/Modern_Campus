package com.bstevary.modern_campus.dao;

import com.bstevary.modern_campus.beans.StudentBean;
import com.bstevary.modern_campus.config.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
       private static final String INSERT_USERS_SQL = "INSERT INTO Student" + "  (Reg_No, F_Name, S_Name, L_Name, Email, Cohort_ID, Course_ID, N_ID, Contacts, Status, Type) VALUES "
            + " (?, ?, ?,?, ?, ?, ?, ?,?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select Reg_No, F_Name, S_Name, L_Name, Email, Cohort_ID, Course_ID, N_ID, Contacts, Status, Type from Student where reg_No =?";
    private static final String SELECT_ALL_USERS = "select * from Student";
    private static final String DELETE_USERS_SQL = "delete from Student where reg_No = ?;";
    private static final String UPDATE_USERS_SQL = "update Student set name Reg_No= ?, F_Name= ?, S_Name= ?, L_Name= ?, Email= ?, Cohort_ID= ?, Course_ID= ?, N_ID= ?, Contacts= ?, Status= ?, Type= ? where reg_No = ?;";

    public StudentDao() {
    }

  Database database = new Database();
    public void insertUser(StudentBean user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getReg_No());
            preparedStatement.setString(2, user.getF_Name());
            preparedStatement.setString(3, user.getS_Name());
            preparedStatement.setString(4, user.getL_Name());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getCohort_ID());
            preparedStatement.setString(8, user.getCourse_ID());
            preparedStatement.setString(9, user.getN_ID());
            preparedStatement.setString(10, user.getContacts());
            preparedStatement.setString(11, user.getStatus());
            preparedStatement.setString(12, user.getType());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public StudentBean selectUser(String id) {
        StudentBean user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = database.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
// Reg_No, F_Name, S_Name, L_Name, D_O_B, Email, Cohort_ID, Course_ID, N_ID, Contacts, Status, Type
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String Reg_No = rs.getString("Reg_No");
                String F_Name = rs.getString("F_Name");
                String S_Name = rs.getString("S_Name");
                String L_Name = rs.getString("L_Name");
                String country = rs.getString("S_Name");
                String Email = rs.getString("Email");
                String Cohort_ID = rs.getString("Cohort_ID");
                String Course_ID = rs.getString("Course_ID");
                String N_ID = rs.getString("N_ID");
                String Contacts = rs.getString("Contacts");
                String Status = rs.getString("S_Name");
                String Type = rs.getString("Type");
                user = new StudentBean( Reg_No, F_Name, S_Name, L_Name, Email, Cohort_ID, Course_ID, N_ID, Contacts, Status, Type);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<StudentBean> selectAllUsers() {

        // using try-with-resources to avoid closing resources (boilerplate code)
        List<StudentBean> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = database.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
//Reg_No, F_Name, S_Name, L_Name, D_O_B, Email, Cohort_ID, Course_ID, N_ID, Contacts, Status, Type)
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String Reg_No = rs.getString("Reg_No");
                String F_Name = rs.getString("F_Name");
                String S_Name = rs.getString("S_Name");
                String L_Name = rs.getString("L_Name");
                String Email = rs.getString("Email");
                String Cohort_ID = rs.getString("Cohort_ID");
                String Course_ID = rs.getString("Course_ID");
                String N_ID = rs.getString("N_ID");
                String Contacts = rs.getString("Contacts");
                String Status = rs.getString("S_Name");
                String Type = rs.getString("Type");
                users.add(new StudentBean(Reg_No, F_Name, S_Name, L_Name, Email, Cohort_ID, Course_ID, N_ID, Contacts, Status, Type));
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

    public boolean updateUser(StudentBean user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            System.out.println("updated USer:"+statement);
            statement.setString(1, user.getReg_No());
            statement.setString(2, user.getF_Name());
            statement.setString(3, user.getS_Name());
            statement.setString(4, user.getL_Name());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getCohort_ID());
            statement.setString(8, user.getCourse_ID());
            statement.setString(9, user.getN_ID());
            statement.setString(10, user.getContacts());
            statement.setString(11, user.getStatus());
            statement.setString(12, user.getType());

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
