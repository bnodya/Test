package com.shaman.servlet.model;

public class User {
	
	private int id;
	private String login;
	private String password;
	private String email;
	private int isAdmin;

	public int isAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return id + ", " + login + ", " + email + ", " + password + ", " + (isAdmin == 1?"Admin":"User");
	}

	
	
}

