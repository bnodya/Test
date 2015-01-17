package com.epam.travelup;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static Connection con = null;

	private static Connection create() throws IOException, SQLException,
			PropertyVetoException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/toursite_database";
			String name = "root";
			String pass = "pass";

			con = DriverManager.getConnection(url, name, pass);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Connection getConnection() throws IOException, SQLException,
			PropertyVetoException {
		if (con == null) {
			con = create();
			return con;
		} else {
			return con;
		}
	}
}