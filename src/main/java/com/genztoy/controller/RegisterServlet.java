package com.genztoy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.genztoy.dao.UserDAO;
import com.genztoy.model.User;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");


        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);



        UserDAO dao = new UserDAO();


        boolean result = dao.registerUser(user);



        PrintWriter out = response.getWriter();



        if(result) {


            out.println("<html>");
            out.println("<head>");

            out.println("<title>Registration Success</title>");


            out.println("<style>");

            out.println("body{"
                    + "font-family:Arial;"
                    + "background:linear-gradient(135deg,#f3e8ff,#ffffff);"
                    + "height:100vh;"
                    + "display:flex;"
                    + "justify-content:center;"
                    + "align-items:center;"
                    + "margin:0;"
                    + "}");


            out.println(".success-box{"
                    + "background:white;"
                    + "width:380px;"
                    + "padding:40px;"
                    + "text-align:center;"
                    + "border-radius:20px;"
                    + "box-shadow:0 10px 30px rgba(0,0,0,0.2);"
                    + "}");


            out.println("h1{"
                    + "color:#7b2cbf;"
                    + "font-size:35px;"
                    + "}");


            out.println("h2{"
                    + "color:green;"
                    + "}");


            out.println("p{"
                    + "font-size:18px;"
                    + "}");


            out.println("a{"
                    + "display:inline-block;"
                    + "margin-top:20px;"
                    + "background:#7b2cbf;"
                    + "color:white;"
                    + "padding:14px 35px;"
                    + "border-radius:25px;"
                    + "text-decoration:none;"
                    + "font-size:16px;"
                    + "}");


            out.println("a:hover{"
                    + "background:#5a189a;"
                    + "}");


            out.println("</style>");

            out.println("</head>");



            out.println("<body>");


            out.println("<div class='success-box'>");


            out.println("<h1>🧸 Genz Toysss</h1>");


            out.println("<h2>✅ Registration Successful!</h2>");


            out.println("<p>Welcome " + name + "</p>");


            out.println("<p>Your account has been created successfully.</p>");


            out.println("<a href='login.html'>Login Now</a>");


            out.println("</div>");


            out.println("</body>");

            out.println("</html>");



        } 
        else {


            out.println("<html>");
            out.println("<head>");

            out.println("<style>");

            out.println("body{"
                    + "font-family:Arial;"
                    + "text-align:center;"
                    + "padding-top:100px;"
                    + "}");


            out.println("a{color:purple;}");

            out.println("</style>");

            out.println("</head>");


            out.println("<body>");


            out.println("<h2>❌ Registration Failed!</h2>");

            out.println("<p>Please try again.</p>");

            out.println("<a href='register.html'>Go Back</a>");


            out.println("</body>");

            out.println("</html>");

        }

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request,response);

    }

}