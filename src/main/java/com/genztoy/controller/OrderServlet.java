package com.genztoy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.genztoy.dao.OrderDAO;
import com.genztoy.model.CartItem;
import com.genztoy.model.Order;


@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");


        HttpSession session = request.getSession();


        ArrayList<CartItem> cart =
                (ArrayList<CartItem>) session.getAttribute("cart");


        double total = 0;


        if(cart != null) {


            OrderDAO dao = new OrderDAO();


            for(CartItem item : cart) {


                double itemTotal =
                        item.getToy().getPrice()
                        * item.getQuantity();


                total += itemTotal;



                Order order = new Order();


                order.setCustomerName("Customer");


                order.setCustomerEmail("customer@gmail.com");


                order.setToyName(
                        item.getToy().getName()
                );


                order.setQuantity(
                        item.getQuantity()
                );


                order.setTotalPrice(
                        itemTotal
                );


                dao.addOrder(order);

            }


            session.removeAttribute("cart");

        }



        response.getWriter().println("<html>");

        response.getWriter().println("<head>");

        response.getWriter().println("<title>Order Success</title>");


        response.getWriter().println("<style>");

        response.getWriter().println(
        "body{"
        + "font-family:Arial;"
        + "background:#f3e8ff;"
        + "height:100vh;"
        + "display:flex;"
        + "justify-content:center;"
        + "align-items:center;"
        + "margin:0;"
        + "}"
        );


        response.getWriter().println(
        ".box{"
        + "background:white;"
        + "width:420px;"
        + "padding:40px;"
        + "text-align:center;"
        + "border-radius:20px;"
        + "box-shadow:0 10px 25px rgba(0,0,0,0.2);"
        + "}"
        );


        response.getWriter().println(
        "h1{color:#7b2cbf;}"
        );


        response.getWriter().println(
        "h2{color:green;}"
        );


        response.getWriter().println(
        ".total{"
        + "font-size:22px;"
        + "font-weight:bold;"
        + "color:#7b2cbf;"
        + "margin:20px;"
        + "}"
        );


        response.getWriter().println(
        "button{"
        + "background:#7b2cbf;"
        + "color:white;"
        + "border:none;"
        + "padding:14px 30px;"
        + "border-radius:25px;"
        + "cursor:pointer;"
        + "}"
        );


        response.getWriter().println("</style>");

        response.getWriter().println("</head>");


        response.getWriter().println("<body>");


        response.getWriter().println("<div class='box'>");


        response.getWriter().println(
        "<h1>Genz Toysss</h1>"
        );


        response.getWriter().println(
        "<h2>Order Placed Successfully!</h2>"
        );


        response.getWriter().println(
        "<p>Thank you for shopping with Genz Toysss.</p>"
        );


        response.getWriter().println(
        "<p>Your order has been confirmed.</p>"
        );


        response.getWriter().println(
        "<div class='total'>Total Paid: Rs. "
        + total +
        "</div>"
        );


        response.getWriter().println(
        "<a href='home.html'>"
        );


        response.getWriter().println(
        "<button>Continue Shopping</button>"
        );


        response.getWriter().println(
        "</a>"
        );


        response.getWriter().println("</div>");


        response.getWriter().println("</body>");

        response.getWriter().println("</html>");

    }



    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        doGet(request,response);

    }

}