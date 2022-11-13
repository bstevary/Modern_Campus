package com.bstevary.modern_campus.services.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String UserName = request.getParameter("UserName").toUpperCase();
        String Password = request.getParameter("Password");

        System.out.println("in servlet");

        loginBean loginBean = new loginBean();
                    loginBean.setUsername(UserName);
                    loginBean.setPassword(Password);

        HttpSession session = request.getSession();

        LoginDao loginDao= new LoginDao();

        if (UserName.startsWith("PF")){
            if(loginDao.validateStaff(loginBean))
            {
                request.setAttribute("status","success");

                session.setAttribute("UserName",UserName);

                response.sendRedirect("staff.jsp");
            }
            else
            {
                request.setAttribute("status ","failed");
                response.sendRedirect("login.jsp");
            }

                    }
        else {
            System.out.println("students");
            if(loginDao.validateStudent(loginBean))
            {
                request.setAttribute("status","success");

                session.setAttribute("UserName",UserName);

                response.sendRedirect("/student/student.jsp");
            }
            else
            {
                request.setAttribute("status ","failed");
                response.sendRedirect("login.jsp");
            }


        }

    }
   }