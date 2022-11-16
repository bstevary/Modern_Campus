package com.bstevary.modern_campus.dao;

import com.bstevary.modern_campus.beans.CourseBean;
import com.bstevary.modern_campus.config.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    Database database;
    private static final String INSERT_COURSE_SQL = "INSERT INTO Course  (Course_ID, Course_Name, Dept_ID, Caricullum_ID) VALUES (?,?,?,?);";
    private static final String SELECT_COURSE_BY_ID = "SELECT Course_ID, Course_Name, Dept_ID, Caricullum_ID FROM Course WHERE Course_ID=?;";
    private static final String SELECT_ALL_COURSES = "SELECT * FROM course;";
    private static final String DELETE_COURSE_SQL = "DELETE FROM Course WHERE id = ?";
    private static final String UPDATE_COURSE_SQL = " UPDATE course SET Course_ID=?, Course_Name=?, Dept_ID=?, Caricullum_ID=? WHERE Course_ID=?;";

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
            preparedStatement.setString(4, course.getCaricullum_ID());
            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //SHADRACK
    //UPDATING A COURSE IN SYSTEM
    public boolean updateCourse(CourseBean course) throws SQLException{
        boolean rowUpdated = false;


        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COURSE_SQL)) {

            preparedStatement.setString(1, course.getCourse_ID());
            preparedStatement.setString(2, course.getCourse_Name());
            preparedStatement.setString(3, course.getCaricullum_ID());
            preparedStatement.setString(4, course.getDept_ID());
            //preparedStatement.setString(5, course.);
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
    public CourseBean selectCourseById(String Course_ID) throws SQLException {
        CourseBean course = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURSE_BY_ID);) {
            preparedStatement.setString(1, Course_ID);

            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String Duration = resultSet.getString("duration");
                String DepartmentId = resultSet.getString("department_id");
                course = new CourseBean(id, name, Duration, DepartmentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return course;
    }


    //SHADRACK
    //select all courses in the database AND RETURNING A LIST
    public List<CourseBean> selectAllCourse() {
        List<CourseBean> course = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COURSES);) {


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String id = resultSet.getString("id");
                String Duration = resultSet.getString("duration");
                String DepartmentId = resultSet.getString("department_id");
                course.add(new CourseBean(id, name, Duration, DepartmentId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return course;
    }


    //SHADRACK
    //delete COURSE USING ID
    public boolean deleteCourse(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COURSE_SQL);) {
            preparedStatement.setString(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
            if(rowDeleted==true){
                System.out.println("Row deleted");
            }else{
                System.out.println("Row not deleted");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

}
