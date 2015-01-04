package com.shaman.servlet.controller.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.shaman.servlet.controller.connection.ConnectionManager;
import com.shaman.servlet.controller.dao.daoenum.TableName;
import com.shaman.servlet.model.User;

public class DAOInsert {
	DAOFactory fac = null;
	Connection con = null;

	public DAOInsert(DAOFactory factory) {
		fac = factory;
		initialize();
	}

	private void initialize() {
		try {
			con = ConnectionManager.getInstance().getConnection();
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public <T> boolean putInto(TableName tableName, T currentPojo)
			throws SQLException {
		PreparedStatement ps = null;
		try {
			if (fac.getDAORead().<T> alreadyExisting(tableName, currentPojo)) {
				return false;
			}
			ps = Specific.<T> getPreparedInsert(tableName, currentPojo);
			ps.execute();
			return true;
		} finally {
			DAOFactory.closeAll(ps, null);
		}
	}
	
	
	public <T> boolean putInto(TableName tableName, HttpServletRequest request)
			throws SQLException {
		
		String enteredLogin = request.getParameter("enteredLogin");
		String enteredPassword = request.getParameter("enteredPassword");
		String enteredEmail = request.getParameter("enteredEmail");
		User currentUser;
		boolean exist = true;
		try {
			con = ConnectionManager.getInstance().getConnection();
			exist = new DAOFactory().getDAORead().alreadyExisting(TableName.USER, enteredLogin);
			
		} catch (IOException | PropertyVetoException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (!exist) {
			currentUser = new User();
			currentUser.setLogin(enteredLogin);
			currentUser.setPassword(enteredPassword);
			currentUser.setEmail(enteredEmail);
			
			putInto(tableName, currentUser);
			return true;
		}
		return false;
	}
	
}
