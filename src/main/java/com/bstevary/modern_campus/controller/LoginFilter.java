package com.bstevary.modern_campus.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse res=(HttpServletResponse) response;
        HttpServletRequest req= (HttpServletRequest) request;
        HttpSession session = req.getSession();
        String userid= (String) session.getAttribute("userid");
        System.out.println("inside filter");
        if(userid !=null) {
            chain.doFilter(request, response);
        }else {

            res.sendRedirect(req.getContextPath()+"/index.jsp");
        }

    }
}
