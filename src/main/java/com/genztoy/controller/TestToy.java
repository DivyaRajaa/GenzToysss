package com.genztoy.controller;

import java.util.ArrayList;

import com.genztoy.dao.ToyDAO;
import com.genztoy.model.Toy;

public class TestToy {

    public static void main(String[] args) {

        ToyDAO dao = new ToyDAO();

        ArrayList<Toy> toys = dao.getAllToys();

        for(Toy toy : toys) {

            System.out.println(
                toy.getId() + " | " +
                toy.getName() + " | " +
                toy.getCategory() + " | " +
                toy.getPrice()
            );
        }
    }
}