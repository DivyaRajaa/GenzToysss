package com.genztoy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.genztoy.dao.ToyDAO;
import com.genztoy.model.CartItem;
import com.genztoy.model.Toy;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession();


        ArrayList<CartItem> cart =
                (ArrayList<CartItem>) session.getAttribute("cart");


        String action = request.getParameter("action");



        // ==========================
        // PLUS / MINUS / REMOVE
        // ==========================

        if(action != null && cart != null) {


            int id = Integer.parseInt(request.getParameter("id"));


            Iterator<CartItem> iterator = cart.iterator();



            while(iterator.hasNext()) {


                CartItem item = iterator.next();



                if(item.getToy().getId() == id) {



                    if(action.equals("plus")) {


                        item.setQuantity(item.getQuantity() + 1);


                    }


                    else if(action.equals("minus")) {


                        if(item.getQuantity() > 1) {

                            item.setQuantity(item.getQuantity() - 1);

                        }


                    }


                    else if(action.equals("remove")) {


                        iterator.remove();


                    }


                    break;

                }

            }



            session.setAttribute("cart", cart);


            response.sendRedirect("ViewCartServlet");


            return;

        }




        // ==========================
        // ADD TO CART
        // ==========================


        int id = Integer.parseInt(request.getParameter("id"));



        ToyDAO dao = new ToyDAO();



        ArrayList<Toy> toys = dao.getAllToys();



        Toy selectedToy = null;



        for(Toy toy : toys) {


            if(toy.getId() == id) {


                selectedToy = toy;

                break;

            }

        }



        if(cart == null) {


            cart = new ArrayList<>();

        }



        boolean alreadyExist = false;



        for(CartItem item : cart) {


            if(item.getToy().getId() == id) {


                item.setQuantity(item.getQuantity() + 1);


                alreadyExist = true;


                break;

            }

        }



        if(!alreadyExist) {


            cart.add(new CartItem(selectedToy, 1));


        }



        session.setAttribute("cart", cart);



        response.sendRedirect("ViewCartServlet");


    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        doGet(request, response);

    }

}