package com.genztoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.genztoy.model.Toy;
import com.genztoy.util.DBConnection;

public class ToyDAO {

    // Get all toys
    public ArrayList<Toy> getAllToys() {

        ArrayList<Toy> toys = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM products";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Toy toy = new Toy();

                toy.setId(rs.getInt("id"));
                toy.setName(rs.getString("name"));
                toy.setCategory(rs.getString("category"));
                toy.setPrice(rs.getDouble("price"));
                toy.setDescription(rs.getString("description"));
                toy.setStock(rs.getInt("stock"));
                toy.setImage(rs.getString("image"));

                toys.add(toy);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return toys;
    }


    // Get toys by category (Boys / Girls)
    public ArrayList<Toy> getToysByCategory(String category) {

        ArrayList<Toy> toys = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM products WHERE category = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, category);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Toy toy = new Toy();

                toy.setId(rs.getInt("id"));
                toy.setName(rs.getString("name"));
                toy.setCategory(rs.getString("category"));
                toy.setPrice(rs.getDouble("price"));
                toy.setDescription(rs.getString("description"));
                toy.setStock(rs.getInt("stock"));
                toy.setImage(rs.getString("image"));

                toys.add(toy);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return toys;
    }
    public boolean addToy(Toy toy) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO products(name,category,price,description,stock,image) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, toy.getName());
            ps.setString(2, toy.getCategory());
            ps.setDouble(3, toy.getPrice());
            ps.setString(4, toy.getDescription());
            ps.setInt(5, toy.getStock());
            ps.setString(6, toy.getImage());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                status = true;
            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return status;
    }
 // Get toy by ID
    public Toy getToyById(int id) {

        Toy toy = null;

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM products WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                toy = new Toy();

                toy.setId(rs.getInt("id"));
                toy.setName(rs.getString("name"));
                toy.setCategory(rs.getString("category"));
                toy.setPrice(rs.getDouble("price"));
                toy.setDescription(rs.getString("description"));
                toy.setStock(rs.getInt("stock"));
                toy.setImage(rs.getString("image"));

            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return toy;
    }


    // Update Toy
    public boolean updateToy(Toy toy) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query = "UPDATE products SET name=?,category=?,price=?,description=?,stock=?,image=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, toy.getName());
            ps.setString(2, toy.getCategory());
            ps.setDouble(3, toy.getPrice());
            ps.setString(4, toy.getDescription());
            ps.setInt(5, toy.getStock());
            ps.setString(6, toy.getImage());
            ps.setInt(7, toy.getId());

            int rows = ps.executeUpdate();

            if(rows > 0) {

                status = true;

            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return status;
    }
    public int getToyCount() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT COUNT(*) FROM products";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                count = rs.getInt(1);

            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return count;
    }
    
}