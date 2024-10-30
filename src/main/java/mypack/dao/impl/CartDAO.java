package mypack.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mypack.model.CartItem;
import mypack.model.Product;
import mypack.config.DBConnectionMySQL;

public class CartDAO {
    
    public List<CartItem> getCartItems(int userId) {
        List<CartItem> cartItems = new ArrayList<>();
        String query = "SELECT c.userID, c.productID, sum(c.quantity) as quantity, c.size, p.id, p.name, p.brand, p.color, p.price, p.type, p.cond, p.image_url FROM cart c JOIN product p ON c.productID = p.id WHERE userID = ? GROUP BY c.productID, c.size;";
        
        try (Connection conn = DBConnectionMySQL.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("image_url"),
                        rs.getString("brand"),
                        rs.getString("color"),
                        rs.getString("type"),
                        rs.getString("cond"));
                CartItem item = new CartItem(product, rs.getInt("quantity"), rs.getString("size"));
                cartItems.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cartItems;
    }

    public void removeFromCart(int userId, int productId, String size) {
        String query = "DELETE FROM cart WHERE userID = ? AND productID = ? AND size = ?";
        
        try (Connection conn = DBConnectionMySQL.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, userId);
            stmt.setInt(2, productId);
            stmt.setString(3, size);
            stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteFromCart(int userId) {
        String query = "DELETE FROM cart WHERE userID = ?";
        
        try (Connection conn = DBConnectionMySQL.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, userId);
            stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateQuantity(int userId, int productId, int quantity, String size) {
        String query = "UPDATE cart SET quantity = ? WHERE user_id = ? AND product_id = ? AND size = ?";
        
        try (Connection conn = DBConnectionMySQL.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, quantity);
            stmt.setInt(2, userId);
            stmt.setInt(3, productId);
            stmt.setString(4, size);
            stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
