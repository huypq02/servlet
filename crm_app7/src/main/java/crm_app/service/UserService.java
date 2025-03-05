package crm_app.service;

import java.util.List;

import crm_app.entity.LoginEntity;
import crm_app.entity.RoleEntity;
import crm_app.repository.LoginRepository;
import crm_app.repository.RoleRepository;
import crm_app.repository.UserRepository;
import utils.MD5;

public class UserService {
	
	private LoginRepository repository = new LoginRepository();
	private UserRepository userRepository = new UserRepository();
	private RoleRepository roleRepository = new RoleRepository();
	
	
	public List<LoginEntity> getAllUser(){
		return repository.findAll();
	}
	
	public boolean deleteUserById(int id) {
		int count = userRepository.deleteById(id);
		
		return count > 0;
	}
	
	public List<RoleEntity> getAllRole(){
		return roleRepository.findAll();
	}
	
	public boolean insertUser(String email, String password, String fullname, int roleId) {
		return userRepository.insert(email, MD5.getMd5(password), fullname, roleId) > 0;
	}
	
}
