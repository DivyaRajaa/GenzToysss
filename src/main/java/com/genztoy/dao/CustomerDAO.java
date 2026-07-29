package com.genztoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.genztoy.model.Customer;
import com.genztoy.util.DBConnection;

public class CustomerDAO {

    // Register
    public boolean register(Customer customer) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "INSERT INTO customers(name,email,password,phone,address) VALUES(?,?,?,?,?)";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPassword());
            ps.setString(4, customer.getPhone());
            ps.setString(5, customer.getAddress());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Login
    public Customer login(String email, String password) {

        Customer customer = null;

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "SELECT * FROM customers WHERE email=? AND password=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                customer = new Customer();

                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));

            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return customer;
    }

    // View Profile
    public Customer getCustomerByEmail(String email) {

        Customer customer = null;

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "SELECT * FROM customers WHERE email=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                customer = new Customer();

                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));

            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return customer;
    }

    // Update Profile
    public boolean updateCustomer(Customer customer) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "UPDATE customers SET name=?, phone=?, address=? WHERE email=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getEmail());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

}