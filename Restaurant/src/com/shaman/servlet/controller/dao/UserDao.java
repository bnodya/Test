package com.shaman.servlet.controller.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shaman.servlet.controller.connection.ConnectionManager;
import com.shaman.servlet.controller.connection.Request;
import com.shaman.servlet.controller.transformer.UserTransformer;
import com.shaman.servlet.model.User;

public class UserDao {

	Connection con = null;
	ResultSet rs;
	UserTransformer transformer = new UserTransformer();
	List<User> list;
	User user;
	public User createUser(HttpServletRequest request) throws SQLException {

		String enteredLogin = request.getParameter("enteredLogin");
		String enteredPassword = request.getParameter("enteredPassword");
		String enteredEmail = request.getParameter("enteredEmail");

		try {
			con = ConnectionManager.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement prepStmt;

		prepStmt = con.prepareStatement(Request.CHECK_USER);
		prepStmt.setString(1, enteredLogin);
		rs = prepStmt.executeQuery();
		rs.next();
		if (rs.getInt("rowCount") == 0) {

			prepStmt = con.prepareStatement(Request.ADD_USER);

			prepStmt.setString(1, enteredLogin);
			prepStmt.setString(2, enteredPassword);
			prepStmt.setString(3, enteredEmail);
			prepStmt.execute();
		} else {
			throw new SQLException();
		}
		return null;

	}

	public User selectById(int id) {
		return null;
	}

	public User selectByLoginAndPassword(HttpServletRequest request) {
		
		try {
			try {
				con = ConnectionManager.getInstance().getConnection();
			} catch (IOException | PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String enteredLogin = request.getParameter("enteredLogin");
			String enteredPassword = request.getParameter("enteredPassword");
			PreparedStatement stmt = con
					.prepareStatement(Request.SELECT_USER_BY_NAME_AND_PASSWORD);
			stmt.setString(1, enteredLogin);
			stmt.setString(2, enteredPassword);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				user = transformer.resultSetToObject(rs);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<User> selectAll() {

		try {
			con = ConnectionManager.getInstance().getConnection();
			Statement stmt = con.createStatement();
			list = new ArrayList<>();

			rs = stmt.executeQuery(Request.SELECT);
			list = transformer.resultSetToList(rs);

		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void update(User user) {
	}

	public void delete(User user) {
	}

}
