package mypack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mypack.config.DBConnectionMySQL;
import mypack.model.User;

public class UserDAO {
	public User getUserByEmailAndPassword(String email, String password) {
	    User user = null;
	    System.out.println("Attempting database connection...");

	    try {
	        Connection conn = DBConnectionMySQL.getDBConnection();
	        if (conn != null) {
	            System.out.println("Connection established!");
	        } else {
	            System.out.println("Connection failed.");
	        }
	        String sql = "SELECT id, username, password FROM users WHERE username = ? AND password = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, email);
	        stmt.setString(2, password);
	        System.out.println("Email: " + email);
	        System.out.println("Password: " + password);

	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            user = new User();
	            user.setId(rs.getInt("id"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	        } else {
	            System.out.println("User not found with provided credentials.");
	        }

	        rs.close();
	        stmt.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user;
	}
	
	public boolean registerUser(User user, String name, String phone) {
        String sql1 = "INSERT INTO users (username, password) VALUES (?, ?)";
        String sql2 = "INSERT INTO userinfo (name, phone) VALUES (?, ?)";
        try { 
        	Connection conn = DBConnectionMySQL.getDBConnection();
            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            
            pstmt1.setString(1, user.getEmail());
            pstmt1.setString(2, user.getPassword());          
            pstmt1.executeUpdate();
            
            pstmt2.setString(1, name);
            pstmt2.setString(2, phone);          
            pstmt2.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}