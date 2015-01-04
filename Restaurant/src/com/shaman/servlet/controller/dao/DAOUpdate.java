package com.shaman.servlet.controller.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shaman.servlet.controller.connection.ConnectionManager;
import com.shaman.servlet.controller.dao.daoenum.TableName;



public class DAOUpdate {

	Connection con = null;
	DAOFactory fac = null;
	public DAOUpdate(DAOFactory factory) {
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

	public <T> boolean putInto(TableName tableName, T oldPojo,
			T currentPojo) throws SQLException {
			PreparedStatement ps = null;
			try {
//			ps = Specifics.<T> getPreparedUpdate(con, tableName, oldPojo,
//			currentPojo);
//			ps.execute();
			} finally {
			DAOFactory.closeAll(ps, null);
			}
			return true;
			}


}
