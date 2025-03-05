package crm_app.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_app.entity.LoginEntity;
import crm_app.entity.RoleEntity;
import crm_app.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "userController", urlPatterns = {"/users","/user-add"} )
public class UserController extends HttpServlet {

	private UserService service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath(); //trả ra đường dẫn servlet đang gọi
		
		if(path.equals("/users")) {
			loadUsers(req,resp);
		}else if(path.equals("/user-add")) {
			addUser(req,resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath(); //trả ra đường dẫn servlet đang gọi
		
		if(path.equals("/user-add")) {
			addUserPost(req,resp);
		}
	}
	
	private void addUserPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		int roleId = Integer.parseInt(req.getParameter("role") != null ? req.getParameter("role") : "0");
		
		service.insertUser(email, password, fullname, roleId);
		
		List<RoleEntity> listRole =  service.getAllRole();
		
		req.setAttribute("listRole", listRole);
		
		req.getRequestDispatcher("user-add.jsp").forward(req, resp);
	}
	
	private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<RoleEntity> listRole =  service.getAllRole();
		
		req.setAttribute("listRole", listRole);
		
		req.getRequestDispatcher("user-add.jsp").forward(req, resp);
	}
	
	private void loadUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		if(id != null) {
			//Tinh nang xoa
			service.deleteUserById(Integer.parseInt(id));
		}
		
		List<LoginEntity> listUser = service.getAllUser();
		
		req.setAttribute("listUser", listUser);
		
	    req.getRequestDispatcher("user-table.jsp").forward(req, resp);
	}


}
