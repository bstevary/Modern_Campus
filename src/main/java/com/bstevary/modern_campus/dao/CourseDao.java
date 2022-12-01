package com.bstevary.modern_campus.dao;

import com.bstevary.modern_campus.beans.CourseBean;
import com.bstevary.modern_campus.config.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    Database database = new Database();
    private static final String INSERT_COURSE_SQL = "INSERT INTO Course  (Course_ID, Course_Name, Dept_ID, Caricullum_ID) VALUES (?,?,?,?);";
    private static final String SELECT_COURSE_BY_ID = "SELECT Course_ID, Course_Name, Dept_ID, Caricullum_ID FROM Course WHERE Course_ID=?;";
    private static final String SELECT_ALL_COURSES = "SELECT * FROM Course;";
    private static final String DELETE_COURSE_SQL = "DELETE FROM Course WHERE id = ?";
    private static final String UPDATE_COURSE_SQL = " UPDATE course SET Course_ID=?, Course_Name=?, Dept_ID=?, Caricullum_ID=? WHERE Course_ID=?;";
    private String SELECT_COURSES= "select * from Course";
    //creating a connection method
    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = database.getConnection();
        return connection;
    }


    //  SHADRACK
    //CREATING A NEW COURSE
    //Create a new course
    public void createCourse(CourseBean course) throws SQLException{
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COURSE_SQL)) {
            preparedStatement.setString(1, course.getCourse_ID());
            preparedStatement.setString(2, course.getCourse_Name());
            preparedStatement.setString(3, course.getDept_ID());
            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //SHADRACK
    //UPDATING A COURSE IN SYSTEM
    public boolean updateCourse(CourseBean course) throws SQLException{
        boolean rowUpdated;


        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COURSE_SQL)) {

            preparedStatement.setString(1, course.getCourse_ID());
            preparedStatement.setString(2, course.getCourse_Name());
            preparedStatement.setString(3, course.getDept_ID());
             rowUpdated = preparedStatement.executeUpdate() > 0;
            if (rowUpdated==true){
                System.out.println("Course updated");
            }else{
                System.out.println("Course not updated");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }


    // SHADRACK
    //Select course by id OR SEARCHING COURSE USING ID
    public CourseBean selectCourseById(String course_ID) throws SQLException {
        CourseBean course = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURSE_BY_ID);) {
            preparedStatement.setString(1, course_ID);

            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                String Course_ID = resultSet.getString("Course_ID");
                String Course_Name = resultSet.getString("Course_Name");
                String Dept_ID = resultSet.getString("Dept_ID");
                 course = new CourseBean(Course_ID, Course_Name, Dept_ID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return course;
    }





    //SHADRACK
    //delete COURSE USING ID
    public boolean deleteCourse(String Course_ID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COURSE_SQL);) {
            preparedStatement.setString(1, Course_ID);
            rowDeleted = preparedStatement.executeUpdate() > 0;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }
    public List<CourseBean> listAllCourse() throws SQLException{
        List<CourseBean> courses =new ArrayList<>();
        try {
            Connection connection= database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery(SELECT_COURSES);
            while (resultSet.next()){
                String Course_ID = resultSet.getString("Course_ID");
                String  Course_Name=resultSet.getString("Course_Name");
                String Dept_ID = resultSet.getString("Dept_ID");
                courses.add(new CourseBean(Course_ID, Course_Name, Dept_ID));
            }
            System.out.println(courses);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }
}
