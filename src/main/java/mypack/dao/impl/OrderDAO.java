package mypack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import mypack.config.DBConnectionMySQL;
import mypack.model.Order;
import mypack.model.CartItem;

public class OrderDAO {

    public boolean addOrder(Order order) {
        String query = "INSERT INTO orders (id, userID, fullname, email, address, city, state, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnectionMySQL.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, order.getId());
            stmt.setInt(2, order.getUserId());
            stmt.setString(3, order.getName());
            stmt.setString(4, order.getEmail());
            stmt.setString(5, order.getAddress());
            stmt.setString(6, order.getCity());
            stmt.setString(7, order.getState());
            stmt.setDouble(8, order.getTotal());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean addOrderDetail(String orderId, CartItem item) {
        String query = "INSERT INTO orderdetail (id, productID, quantity, size) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DBConnectionMySQL.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, orderId);
            stmt.setInt(2, item.getProduct().getId());
            stmt.setInt(3, item.getQuantity());
            stmt.setString(4, item.getSize());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public String generateOrderCode(int userID) {
        // Lấy ngày giờ hiện tại
        Date now = new Date(); // java.util.Date is used here
        // Định dạng ngày giờ thành chuỗi yyyyMMddHHmmss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(now);
        // Ghép chuỗi timestamp với userID để tạo mã đơn hàng
        return "ORD-" + timestamp + "-" + userID;
    }
}
