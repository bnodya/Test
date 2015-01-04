package com.shaman.servlet.controller.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shaman.servlet.controller.connection.ConnectionManager;
import com.shaman.servlet.controller.dao.daoenum.QueryType;
import com.shaman.servlet.controller.dao.daoenum.TableName;



public class DAODelete {
	DAOFactory fac = null;
	Connection con = null;
	public DAODelete(DAOFactory factory) {
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
	
	public <T> boolean deleteFrom(TableName tableName,
	T currentPojo) throws SQLException {
	PreparedStatement ps = null;
	try {
	if (fac.getDAORead().<T> alreadyExisting(tableName,
	currentPojo) == false) {
	return false;
	}
	String primaryKey = Specific.<T> getPrimaryKey(tableName,
	currentPojo);
	ps = con.prepareStatement(Specific.queryString(tableName,
	primaryKey, QueryType.DELETE));
	ps.execute();
	} finally {
	DAOFactory.closeAll(ps, null);
	}
	return true;
	}
}
