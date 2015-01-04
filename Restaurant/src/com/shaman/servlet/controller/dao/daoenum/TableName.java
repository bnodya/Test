package com.shaman.servlet.controller.dao.daoenum;

import com.shaman.servlet.model.Dish;
import com.shaman.servlet.model.User;

public enum TableName {
	USER("user",User.class), ORDER("order",null), DRINK("drink",null), DISH("dish",Dish.class), DETAIL("detail",null), ORDERED_DISH("oredered_dish",null), ORDERED_DRINK("ordered_drink",null);
	
	private final String tableName;
	private final Class classFile;
	TableName(String tableName, Class classFile) {
		this.tableName = tableName;
		this.classFile = classFile;
	}

	public String getTable(){
		return tableName;
	}
	public Class getClassType(){
		return classFile;
	}
	public String toString() {
		return tableName;
	}
}
