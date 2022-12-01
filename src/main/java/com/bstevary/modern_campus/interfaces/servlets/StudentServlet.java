package com.bstevary.modern_campus.interfaces.servlets;

import com.bstevary.modern_campus.services.StudentSRV;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentSRV studentSRV;

    public void init() {
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
                case "/curriculum":
                    studentSRV.loadCurricular(request, response);
                    break;
                case "/report":
                    studentSRV.sessionReport(request, response);
                    break;
                case "/register":
                    studentSRV.registerUnits(request, response);
                    break;
                case "/transcript":
                    studentSRV.loadYearTranscript(request, response);
                    break;
                case "/update":
                    studentSRV.updateInfo(request, response);
                    break;
                default:
                    studentSRV.showFeeBal(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


}



