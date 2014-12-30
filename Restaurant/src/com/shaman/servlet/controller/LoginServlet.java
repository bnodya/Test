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
		Connection con = ConnectionManager.getConnection();
		String enteredLogin = request.getParameter("enteredLogin");
		String enteredPassword = request.getParameter("enteredPassword");
		try {
			PreparedStatement stmt = con
					.prepareStatement(Request.SELECT_USER_BY_NAME_AND_PASSWORD);
			stmt.setString(1, enteredLogin);
			stmt.setString(2, enteredPassword);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
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

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
