package com.bstevary.modern_campus.security;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest Reg = (HttpServletRequest) request;
        String UserName = Reg.getParameter("UserName");
        String Password = Reg.getParameter("Password");

        chain.doFilter(request, response);
    }
}
