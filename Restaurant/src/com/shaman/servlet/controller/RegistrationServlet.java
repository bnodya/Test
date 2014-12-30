package com.shaman.servlet.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shaman.servlet.controller.connection.ConnectionManager;
import com.shaman.servlet.controller.connection.Request;
import com.shaman.servlet.controller.service.UserService;
import com.shaman.servlet.controller.validator.UserValidator;
import com.shaman.servlet.model.User;


/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("pages/registration.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String enteredLogin = request.getParameter("enteredLogin");
		
		UserValidator validator = new UserValidator(request);
		List<User> list;
		System.out.println(validator.isEmpty());
		if (!validator.isEmpty()) {
			try {
				
				UserService.createUser(request);
				
				list = UserService.getAllUsers();
				
				
				request.setAttribute("userList", list);
				request.getRequestDispatcher("pages/user.jsp").forward(request,
						response);

			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("invalidLogin", enteredLogin);
				request.setAttribute("regError", "There is a user with the same name.");
				request.getRequestDispatcher("pages/registration.jsp").forward(request, response);
				
			}
		} else {
			request.setAttribute("invalidLogin", enteredLogin);
			request.setAttribute("regError", "Invalid input.");
			request.getRequestDispatcher("pages/registration.jsp").forward(request, response);
		}
		
	}

}
