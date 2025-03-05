package crm_app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import crm_app.config.MySqlConfig;
import crm_app.entity.LoginEntity;

public class UserRepository {
	
	public int deleteById(int id) {
		int rowDeleted = 0;
		String query = "DELETE FROM users u WHERE u.id = ?";
		Connection connection = MySqlConfig.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			rowDeleted = statement.executeUpdate();
			
		} catch (Exception e) {
			 System.out.println("deleteById : " + e.getLocalizedMessage());
		}
		
		return rowDeleted;
	}
	
	public int insert(String email, String password, String fullname, int roleId) {
		int rowInsert = 0;
		String query = "INSERT INTO users(email,password,fullname,role_id)VALUES(?,?,?,?)";
		
		Connection connection = MySqlConfig.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			statement.setString(3, fullname);
			statement.setInt(4, roleId);
			
			rowInsert = statement.executeUpdate();
			
		} catch (Exception e) {
			 System.out.println("deleteById : " + e.getLocalizedMessage());
		}
		
		return rowInsert;
	}

}
