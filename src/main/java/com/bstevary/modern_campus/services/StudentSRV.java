package com.bstevary.modern_campus.services;

import com.bstevary.modern_campus.beans.CourseBean;
import com.bstevary.modern_campus.beans.CurriculmBean;
import com.bstevary.modern_campus.beans.StudentBean;
import com.bstevary.modern_campus.beans.UnitBean;
import com.bstevary.modern_campus.dao.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentSRV {
    private final Fee_ReceiptDao fee_receiptDao = new Fee_ReceiptDao();
    private final RegistrationDao registrationDao = new RegistrationDao();
    private final StudentDao student =  new StudentDao();
    private final CourseDao courseDao = new CourseDao();;
    public void listStudents(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<StudentBean> listUser = student.selectAllStudent();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/admin/all-students.jsp");
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            List<CourseBean> courseDropdown =courseDao.listAllCourse();
        request.setAttribute("courses" ,courseDropdown);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String Reg_No = request.getParameter("reg_No");
        StudentBean studentE = student.select_1_Student(Reg_No);

        List<CourseBean> courseDropdown =courseDao.listAllCourse();
        request.setAttribute("courses" ,courseDropdown);


        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("StudentBean", studentE);
        dispatcher.forward(request, response);

    }

    public void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
               student.insertStudent( studentInfo(request));
        response.sendRedirect("list");
    }

    public void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        StudentBean studentBean = studentInfo(request);
        student.updateStudent(studentBean);
        response.sendRedirect("list");

    }

    private StudentBean studentInfo(HttpServletRequest request) {
        String Reg_No = request.getParameter("reg_No");
        String F_Name = request.getParameter("f_Name");
        String S_Name = request.getParameter("s_Name");
        String L_Name = request.getParameter("l_Name");
        String Email = request.getParameter("email");
        String Cohort_ID = request.getParameter("cohort_ID");
        String Course_ID = request.getParameter("course_ID");
        String N_ID = request.getParameter("n_ID");
        String Contacts = request.getParameter("contacts");
        String Status = request.getParameter("status");
        String Type = request.getParameter("type");
        StudentBean studentBean = new StudentBean(F_Name,S_Name, L_Name,Email,N_ID,Contacts,Status,Reg_No,Cohort_ID, Course_ID,Type);
        return studentBean;
    }

    public void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String Reg_No = request.getParameter("reg_No");
        student.deleteSudent(Reg_No);
        response.sendRedirect("list");

    }
    public void loadCurricular(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String Course_ID = request.getParameter("Course_ID");
        String Semester = request.getParameter("Semester");
        String Yrs_O_Stdy = request.getParameter("Yrs_O_Stdy");
        CurriculmBean register = new CurriculmBean(Course_ID,Semester,Yrs_O_Stdy);
        List<UnitBean> myUnits = registrationDao.listStudentUnits(register);
        request.setAttribute("myUnits", myUnits);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }


    public void sessionReport(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String Reg_No = request.getParameter("Reg_No");
        String Status = request.getParameter("Status");
        if (Status.equals("Inactive"))
            RegistrationDao.sessionReport(Reg_No);
        response.sendRedirect("list");
    }

    public void registerUnits(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String Reg_No = request.getParameter("Reg_No");
        String Unit_ID = request.getParameter("Unit_ID");
        boolean status = RegistrationDao.registerUnits(Reg_No,Unit_ID);
        request.setAttribute("State" ,status);
        response.sendRedirect("list");

    }


    public void loadYearTranscript(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
      
        List<StudentBean> listUser = student.selectAllStudent();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }


    public void updateInfo(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String Reg_No = request.getParameter("Reg_No");
        String Email = request.getParameter("Email");
        String Contacts = request.getParameter("Contacts");

        StudentBean modifiedUser = new StudentBean(Reg_No,  Email,  Contacts);
        student.updateStudent(modifiedUser);
        response.sendRedirect("list");
    }

    public void showFeeBal(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String Reg_No = request.getParameter("Reg_No");
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("balance", fee_receiptDao.showFeeBal(Reg_No));
        dispatcher.forward(request, response);

    }

    public void showCourses(HttpServletRequest request)
            throws ServletException, IOException{
        try {
            List<CourseBean> courseDropdown =courseDao.listAllCourse();
            request.setAttribute("courses" ,courseDropdown);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
