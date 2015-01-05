package com.shaman.servlet.controller.connection;

public class Query {
	public static final String SELECT = "SELECT * FROM user";
	public static final String ADD_USER = "INSERT INTO user(login,password,email) VALUES (?,?,?)";
	public static final String COUNT_USERS = "SELECT COUNT(*) AS rowCount FROM user";
	public static final String SELECT_USER_BY_NAME = "SELECT * FROM user WHERE login=?";
	public static final String DELETE_USER_BY_NAME = "DELETE FROM user WHERE login=?";
	public static final String SELECT_USER_BY_NAME_AND_PASSWORD = "SELECT * FROM user WHERE login=? AND password=?";
	public static final String CHECK_USER = "SELECT COUNT(*) AS rowCount FROM user WHERE login=?";
	public static final String SELECT_ITEMS_BY_ORDER_ID = "SELECT * FROM restaurant_db.item i JOIN restaurant_db.detail d ON d.item_id = i.item_id JOIN restaurant_db.`order` o ON d.order_id = o.order_id WHERE o.order_id = ?";
	public static final String SELECT_ITEMS_BY_USER_ID = "SELECT * FROM restaurant_db.item i JOIN restaurant_db.detail d ON d.item_id = i.item_id JOIN restaurant_db.`order` o ON d.order_id = o.order_id JOIN users u ON o.user_id = u.id WHERE u.id = ?";
	public static final String SELECT_PRICE_AND_QUANTITY_BY_ORDER_ID = "SELECT i.price, d.quantity FROM restaurant_db.item i JOIN restaurant_db.detail d ON i.item_id = d.item_id JOIN restaurant_db.orders o ON d.order_id = o.order_id WHERE o.order_id=?";
	public static final String SELECT_PRICE_AND_QUANTITY_BY_USER_ID = "SELECT i.price, d.quantity FROM restaurant_db.item i JOIN restaurant_db.detail d ON i.item_id = d.item_id JOIN restaurant_db.orders o ON d.order_id = o.order_id WHERE o.user_id=?";

}