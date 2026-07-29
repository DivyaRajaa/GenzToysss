package com.genztoy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.genztoy.dao.ToyDAO;
import com.genztoy.dao.OrderDAO;


@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        // Getting dashboard data

        ToyDAO toyDAO = new ToyDAO();

        OrderDAO orderDAO = new OrderDAO();


        int totalToys = toyDAO.getToyCount();

        int totalOrders = orderDAO.getOrderCount();

        double totalRevenue = orderDAO.getTotalRevenue();



        out.println("<html>");

        out.println("<head>");

        out.println("<title>Admin Dashboard</title>");



        out.println("<style>");


        out.println("body{");
        out.println("font-family:Arial;");
        out.println("background:#f8f5ff;");
        out.println("margin:0;");
        out.println("}");



        out.println("header{");
        out.println("background:#7b2cbf;");
        out.println("color:white;");
        out.println("padding:20px;");
        out.println("text-align:center;");
        out.println("}");



        out.println(".container{");
        out.println("width:700px;");
        out.println("margin:40px auto;");
        out.println("background:white;");
        out.println("padding:30px;");
        out.println("border-radius:15px;");
        out.println("box-shadow:0 5px 15px rgba(0,0,0,0.2);");
        out.println("text-align:center;");
        out.println("}");



        // Dashboard cards CSS

        out.println(".cards{");
        out.println("display:flex;");
        out.println("justify-content:center;");
        out.println("gap:20px;");
        out.println("margin:30px;");
        out.println("}");



        out.println(".card{");
        out.println("background:#f8f5ff;");
        out.println("width:170px;");
        out.println("padding:20px;");
        out.println("border-radius:15px;");
        out.println("box-shadow:0 5px 10px rgba(0,0,0,0.15);");
        out.println("}");



        out.println(".card h2{");
        out.println("color:#7b2cbf;");
        out.println("}");



        out.println(".card h1{");
        out.println("color:green;");
        out.println("}");



        out.println("a{");
        out.println("text-decoration:none;");
        out.println("}");



        out.println("button{");
        out.println("width:250px;");
        out.println("padding:15px;");
        out.println("margin:12px;");
        out.println("background:#7b2cbf;");
        out.println("color:white;");
        out.println("border:none;");
        out.println("border-radius:10px;");
        out.println("font-size:18px;");
        out.println("cursor:pointer;");
        out.println("}");



        out.println("button:hover{");
        out.println("background:#5a189a;");
        out.println("}");



        out.println("</style>");

        out.println("</head>");



        out.println("<body>");



        out.println("<header>");

        out.println("<h1>Genz Toysss Admin Panel</h1>");

        out.println("</header>");



        out.println("<div class='container'>");



        out.println("<h2>Welcome Admin</h2>");



        // Dashboard cards

        out.println("<div class='cards'>");



        out.println("<div class='card'>");
        out.println("<h2>Total Toys</h2>");
        out.println("<h1>"+totalToys+"</h1>");
        out.println("</div>");



        out.println("<div class='card'>");
        out.println("<h2>Total Orders</h2>");
        out.println("<h1>"+totalOrders+"</h1>");
        out.println("</div>");



        out.println("<div class='card'>");
        out.println("<h2>Total Revenue</h2>");
        out.println("<h1>Rs. "+totalRevenue+"</h1>");
        out.println("</div>");



        out.println("</div>");



        out.println("<a href='addtoy.html'>");
        out.println("<button>Add Toy</button>");
        out.println("</a>");

        out.println("<br>");



        out.println("<a href='ViewToyServlet'>");
        out.println("<button>View Toys</button>");
        out.println("</a>");

        out.println("<br>");



        out.println("<a href='ViewOrdersServlet'>");
        out.println("<button>View Orders</button>");
        out.println("</a>");

        out.println("<br>");



        out.println("<a href='index.html'>");
        out.println("<button>Logout</button>");
        out.println("</a>");



        out.println("</div>");



        out.println("</body>");

        out.println("</html>");

    }



    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        doGet(request,response);

    }

}