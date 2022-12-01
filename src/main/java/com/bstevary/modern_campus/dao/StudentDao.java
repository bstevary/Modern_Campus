package com.bstevary.modern_campus.dao;

import com.bstevary.modern_campus.beans.StudentBean;
import com.bstevary.modern_campus.config.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
       private static final String INSERT_USERS_SQL = "INSERT INTO Student" + "  (Reg_No, F_Name, S_Name, L_Name, Email, Cohort_ID, Course_ID, N_ID, Contacts, Status, Type) VALUES "
            + " (?, ?, ?,?, ?, ?, ?, ?,?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select Reg_No, F_Name, S_Name, L_Name, Email, Cohort_ID, Course_ID, N_ID, Contacts, Status, Type from Student where Reg_No =?";
    private static final String SELECT_ALL_USERS = "select * from Student";
    private static final String DELETE_USERS_SQL = "delete from Student where Reg_No = ?;";
    private static final String UPDATE_USERS_SQL = "update Student set Reg_No= ?, F_Name= ?, S_Name= ?, L_Name= ?,Cohort_ID= ?, Email= ?,Course_ID= ?, N_ID= ?, Contacts= ?, Status= ?, Type= ? where Reg_No = ?;";

    public StudentDao() {
    }

  Database database = new Database();
    public void insertStudent(StudentBean student) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, student.getReg_No());
            preparedStatement.setString(2, student.getF_Name());
            preparedStatement.setString(3, student.getS_Name());
            preparedStatement.setString(4, student.getL_Name());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getCohort_ID());
            preparedStatement.setString(7, student.getCourse_ID());
            preparedStatement.setString(8, student.getN_ID());
            preparedStatement.setString(9, student.getContacts());
            preparedStatement.setString(10, student.getStatus());
            preparedStatement.setString(11, student.getType());
           System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public StudentBean select_1_Student(String reg_NO) {
        StudentBean user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = database.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setString(1, reg_NO);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
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
                String Status = rs.getString("Status");
                String Type = rs.getString("Type");
                user = new StudentBean( F_Name,S_Name, L_Name,Email,N_ID,Contacts,Status,Reg_No,Cohort_ID, Course_ID,Type);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<StudentBean> selectAllStudent() {

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
                String Status = rs.getString("Status");
                String Type = rs.getString("Type");
                users.add(new StudentBean(F_Name,S_Name, L_Name,Email,N_ID,Contacts,Status,Reg_No,Cohort_ID, Course_ID,Type));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteSudent(String reg_NO) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setString(1, reg_NO);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateStudent(StudentBean studentBean) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, studentBean.getReg_No());
            statement.setString(2, studentBean.getF_Name());
            statement.setString(3, studentBean.getS_Name());
            statement.setString(4, studentBean.getL_Name());
            statement.setString(5, studentBean.getCohort_ID());
            statement.setString(6, studentBean.getEmail());
            statement.setString(7, studentBean.getCourse_ID());
            statement.setString(8, studentBean.getN_ID());
            statement.setString(9,studentBean.getContacts());
            statement.setString(10,studentBean.getStatus());
            statement.setString(11,studentBean.getType());
            statement.setString(12,studentBean.getReg_No());
            System.out.println("updated USer:"+statement);

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

    public void insertUser(StudentBean newStudent) {
    }

    public void createLoginEntry (String Reg_No,String Email) {

            }
}
