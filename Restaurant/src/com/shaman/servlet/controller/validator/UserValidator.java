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
	
	public boolean isValidLogin() {
        String ePattern = "^[a-z0-9_-]{3,16}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(enteredLogin);
        return m.matches();
 }
	
	
	public boolean isValidPassword(){
		boolean status = false;
		 String ePattern = "^[a-z0-9_-]{3,18}$";
	        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
	        java.util.regex.Matcher m = p.matcher(enteredPassword);
	        
		if(m.matches() && enteredPassword.equals(reenteredPassword) ){
			status = true;
		}
		return status;
	}
	
	public boolean isValidLoginPassword(){
		boolean status = false;
		 String ePattern = "^[a-z0-9_-]{3,18}$";
	        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
	        java.util.regex.Matcher m = p.matcher(enteredPassword);
	        
		if(m.matches() ){
			status = true;
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
