package mypack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypack.config.DBConnectionMySQL;
import mypack.model.Product;

public class ProductDAO {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product";
        try (Connection conn = DBConnectionMySQL.getDBConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("image_url"),
                        rs.getString("brand"),
                        rs.getString("color"),
                        rs.getString("type"),
                        rs.getString("cond")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    
    public List<Product> getProducts(String type) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product WHERE type =" + type;
        try (Connection conn = DBConnectionMySQL.getDBConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("image_url"),
                        rs.getString("brand"),
                        rs.getString("color"),
                        rs.getString("type"),
                        rs.getString("cond")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    
    public List<Product> getTrendProducts(String cond) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product WHERE cond =" + cond;
        try (Connection conn = DBConnectionMySQL.getDBConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("image_url"),
                        rs.getString("brand"),
                        rs.getString("color"),
                        rs.getString("type"),
                        rs.getString("cond")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    
    public Product getProductById(int id) {
        Product product = null;
        String query = "SELECT * FROM product WHERE id = ?";
        try (Connection conn = DBConnectionMySQL.getDBConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("image_url"),
                        rs.getString("brand"),
                        rs.getString("color"),
                        rs.getString("type"),
                        rs.getString("cond")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
    
    public boolean addToCart(int userID, int productID, int quantity, String size) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnectionMySQL.getDBConnection();
            String sql = "INSERT INTO cart (userID, productID, quantity, size) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setInt(2, productID);
            ps.setInt(3, quantity);
            ps.setString(4, size);

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
