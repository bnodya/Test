package com.shaman.servlet.controller.service;

import java.sql.SQLException;
import java.util.List;

import com.shaman.servlet.controller.dao.DAOFactory;
import com.shaman.servlet.controller.dao.daoenum.TableName;
import com.shaman.servlet.model.Order;

public class OrderService {

	static DAOFactory dao = new DAOFactory();
	
	public static List<Order> getOrderListByUserId(int userId){
		
		List<Order> list = null;
		
		try {
			list = dao.getDAORead().getAllForInput(TableName.ORDER, "user_id", new Integer(userId).toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
}
