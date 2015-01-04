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
		return status;
	}
	
	public boolean isValidEmailAddress() {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(enteredEmail);
        return m.matches();
 }
	
	
	public boolean isEmpty(){
		boolean status = true;
		if(!enteredLogin.isEmpty() && !enteredPassword.isEmpty() && !enteredEmail.isEmpty()){
			status = false;
		}
		return status;
	}
}
