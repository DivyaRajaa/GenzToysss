package com.genztoy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(email.equals("admin@genztoy.com") &&
           password.equals("admin123")) {

            response.sendRedirect("AdminDashboardServlet");

        } else {

            response.setContentType("text/html");

            response.getWriter().println("<h2>Invalid Admin Login!</h2>");
            response.getWriter().println("<a href='adminlogin.html'>Try Again</a>");

        }
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);

    }
}