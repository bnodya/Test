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

		List<User> list = new ArrayList<>();
		User user;
		Connection con = null;

		String enteredLogin = request.getParameter("enteredLogin");
		String enteredPassword = request.getParameter("enteredPassword");
		String enteredEmail = request.getParameter("enteredEmail");
		
		if (!enteredLogin.isEmpty() && !enteredPassword.isEmpty() && !enteredEmail.isEmpty()) {
			try {

				con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				PreparedStatement prepStmt = con
						.prepareStatement(Request.ADD_USER);

				ResultSet rs = stmt.executeQuery(Request.COUNT_USERS);
				rs.next();
				int numberOfUsers = rs.getInt("rowCount") + 1;
				prepStmt.setInt(1, numberOfUsers);
				prepStmt.setString(2, enteredLogin);
				prepStmt.setString(3, enteredPassword);
				prepStmt.setString(4, enteredEmail);
				prepStmt.execute();

				rs = stmt.executeQuery(Request.SELECT);
//				while (rs.next()) {
//					user = new User();
//					user.setId(rs.getInt(1));
//					user.setLogin(rs.getString(2));
//					user.setPassword(rs.getString(3));
//					user.setEmail(rs.getString(4));
//					list.add(user);
//
//				}
//				
//				use transformer!!!!
				
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
