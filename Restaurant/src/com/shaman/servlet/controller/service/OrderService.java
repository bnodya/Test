package com.shaman.servlet.controller.service;

import java.sql.SQLException;
import java.util.List;

import com.shaman.servlet.controller.dao.DAOFactory;
import com.shaman.servlet.controller.dao.daoenum.TableName;
import com.shaman.servlet.model.Item;
import com.shaman.servlet.model.Order;

public class OrderService {

	static DAOFactory dao = new DAOFactory();

	public static List<Order> getOrderListByUserId(int userId) {

		List<Order> list = null;

		try {
			list = dao.getDAORead().getAllForInput(TableName.ORDER, "user_id",
					new Integer(userId).toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static List<Item> getItemsBy(TableName tableName, int id) {

		List<Item> list = null;

		try {
			list = dao.getDAORead().getItemsBy(tableName, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static Order getOrderById(int id) {
		Order pojo = null;
		String primaryKey = new Integer(id).toString();
		try {
			pojo = dao.getDAORead().getPojoForPrimarKey(TableName.ORDER, primaryKey);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pojo;
	}
	
	public static List<Order> getOrderList() {

		List<Order> list = null;

		try {
			list = dao.getDAORead().getAll(TableName.ORDER);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
}
