package com.bstevary.modern_campus.interfaces.servlets;

import com.bstevary.modern_campus.services.StudentSRV;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SupperServlet", value = "/SupperServlet")
public class SupperServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
             StudentSRV StudentSRV = new StudentSRV();
             
        try {
            switch (action) {
                case "/new":
                    StudentSRV.showNewForm(request, response);
                    break;
                case "/insert":
                    StudentSRV.insertStudent(request, response);
                    break;
                case "/delete":
                    StudentSRV.deleteStudent(request, response);
                    break;
                case "/edit":
                    StudentSRV.showEditForm(request, response);
                    break;
                case "/update":
                    StudentSRV.updateStudent(request, response);
                    break;
                default:
                    StudentSRV.listStudents(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

  

}