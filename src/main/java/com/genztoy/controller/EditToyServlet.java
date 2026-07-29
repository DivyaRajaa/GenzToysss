package com.genztoy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.genztoy.dao.ToyDAO;
import com.genztoy.model.Toy;

@WebServlet("/EditToyServlet")
public class EditToyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ToyDAO dao = new ToyDAO();

        Toy toy = dao.getToyById(id);

        request.setAttribute("toy", toy);

        request.getRequestDispatcher("edittoy.jsp").forward(request, response);

    }

}