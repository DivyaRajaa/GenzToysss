package com.genztoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.genztoy.model.Order;
import com.genztoy.util.DBConnection;

public class OrderDAO {

    // View All Orders (Admin)
    public ArrayList<Order> getAllOrders() {

        ArrayList<Order> orders = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM orders";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Order order = new Order();

                order.setId(rs.getInt("id"));
                order.setCustomerName(rs.getString("customer_name"));
                order.setCustomerEmail(rs.getString("customer_email"));
                order.setToyName(rs.getString("toy_name"));
                order.setQuantity(rs.getInt("quantity"));
                order.setTotalPrice(rs.getDouble("total_price"));
                order.setOrderDate(rs.getString("order_date"));

                orders.add(order);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return orders;

    }

    // Add Order
    public boolean addOrder(Order order) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO orders(customer_name,toy_name,quantity,total_price,customer_email) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, order.getCustomerName());
            ps.setString(2, order.getToyName());
            ps.setInt(3, order.getQuantity());
            ps.setDouble(4, order.getTotalPrice());
            ps.setString(5, order.getCustomerEmail());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                status = true;

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return status;

    }

    // Total Orders
    public int getOrderCount() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT COUNT(*) FROM orders";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                count = rs.getInt(1);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return count;

    }

    // Total Revenue
    public double getTotalRevenue() {

        double total = 0;

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT SUM(total_price) FROM orders";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                total = rs.getDouble(1);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return total;

    }

    // Customer Order History
    public ArrayList<Order> getOrdersByEmail(String email) {

        ArrayList<Order> orders = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM orders WHERE customer_email=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Order order = new Order();

                order.setId(rs.getInt("id"));
                order.setCustomerName(rs.getString("customer_name"));
                order.setCustomerEmail(rs.getString("customer_email"));
                order.setToyName(rs.getString("toy_name"));
                order.setQuantity(rs.getInt("quantity"));
                order.setTotalPrice(rs.getDouble("total_price"));
                order.setOrderDate(rs.getString("order_date"));

                orders.add(order);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return orders;

    }

}