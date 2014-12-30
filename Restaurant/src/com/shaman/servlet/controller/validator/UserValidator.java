package com.shaman.servlet.controller.validator;

import javax.servlet.http.HttpServletRequest;

public class UserValidator {

	private static String enteredLogin;
	private static String enteredPassword;
	private static String enteredEmail;
	
	public UserValidator(HttpServletRequest request){
		enteredLogin = request.getParameter("enteredLogin");
		enteredPassword = request.getParameter("enteredPassword");
		enteredEmail = request.getParameter("enteredEmail");
	}
	
	public boolean isEmpty(){
		boolean status = true;
		if(!enteredLogin.isEmpty() && !enteredPassword.isEmpty() && !enteredEmail.isEmpty()){
			status = false;
		}
		return status;
	}
}
