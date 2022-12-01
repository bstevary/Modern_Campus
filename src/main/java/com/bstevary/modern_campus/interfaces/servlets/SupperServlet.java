package com.bstevary.modern_campus.interfaces.servlets;

import com.bstevary.modern_campus.beans.StudentBean;
import com.bstevary.modern_campus.dao.StudentDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SupperServlet", value = "/SupperServlet")
public class SupperServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao user;

    public void init() {
        user = new StudentDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<StudentBean> listUser = user.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String Reg_No = request.getParameter("Reg_No");
        StudentBean existingUser = user.selectUser(Reg_No);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String Reg_No = request.getParameter("Reg_No");
        String F_Name = request.getParameter("F_Name");
        String S_Name = request.getParameter("S_Name");
        String L_Name = request.getParameter("L_Name");
        String Email = request.getParameter("Email");
        String Cohort_ID = request.getParameter("Cohort_ID");
        String Course_ID = request.getParameter("Course_ID");
        String N_ID = request.getParameter("N_ID");
        String Contacts = request.getParameter("Contacts");
        String Status = request.getParameter("Status");
        String Type = request.getParameter("Type");
        StudentBean newUser = new StudentBean(Reg_No, F_Name, S_Name, L_Name, Email, Cohort_ID, Course_ID, N_ID, Contacts, Status, Type);
        user.insertUser(newUser);
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String Reg_No = request.getParameter("Reg_No");
        String F_Name = request.getParameter("F_Name");
        String S_Name = request.getParameter("S_Name");
        String L_Name = request.getParameter("L_Name");
        String Email = request.getParameter("Email");
        String Cohort_ID = request.getParameter("Cohort_ID");
        String Course_ID = request.getParameter("Course_ID");
        String N_ID = request.getParameter("N_ID");
        String Contacts = request.getParameter("Contacts");
        String Status = request.getParameter("Status");
        String Type = request.getParameter("Type");
        StudentBean modifiedUser = new StudentBean(Reg_No, F_Name, S_Name, L_Name, Email, Cohort_ID, Course_ID, N_ID, Contacts, Status, Type);
        user.updateUser(modifiedUser);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String Reg_No = request.getParameter("Reg_No");
        user.deleteUser(Reg_No);
        response.sendRedirect("list");

    }

}