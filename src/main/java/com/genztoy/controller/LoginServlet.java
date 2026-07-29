package com.genztoy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.genztoy.dao.UserDAO;
import com.genztoy.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("text/html");


        String email = request.getParameter("email");
        String password = request.getParameter("password");


        System.out.println("Email: " + email);
        System.out.println("Password: " + password);


        UserDAO dao = new UserDAO();


        User user = dao.loginUser(email, password);


        PrintWriter out = response.getWriter();


        if(user != null) {


            HttpSession session = request.getSession();

            session.setAttribute("user", user);


            // After login go to home page
            response.sendRedirect("home.html");


        }
        else {


            out.println("<html>");
            out.println("<body>");

            out.println("<h2>Invalid Email or Password!</h2>");

            out.println("<a href='login.html'>Try Again</a>");

            out.println("</body>");
            out.println("</html>");

        }

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);

    }

}