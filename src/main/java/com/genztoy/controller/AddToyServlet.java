package com.genztoy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genztoy.dao.ToyDAO;
import com.genztoy.model.Toy;

@WebServlet("/AddToyServlet")
public class AddToyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int stock = Integer.parseInt(request.getParameter("stock"));
        String image = request.getParameter("image");

        Toy toy = new Toy();

        toy.setName(name);
        toy.setCategory(category);
        toy.setPrice(price);
        toy.setDescription(description);
        toy.setStock(stock);
        toy.setImage(image);

        ToyDAO dao = new ToyDAO();

        boolean status = dao.addToy(toy);

        response.setContentType("text/html");

        if(status) {

            response.getWriter().println("<h2>Toy Added Successfully!</h2>");
            response.getWriter().println("<br><a href='AdminDashboardServlet'>Back to Dashboard</a>");

        } else {

            response.getWriter().println("<h2>Failed to Add Toy!</h2>");

        }

    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);

    }
}