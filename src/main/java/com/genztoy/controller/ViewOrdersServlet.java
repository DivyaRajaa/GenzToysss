package com.genztoy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.genztoy.dao.OrderDAO;
import com.genztoy.model.Order;


@WebServlet("/ViewOrdersServlet")
public class ViewOrdersServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");


        PrintWriter out = response.getWriter();


        OrderDAO dao = new OrderDAO();


        ArrayList<Order> orders = dao.getAllOrders();



        out.println("<html>");
        out.println("<head>");

        out.println("<title>View Orders</title>");

        out.println("<style>");

        out.println("body{font-family:Arial;background:#f5f0ff;}");

        out.println("h1{text-align:center;color:#7b2cbf;}");

        out.println("table{width:90%;margin:auto;background:white;border-collapse:collapse;}");

        out.println("th{background:#7b2cbf;color:white;padding:12px;}");

        out.println("td{padding:12px;border:1px solid #ddd;text-align:center;}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");


        out.println("<h1>Customer Orders</h1>");


        out.println("<table>");

        out.println("<tr>");

        out.println("<th>Order ID</th>");
        out.println("<th>Customer Name</th>");
        out.println("<th>Toy Name</th>");
        out.println("<th>Quantity</th>");
        out.println("<th>Total Price</th>");
        out.println("<th>Order Date</th>");

        out.println("</tr>");



        for(Order order : orders) {


            out.println("<tr>");

            out.println("<td>"+order.getId()+"</td>");

            out.println("<td>"+order.getCustomerName()+"</td>");

            out.println("<td>"+order.getToyName()+"</td>");

            out.println("<td>"+order.getQuantity()+"</td>");

            out.println("<td>₹"+order.getTotalPrice()+"</td>");

            out.println("<td>"+order.getOrderDate()+"</td>");

            out.println("</tr>");

        }



        out.println("</table>");


        out.println("<br><center>");

        out.println("<a href='AdminDashboardServlet'>Back to Dashboard</a>");

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