package com.genztoy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.genztoy.model.CartItem;


@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");


        HttpSession session = request.getSession();


        ArrayList<CartItem> cart =
                (ArrayList<CartItem>) session.getAttribute("cart");



        response.getWriter().println("<html>");

        response.getWriter().println("<head>");

        response.getWriter().println("<title>My Cart</title>");



        response.getWriter().println("<style>");

        response.getWriter().println(
        "body{"
        +"font-family:Arial;"
        +"background:#f8f5ff;"
        +"margin:0;"
        +"text-align:center;"
        +"}"
        );


        response.getWriter().println(
        "h1{"
        +"background:#7b2cbf;"
        +"color:white;"
        +"padding:25px;"
        +"}"
        );


        response.getWriter().println(
        ".cart-box{"
        +"width:80%;"
        +"margin:30px auto;"
        +"background:white;"
        +"padding:20px;"
        +"border-radius:20px;"
        +"box-shadow:0 5px 20px rgba(0,0,0,0.2);"
        +"}"
        );


        response.getWriter().println(
        "table{"
        +"width:100%;"
        +"border-collapse:collapse;"
        +"}"
        );


        response.getWriter().println(
        "th{"
        +"background:#7b2cbf;"
        +"color:white;"
        +"padding:15px;"
        +"}"
        );


        response.getWriter().println(
        "td{"
        +"padding:15px;"
        +"border-bottom:1px solid #ddd;"
        +"}"
        );


        response.getWriter().println(
        "img{"
        +"width:90px;"
        +"height:90px;"
        +"object-fit:contain;"
        +"}"
        );


        response.getWriter().println(
        "button{"
        +"background:#7b2cbf;"
        +"color:white;"
        +"border:none;"
        +"padding:10px 18px;"
        +"border-radius:20px;"
        +"cursor:pointer;"
        +"}"
        );


        response.getWriter().println(
        "button:hover{background:#5a189a;}"
        );


        response.getWriter().println("</style>");

        response.getWriter().println("</head>");



        response.getWriter().println("<body>");



        response.getWriter().println("<h1>🛒 My Shopping Cart</h1>");



        double total = 0;



        if(cart == null || cart.isEmpty()){


            response.getWriter().println(
            "<h2>Your Cart is Empty!</h2>"
            );


        }
        else{


            response.getWriter().println("<div class='cart-box'>");


            response.getWriter().println("<table>");



            response.getWriter().println(
            "<tr>"
            +"<th>Image</th>"
            +"<th>Toy Name</th>"
            +"<th>Price</th>"
            +"<th>Quantity</th>"
            +"<th>Action</th>"
            +"</tr>"
            );



            for(CartItem item : cart){


                response.getWriter().println("<tr>");



                response.getWriter().println(
                "<td>"
                +"<img src='"+request.getContextPath()
                +"/images/"
                +item.getToy().getImage()
                +"'>"
                +"</td>"
                );



                response.getWriter().println(
                "<td><b>"
                +item.getToy().getName()
                +"</b></td>"
                );



                response.getWriter().println(
                "<td>₹"
                +item.getToy().getPrice()
                +"</td>"
                );



                response.getWriter().println(
                "<td>"
                +"<a href='CartServlet?action=minus&id="
                +item.getToy().getId()
                +"'>"
                +"<button>-</button>"
                +"</a> "

                +item.getQuantity()+

                " <a href='CartServlet?action=plus&id="
                +item.getToy().getId()
                +"'>"
                +"<button>+</button>"
                +"</a>"
                +"</td>"
                );



                response.getWriter().println(
                "<td>"
                +"<a href='CartServlet?action=remove&id="
                +item.getToy().getId()
                +"'>"
                +"<button>Remove</button>"
                +"</a>"
                +"</td>"
                );



                response.getWriter().println("</tr>");



                total += item.getToy().getPrice()
                        * item.getQuantity();

            }



            response.getWriter().println("</table>");

            response.getWriter().println("</div>");



            response.getWriter().println(
            "<h2>Total Amount : ₹"
            +total
            +"</h2>"
            );



            response.getWriter().println(
            "<a href='OrderServlet'>"
            +"<button>Place Order</button>"
            +"</a>"
            );

        }



        response.getWriter().println("<br><br>");

        response.getWriter().println(
        "<a href='ToyServlet'>"
        +"Continue Shopping"
        +"</a>"
        );



        response.getWriter().println("</body>");

        response.getWriter().println("</html>");

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request,response);

    }

}