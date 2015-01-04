package com.shaman.servlet.controller.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAOFactory {
	public DAOInsert getDAOInsert() throws SQLException{
		 return new DAOInsert(this);
	}
	public DAORead getDAORead() throws SQLException{
		 return new DAORead(this);
	}
	public DAODelete getDAODelete(){
		 return new DAODelete(this);
	}
	public DAOUpdate getDAOUpdate(){
		 return new DAOUpdate(this);
	}

	
	static void closeAll(PreparedStatement ps, ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
		}
		try {
			ps.close();
		} catch (Exception e) {
		}
	}
}
