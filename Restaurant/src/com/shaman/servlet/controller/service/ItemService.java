package com.shaman.servlet.controller.service;

import java.sql.SQLException;
import java.util.List;

import com.shaman.servlet.controller.dao.DAOFactory;
import com.shaman.servlet.controller.dao.daoenum.TableName;
import com.shaman.servlet.model.Item;

public class ItemService {

	static DAOFactory dao = new DAOFactory();

	public static List<Item> getItemList() {

		List<Item> list = null;

		try {
			list = dao.getDAORead().getAll(TableName.ITEM);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static List<Item> getFoodList(){
		List<Item> list = null;

		try {
			list = dao.getDAORead().getAllForInput(TableName.ITEM, "type", "0");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Item> getDrinkList(){
		List<Item> list = null;

		try {
			list = dao.getDAORead().getAllForInput(TableName.ITEM, "type", "1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
