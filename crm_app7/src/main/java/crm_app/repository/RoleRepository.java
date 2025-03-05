package crm_app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crm_app.config.MySqlConfig;
import crm_app.entity.LoginEntity;
import crm_app.entity.RoleEntity;

public class RoleRepository {

	public List<RoleEntity> findAll(){
		List<RoleEntity> listRoles = new ArrayList<RoleEntity>();
		String query = "SELECT * FROM roles";
		Connection connection = MySqlConfig.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				RoleEntity entity = new RoleEntity();
				entity.setId(result.getInt("id"));
				entity.setName(result.getString("name"));
				entity.setDesc(result.getString("description"));
				
				listRoles.add(entity);
			}
		} catch (Exception e) {
			 System.out.println("findByEmailAndPassword : " + e.getLocalizedMessage());
		}
		
		return listRoles;
	}
	
}
