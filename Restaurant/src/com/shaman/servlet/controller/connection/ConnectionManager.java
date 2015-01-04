package com.shaman.servlet.controller.connection;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionManager {

	private static ConnectionManager connectionManager;
	private ComboPooledDataSource cpds;

	private ConnectionManager() throws IOException, SQLException,
			PropertyVetoException {
		cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver"); // loads the jdbc driver
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/restaurant_db");
		cpds.setUser("root");
		cpds.setPassword("pass");

		// the settings below are optional -- c3p0 can work with defaults
		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		cpds.setMaxStatements(180);

	}

	public static ConnectionManager getInstance() throws IOException,
			SQLException, PropertyVetoException {
		if (connectionManager == null) {
			connectionManager = new ConnectionManager();
			return connectionManager;
		} else {
			return connectionManager;
		}
	}

	public Connection getConnection() throws SQLException {
		return this.cpds.getConnection();
	}

}
