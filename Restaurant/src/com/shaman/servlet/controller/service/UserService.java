package com.shaman.servlet.controller.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shaman.servlet.controller.dao.DAOFactory;
import com.shaman.servlet.controller.dao.daoenum.TableName;
import com.shaman.servlet.model.User;

public class UserService {
	
	static DAOFactory dao = new DAOFactory();
	
	public static User getUserByLogin(String login){
		User user = null;
		try {
			user = dao.getDAORead().getPojoForPrimarKey(TableName.USER, login);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}
	
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
	
	public static boolean getLoggedUser(HttpServletRequest request){
		boolean status = false;
		String login = request.getParameter("enteredLogin");
		String password = request.getParameter("enteredPassword");
			try {
				status = dao.getDAORead().isRegistered(login, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
	}
	
	@SuppressWarnings("static-access")
	public static double getOrderPriceByUserId(int id){
		try {
			return dao.getDAORead().getOrderPriceByUserId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
