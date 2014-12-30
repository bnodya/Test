package com.shaman.servlet.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shaman.servlet.controller.connection.ConnectionManager;
import com.shaman.servlet.controller.connection.Request;
import com.shaman.servlet.controller.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("pages/login.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String enteredLogin = request.getParameter("enteredLogin");

			if (UserService.getUserByLoginAndPassword(request) != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loggedUser", enteredLogin);
				session.setMaxInactiveInterval(30 * 60);

				request.setAttribute("loggedUser", enteredLogin);
				request.getRequestDispatcher("pages/index.jsp").forward(
						request, response);

			} else {
				request.setAttribute("invalidLogin2", enteredLogin);
				request.setAttribute("message2", "Invalid login or password.");
				request.getRequestDispatcher("pages/login.jsp").forward(
						request, response);
			}

		
	}
}
