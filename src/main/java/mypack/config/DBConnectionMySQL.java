package mypack.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionMySQL {
	
	
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/testlogin?useSSL=false";
	private static String USER_NAME = "root";
	private static String PASSWORD = "Lucasvo@184";
	
	public static Connection getDBConnection() throws SQLException, Exception {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static void main(String []args) {
		try {
			Connection c = getDBConnection();
			if(c == null) {
				System.out.println("Something wrong");
			} else {
				System.out.println("ok");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}