package com.genztoy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.genztoy.dao.ToyDAO;
import com.genztoy.model.Toy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ToyServlet")
public class ToyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");


        PrintWriter out = response.getWriter();


        ToyDAO dao = new ToyDAO();


        String category = request.getParameter("category");


        ArrayList<Toy> toys;


        if(category == null) {

            toys = dao.getAllToys();

        } 
        else {

            toys = dao.getToysByCategory(category);

        }



        out.println("<html>");

        out.println("<head>");

        out.println("<title>Genz Toysss</title>");



        out.println("<style>");

        out.println("body{"
                + "font-family:Arial;"
                + "background:#f8f5ff;"
                + "margin:0;"
                + "}");


        out.println("header{"
                + "background:#7b2cbf;"
                + "color:white;"
                + "text-align:center;"
                + "padding:25px;"
                + "}");


        out.println(".container{"
                + "display:flex;"
                + "justify-content:center;"
                + "gap:30px;"
                + "flex-wrap:wrap;"
                + "padding:40px;"
                + "}");


        out.println(".card{"
                + "background:white;"
                + "width:280px;"
                + "padding:20px;"
                + "text-align:center;"
                + "border-radius:20px;"
                + "box-shadow:0 5px 15px rgba(0,0,0,0.2);"
                + "}");


        out.println(".card img{"
                + "width:230px;"
                + "height:200px;"
                + "object-fit:contain;"
                + "border-radius:15px;"
                + "}");


        out.println("h3{color:#7b2cbf;}");


        out.println(".price{"
                + "color:red;"
                + "font-size:20px;"
                + "font-weight:bold;"
                + "}");


        out.println("button{"
                + "background:#7b2cbf;"
                + "color:white;"
                + "border:none;"
                + "padding:12px 25px;"
                + "border-radius:25px;"
                + "cursor:pointer;"
                + "}");


        out.println("button:hover{"
                + "background:#5a189a;"
                + "}");


        out.println("</style>");

        out.println("</head>");



        out.println("<body>");



        out.println("<header>");

        if(category != null) {

            out.println("<h1>" + category + " Toys</h1>");

        }
        else {

            out.println("<h1>🧸 Genz Toysss</h1>");

        }

        out.println("<p>Find the Perfect Toy for Every Child</p>");

        out.println("</header>");



        out.println("<div class='container'>");



        for(Toy toy : toys) {


            out.println("<div class='card'>");


            out.println("<img src='"
                    + request.getContextPath()
                    + "/images/"
                    + toy.getImage()
                    + "'>");



            out.println("<h3>"
                    + toy.getName()
                    + "</h3>");



            out.println("<p><b>Category:</b> "
                    + toy.getCategory()
                    + "</p>");



            out.println("<p class='price'>₹"
                    + toy.getPrice()
                    + "</p>");



            out.println("<p>"
                    + toy.getDescription()
                    + "</p>");



            out.println("<a href='CartServlet?id="
                    + toy.getId()
                    + "'>");



            out.println("<button>Add to Cart</button>");



            out.println("</a>");



            out.println("</div>");

        }



        out.println("</div>");



        out.println("<center>");

        out.println("<a href='home.html'>");

        out.println("<button>Back to Home</button>");

        out.println("</a>");

        out.println("</center>");



        out.println("</body>");

        out.println("</html>");

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        doGet(request,response);

    }

}