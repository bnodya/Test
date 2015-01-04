package com.shaman.servlet.controller.validator;

import javax.servlet.http.HttpServletRequest;

public class UserValidator {

	private static String enteredLogin;
	private static String enteredPassword;
	private static String enteredEmail;
	private static String reenteredPassword;
	
	public UserValidator(HttpServletRequest request){
		enteredLogin = request.getParameter("enteredLogin");
		enteredPassword = request.getParameter("enteredPassword");
		reenteredPassword = request.getParameter("reenteredPassword");
		enteredEmail = request.getParameter("enteredEmail");
	}
	
	public boolean invalidPassword(){
		boolean status = true;
		if(!enteredPassword.equals("") && enteredPassword.equals(reenteredPassword) ){
			status = false;
		}
		System.out.println("pass " + status);
		return status;
	}
	
	
	public boolean isEmpty(){
		boolean status = true;
		if(!enteredLogin.isEmpty() && !enteredPassword.isEmpty() && !enteredEmail.isEmpty()){
			status = false;
		}
		return status;
	}
}
