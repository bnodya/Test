package com.shaman.servlet.model;

import com.shaman.servlet.controller.transformer.annotation.DBColumn;

public class User {
	
	@DBColumn(name = "user_id")
	private int id;
	@DBColumn(name = "login")
	private String login;
	@DBColumn(name = "password")
	private String password;
	@DBColumn(name = "email")
	private String email;
	@DBColumn(name = "access")
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
		return "User [id=" + id + ", login=" + login + ", password=" + password
				+ ", email=" + email + ", isAdmin=" + (isAdmin == 1?"Admin":"User") + "]";
	}
	
	
}

