package com.shaman.servlet.controller.connection;

public class Request {
	public static final String SELECT = "SELECT * FROM user";
	public static final String ADD_USER = "INSERT INTO user(login,password,email) VALUES (?,?,?)";
	public static final String COUNT_USERS = "SELECT COUNT(*) AS rowCount FROM user";
	public static final String SELECT_USER_BY_NAME = "SELECT * FROM user WHERE login=?";
	public static final String DELETE_USER_BY_NAME = "DELETE FROM user WHERE login=?";
	public static final String SELECT_USER_BY_NAME_AND_PASSWORD = "SELECT user_id FROM user WHERE login=? AND password=?";
	public static final String CHECK_USER = "SELECT COUNT(*) AS rowCount FROM user WHERE login=?";
}
