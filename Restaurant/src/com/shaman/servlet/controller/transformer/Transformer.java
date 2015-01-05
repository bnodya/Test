package com.shaman.servlet.controller.transformer;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shaman.servlet.controller.connection.ConnectionManager;
import com.shaman.servlet.controller.dao.daoenum.TableName;
import com.shaman.servlet.controller.transformer.annotation.DBColumn;
import com.shaman.servlet.model.User;

public class Transformer<T> {

	static Connection con = null;
	private Class<T> type;

	public Transformer(Class<T> type) {
		this.type = type;
	}

	private static void initialize() {
		try {
			con = ConnectionManager.getInstance().getConnection();
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public T getPojo(ResultSet rs){
		T pojo = null;
		try {
			pojo = type.newInstance();
			
			Field[] fields = pojo.getClass().getDeclaredFields();
			for(Field field:fields){
				String fieldType = field.getType().getSimpleName()
						.toLowerCase();
				String column = attributeFrom(field.getName());
				field.setAccessible(true);
				if (column != null) {
					switch (fieldType) {
					case "int":
						field.setInt(pojo, rs.getInt(column));
						break;
					case "double":
						field.setDouble(pojo, rs.getDouble(column));
						break;
					case "string":
						field.set(pojo, rs.getString(column));
						break;
					case "date":
						field.set(pojo, rs.getTimestamp(column));
						break;
					case "boolean":
						field.setBoolean(pojo, rs.getBoolean(column));
						break;
					default:
						break;
					}
				}
			}
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pojo;
	}

	public static <T> PreparedStatement getPreparedInsert(TableName tableName,
			T currentPojo) throws SQLException {
		initialize();
		switch (tableName) {
		case USER:
			User currentUser = (User) currentPojo;
			PreparedStatement ps = con.prepareStatement("Insert into " + tableName
				+ "(login,password,email)" + " VALUES(?, ?, ?)");
			ps.setString(1, currentUser.getLogin());
			ps.setString(2, currentUser.getPassword());
			ps.setString(3, currentUser.getEmail());
			return ps;
		default:
			return null;
		}
	}

	public List<T> getPojoList(ResultSet rs) {
		T pojo = null;
		List<T> pojoList = new ArrayList<>();

		try {
			while (rs.next()) {
				pojo = type.newInstance();
				Field[] fields = type.getDeclaredFields();
				for (Field field : fields) {
					String fieldType = field.getType().getSimpleName()
							.toLowerCase();
					String column = attributeFrom(field.getName());
					field.setAccessible(true);
					if (column != null) {
						switch (fieldType) {
						case "int":
							field.setInt(pojo, rs.getInt(column));
							break;
						case "double":
							field.setDouble(pojo, rs.getDouble(column));
							break;
						case "string":
							field.set(pojo, rs.getString(column));
							break;
						case "date":
							field.set(pojo, rs.getDate(column));
							break;
						case "boolean":
							field.setBoolean(pojo, rs.getBoolean(column));
							break;
						default:
							break;
						}
					}
				}
				if (pojo != null) {
					pojoList.add(pojo);
				}
			}
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pojoList;
	}

	public Map<String, Object> pojoToTable(T pojo) {
		Field[] fields = pojo.getClass().getDeclaredFields();
		Map<String, Object> input = new HashMap<String, Object>();
		for (Field field : fields) {
			field.setAccessible(true);
			String attr = attributeFrom(field.getName());
			if (attr != null) {
				try {
					input.put(attr, field.get(pojo));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return input;
	}

	private String attributeFrom(String name) {
		try {
			Field field = type.getDeclaredField(name);
			field.setAccessible(true);
			Annotation annotation = field.getAnnotation(DBColumn.class);
			if (annotation != null) {
				String attribute = (String) annotation.annotationType()
						.getMethod("name").invoke(annotation);
				return attribute;
			}
		} catch (NoSuchFieldException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static double resultSetToPrice(ResultSet rs) throws SQLException{
		double sum = 0;
	
			while(rs.next()){
				double price = rs.getDouble(1);
				int quantity = rs.getInt(2);
				sum += price*quantity;
			}
		return sum;
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
