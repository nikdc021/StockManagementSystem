package stock;

import java.sql.Connection;
import java.sql.DriverManager;

class DatabaseConnect {
	private Connection conn = null;
	
	public Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stockmanagementsystem","root", "");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return conn;
	}
}
