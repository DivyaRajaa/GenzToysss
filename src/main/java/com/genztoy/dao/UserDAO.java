package com.genztoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.genztoy.model.User;
import com.genztoy.util.DBConnection;

public class UserDAO {


    // Register User
    public boolean registerUser(User user) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO users(name,email,password) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());


            int result = ps.executeUpdate();

            if(result > 0) {
                status = true;
            }


        } catch(Exception e) {

            e.printStackTrace();

        }

        return status;
    }



    // Login Check
    public User loginUser(String email, String password) {

        User user = null;

        try {

            Connection con = DBConnection.getConnection();


            String query = 
            "SELECT * FROM users WHERE email=? AND password=?";


            PreparedStatement ps = con.prepareStatement(query);


            ps.setString(1, email);
            ps.setString(2, password);


            ResultSet rs = ps.executeQuery();


            if(rs.next()) {

                user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));

            }


        } catch(Exception e) {

            e.printStackTrace();

        }


        return user;
    }

}