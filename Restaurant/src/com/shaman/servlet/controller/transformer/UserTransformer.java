package com.shaman.servlet.controller.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shaman.servlet.model.User;

public class UserTransformer {

	private User user;
	private List<User> list;
	public User resultSetToObject(ResultSet rs) throws SQLException{
		user = new User();
		while(rs.next()){
			user.setId(rs.getInt(1));
			user.setLogin(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setEmail(rs.getString(4));
		}
		return user;
	}
	public List<User> resultSetToList(ResultSet rs) throws SQLException{
		list = new ArrayList<>();
		while (rs.next()) {
			user = new User();
			user.setId(rs.getInt(1));
			user.setLogin(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setEmail(rs.getString(4));
			list.add(user);
	}
		return list;
	}
	
	public Statement objectToStatement(){
		return null;
		
	}
		
}
