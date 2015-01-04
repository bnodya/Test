package com.shaman.servlet.controller.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shaman.servlet.controller.dao.DAOFactory;
import com.shaman.servlet.controller.dao.daoenum.TableName;
import com.shaman.servlet.model.User;

public class UserService {

//	private static UserDao dao = new UserDao();
//
//	public static User getUserById(int id) {
//		return dao.selectById(id);
//	}
//
//	public static List<User> getAllUsers() {
//		return dao.selectAll();
//	}
//																						
//	public static void createUser(HttpServletRequest request) throws SQLException{
//		dao.createUser(request);
//	}
//	
//	public static User getUserByLoginAndPassword(HttpServletRequest request){
//		return dao.selectByLoginAndPassword(request);
//	}
	
	static DAOFactory dao = new DAOFactory();
	
	
	public static List<User> getAllUsers() {
		try {
			return dao.getDAORead().getAll(TableName.USER);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean createUser(HttpServletRequest request) throws SQLException{
		return dao.getDAOInsert().putInto(TableName.USER, request);
	}
	
}
