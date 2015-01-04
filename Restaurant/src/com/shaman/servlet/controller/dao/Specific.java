package com.shaman.servlet.controller.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shaman.servlet.controller.dao.daoenum.QueryType;
import com.shaman.servlet.controller.dao.daoenum.TableName;
import com.shaman.servlet.controller.transformer.Transformer;
import com.shaman.servlet.model.User;



public class Specific {
	
	// These functions don't call any table-specific functions
		static String queryString(TableName tableName, String keyValue,
				QueryType type) {
			String firstHalf = null;
			switch (type) {
			case READ:
				firstHalf = "select * from " + tableName + " where ";
				break;
			case DELETE:
				firstHalf = "DELETE from " + tableName + " where ";
				break;
			default:
			}
			switch (tableName) {
			case USER:
				return firstHalf + "login='" + keyValue + "'";
			default:
				return null;
			}
		}

		static <T> String getPrimaryKey(TableName tableName, T currentPojo) {
			switch (tableName) {
			case USER:
				return ((User) currentPojo).getLogin();
			default:
				return null;
			}
		}

		// These functions call table-specific functions
		@SuppressWarnings("unchecked")
		static <T> T getPojoFromResultSet(TableName tableName, ResultSet rs)
				throws SQLException {
			switch (tableName) {
			case USER:
				return (T) Transformer.getPojo(rs);
			default:
				return null;
			}
		}

		static <T> PreparedStatement getPreparedInsert(TableName tableName, T currentPojo)
				throws SQLException {
			switch (tableName) {
			case USER:
					return Transformer.getPreparedInsert(tableName,currentPojo);
			default:
				return null;
			}
		}

//		static <T> PreparedStatement getPreparedUpdate(Connection con,
//				TableName tableName, T oldPojo, T currentPojo) throws SQLException {
//			switch (tableName) {
//			case STUDENT_TABLE:
//				return Transformer.getPreparedUpdate(con, tableName, oldPojo,
//						currentPojo);
//			default:
//				return null;
//			}
//		}

}
