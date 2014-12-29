package com.shaman.servlet.controller.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	static Connection con;

	private static void initialize() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/restaurant_db";
			String name = "root";
			String pass = "pass";
			con = DriverManager.getConnection(url, name, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		if (con == null) {
			initialize();
		}
		return con;
	}

}
