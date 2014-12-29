package com.shaman.servlet.controller.connection;

public class Request {
	public static final String SELECT = "SELECT * FROM user";
	public static final String ADD_USER = "INSERT INTO user(login,password,email) VALUES (?,?,?)";
	public static final String COUNT_USERS = "SELECT COUNT(*) AS rowCount FROM users";
	public static final String SELECT_USER_BY_NAME = "SELECT * FROM users WHERE login=?";
	public static final String DELETE_USER_BY_NAME = "DELETE FROM users WHERE login=?";
	public static final String SELECT_USER_BY_NAME_AND_PASSWORD = "SELECT id FROM users WHERE login=? AND password=?";
}
