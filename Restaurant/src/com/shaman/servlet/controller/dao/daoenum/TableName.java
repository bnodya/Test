package com.shaman.servlet.controller.dao.daoenum;

import com.shaman.servlet.model.Item;
import com.shaman.servlet.model.Order;
import com.shaman.servlet.model.User;


public enum TableName {
	USER("user",User.class), ORDER("order",Order.class), ITEM("item",Item.class), DETAIL("detail",null);
	
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
