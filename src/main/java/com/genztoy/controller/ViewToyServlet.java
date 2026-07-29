package com.genztoy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genztoy.dao.ToyDAO;
import com.genztoy.model.Toy;

@WebServlet("/ViewToyServlet")
public class ViewToyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        ToyDAO dao = new ToyDAO();

        ArrayList<Toy> toys = dao.getAllToys();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Toys</title>");

        out.println("<style>");

        out.println("body{font-family:Arial;background:#f5f0ff;margin:0;}");

        out.println("h1{text-align:center;color:#7b2cbf;padding:20px;}");

        out.println("table{width:95%;margin:auto;border-collapse:collapse;background:white;}");

        out.println("th{background:#7b2cbf;color:white;padding:12px;}");

        out.println("td{padding:12px;border:1px solid #ddd;text-align:center;}");

        out.println("img{width:80px;height:80px;object-fit:contain;}");

        out.println("button{padding:8px 15px;border:none;border-radius:5px;cursor:pointer;color:white;}");

        out.println(".edit{background:#28a745;}");

        out.println(".delete{background:#dc3545;}");

        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<h1>All Toys</h1>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Image</th>");
        out.println("<th>Name</th>");
        out.println("<th>Category</th>");
        out.println("<th>Price</th>");
        out.println("<th>Stock</th>");
        out.println("<th>Edit</th>");
        out.println("<th>Delete</th>");
        out.println("</tr>");

        for(Toy toy : toys){

            out.println("<tr>");

            out.println("<td>"+toy.getId()+"</td>");

            out.println("<td><img src='"+request.getContextPath()+"/images/"+toy.getImage()+"'></td>");

            out.println("<td>"+toy.getName()+"</td>");

            out.println("<td>"+toy.getCategory()+"</td>");

            out.println("<td>₹"+toy.getPrice()+"</td>");

            out.println("<td>"+toy.getStock()+"</td>");

            out.println("<td>");
            out.println("<a href='EditToyServlet?id="+toy.getId()+"'>");
            out.println("<button class='edit'>Edit</button>");
            out.println("</a>");
            out.println("</td>");

            out.println("<td>");
            out.println("<a href='DeleteToyServlet?id="+toy.getId()+"'>");
            out.println("<button class='delete'>Delete</button>");
            out.println("</a>");
            out.println("</td>");

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