package com.genztoy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.genztoy.dao.ToyDAO;
import com.genztoy.model.Toy;

@WebServlet("/UpdateToyServlet")
public class UpdateToyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Toy toy = new Toy();

        toy.setId(Integer.parseInt(request.getParameter("id")));
        toy.setName(request.getParameter("name"));
        toy.setCategory(request.getParameter("category"));
        toy.setPrice(Double.parseDouble(request.getParameter("price")));
        toy.setDescription(request.getParameter("description"));
        toy.setStock(Integer.parseInt(request.getParameter("stock")));
        toy.setImage(request.getParameter("image"));

        ToyDAO dao = new ToyDAO();

        boolean status = dao.updateToy(toy);

        if(status){

            response.sendRedirect("ViewToyServlet");

        }else{

            response.getWriter().println("<h2>Failed to Update Toy!</h2>");

        }

    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request,response);

    }

}