package news_page.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConfig {
	public static Connection getConnection() {
		Connection conn = null;
		String connectionURL = "jdbc:mysql://localhost:3306/NewsDB";
		String username = "root";
		String password = "Hit@My5QL";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(connectionURL, username, password);
			
			System.out.println("[MySqlConfig][getConnection] db successful connection");

		} catch (Exception e) {
			System.out.println("[MySqlConfig][getConnection] db init connection err: " + e.getLocalizedMessage());
		}
		
		return conn;
	}
}
