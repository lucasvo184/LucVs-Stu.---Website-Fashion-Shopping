package mypack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import mypack.config.DBConnectionMySQL;
import mypack.model.Payment;

public class PaymentDAO {

    public boolean addPayment(Payment payment) {
        String query = "INSERT INTO payments (orderID, name, numcredit, expmonth, expyear, cvv) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnectionMySQL.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, payment.getOrderId());
            stmt.setString(2, payment.getName());
            stmt.setString(3, payment.getNum());
            stmt.setString(4, payment.getMonth());
            stmt.setString(5, payment.getYear());
            stmt.setString(6, payment.getCvv());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
