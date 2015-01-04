package com.shaman.servlet.controller.transformer;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shaman.servlet.controller.connection.ConnectionManager;
import com.shaman.servlet.controller.dao.daoenum.TableName;
import com.shaman.servlet.model.User;

public class Transformer {

	static Connection con = null;

	private static void initialize() {
		try {
			con = ConnectionManager.getInstance().getConnection();
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	public static User getPojo(ResultSet rs) throws SQLException {
		User currentUser = new User();
		currentUser.setId(rs.getInt(1));
		currentUser.setLogin(rs.getString(2));
		currentUser.setPassword(rs.getString(3));
		currentUser.setEmail(rs.getString(4));
		currentUser.setIsAdmin(rs.getInt(5));
		return currentUser;
	}

	public static <T> PreparedStatement getPreparedInsert(TableName tableName,
			T currentPojo) throws SQLException {
		initialize();
		User currentUser = (User) currentPojo;
		PreparedStatement ps = con.prepareStatement("Insert into " + tableName
				+ "(login,password,email)" + " VALUES(?, ?, ?)");
		ps.setString(1, currentUser.getLogin());
		ps.setString(2, currentUser.getPassword());
		ps.setString(3, currentUser.getEmail());
		return ps;
	}

	//
	// public static <T> PreparedStatement getPreparedUpdate(Connection con,
	// TableName tableName, T oldPojo, T currentPojo) throws SQLException {
	// User currentUser = (User) currentPojo;
	// User oldUser = (User) oldPojo;
	// PreparedStatement ps = con.prepareStatement("UPDATE " + tableName
	// + " SET Roll_No = ?, User_Name = ?, Address = ?, "
	// + "Email = ?, ContactNumber = ?, Guardian_Name = ?, "
	// + "Enrollment_Date = ? WHERE User_Id = ?");
	// ps.setString(1, currentUser.getRollNo());
	// ps.setString(2, currentUser.getUserName());
	// ps.setString(3, currentUser.getAddress());
	// ps.setString(4, currentUser.getEmail());
	// ps.setString(5, currentUser.getContactNumber());
	// ps.setString(6, currentUser.getGuardianName());
	// ps.setDate(7, currentUser.getEnrollmentDate());
	// ps.setString(8, oldUser.getId());
	// return ps;
	// }
	//
}
