package com.bstevary.modern_campus.services.login;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {


    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

                response.sendRedirect("index.jsp");
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

                session.setAttribute("UserName",LoginDao.PamSes);

                response.sendRedirect("./student/home.jsp");
            }
            else
            {
                request.setAttribute("status ","failed");
                response.sendRedirect("login.jsp");
            }


        }




    }

    public void destroy() {
    }
}