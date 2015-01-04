package com.shaman.servlet.controller.dao.daoenum;

public enum TableName {
	USER("user"), ORDER("order"), DRINK("drink"), DISH("dish"), DETAIL("detail"), ORDERED_DISH("oredered_dish"), ORDERED_DRINK("ordered_drink");
	
	private final String tableName;

	TableName(String tableName) {
		this.tableName = tableName;
	}

	public String toString() {
		return tableName;
	}
}
