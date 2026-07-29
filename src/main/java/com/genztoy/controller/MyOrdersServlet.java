package com.genztoy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.genztoy.dao.OrderDAO;
import com.genztoy.model.Order;

@WebServlet("/MyOrdersServlet")
public class MyOrdersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Demo email (later this will come from logged-in user)
        String email = "customer@gmail.com";

        OrderDAO dao = new OrderDAO();

        ArrayList<Order> orders = dao.getOrdersByEmail(email);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>My Orders</title>");

        out.println("<style>");
        out.println("body{font-family:Arial;background:#f8f5ff;}");
        out.println("h1{text-align:center;color:#7b2cbf;}");
        out.println("table{width:90%;margin:auto;border-collapse:collapse;background:white;}");
        out.println("th{background:#7b2cbf;color:white;padding:12px;}");
        out.println("td{padding:12px;border:1px solid #ddd;text-align:center;}");
        out.println("a{text-decoration:none;color:white;}");
        out.println("button{background:#7b2cbf;color:white;padding:10px 20px;border:none;border-radius:8px;cursor:pointer;}");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<h1>My Orders</h1>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>Order ID</th>");
        out.println("<th>Toy Name</th>");
        out.println("<th>Quantity</th>");
        out.println("<th>Total Price</th>");
        out.println("<th>Order Date</th>");
        out.println("</tr>");

        for(Order order : orders){

            out.println("<tr>");

            out.println("<td>"+order.getId()+"</td>");
            out.println("<td>"+order.getToyName()+"</td>");
            out.println("<td>"+order.getQuantity()+"</td>");
            out.println("<td>Rs. "+order.getTotalPrice()+"</td>");
            out.println("<td>"+order.getOrderDate()+"</td>");

            out.println("</tr>");

        }

        out.println("</table>");

        out.println("<br><center>");
        out.println("<a href='home.html'>");
        out.println("<button>Back Home</button>");
        out.println("</a>");
        out.println("</center>");

        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request,response);

    }
}