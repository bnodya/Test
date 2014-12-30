package com.shaman.servlet.controller.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shaman.servlet.controller.dao.UserDao;
import com.shaman.servlet.model.User;

public class UserService {

	private static UserDao dao = new UserDao();

	public static User getUserById(int id) {
		return dao.selectById(id);
	}

	public static List<User> getAllUsers() {
		return dao.selectAll();
	}
	
	public static void createUser(HttpServletRequest request) throws SQLException{
		dao.createUser(request);
	}
	
	public static User getUserByLoginAndPassword(HttpServletRequest request){
		return dao.selectByLoginAndPassword(request);
	}
}
