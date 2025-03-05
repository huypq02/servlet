package crm_app.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConfig {
	public static Connection getConnection(){
		Connection connection = null;
		String connectionURL = "jdbc:mysql://localhost:3306/crm_app";
		String username = "root";
		String password = "Hit@My5QL";
		System.out.println(connection);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(connection);
			connection = DriverManager.getConnection(connectionURL, username, password);
			System.out.println(connection);

			System.out.println("connection succesful");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("err " + e.getMessage());
			e.printStackTrace();
		}
		
		return connection;
	}
}
