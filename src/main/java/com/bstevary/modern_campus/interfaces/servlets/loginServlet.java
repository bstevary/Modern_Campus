package com.bstevary.modern_campus.interfaces.servlets;

import com.bstevary.modern_campus.config.Database;
import com.bstevary.modern_campus.dao.LoginDao;
import com.bstevary.modern_campus.beans.loginBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String UserName = request.getParameter("UserName").toUpperCase();
        String Password = request.getParameter("Password");



        loginBean loginBean = new loginBean();
        loginBean.setUsername(UserName);
        loginBean.setPassword(Password);


          Database database =new Database();
        LoginDao loginDao= new LoginDao(database);

        if (UserName.startsWith("PF")){
            if(loginDao.validateStaff(loginBean))
            {
                request.setAttribute("status","success");
                HttpSession session = request.getSession();
                session.setAttribute("UserName",UserName);

                response.sendRedirect("staff/staff.jsp");
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
                //append session.setAttribute("list", list);
                HttpSession session = request.getSession();
                request.setAttribute("status","success");

                session.setAttribute("UserName",UserName);

                response.sendRedirect("student/student.jsp");
            }
            else
            {
                request.setAttribute("status ","failed");
                response.sendRedirect("login.jsp");
            }


        }

    }
   }