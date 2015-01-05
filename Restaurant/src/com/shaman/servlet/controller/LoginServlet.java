package com.shaman.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shaman.servlet.controller.service.UserService;
import com.shaman.servlet.controller.validator.UserValidator;
import com.shaman.servlet.model.User;

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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String enteredLogin = request.getParameter("enteredLogin");
		UserValidator validate = new UserValidator(request);
		User user = null;
		if (validate.isValidLogin() && !validate.isValidPassword()) {
			if (UserService.getLoggedUser(request)) {

				user = UserService.getUserByLogin(enteredLogin);
				
				HttpSession session = request.getSession();
				session.setAttribute("loggedUser", user);
				session.setMaxInactiveInterval(30 * 60);

				//request.setAttribute("loggedUser", user);
				request.getRequestDispatcher("pages/index.jsp").forward(
						request, response);
			}
		} else {
			if (validate.isValidLogin()) {
				request.setAttribute("invalidLogin2", enteredLogin);
			}
			request.setAttribute("message2", "Invalid login or password.");
			request.getRequestDispatcher("pages/login.jsp").forward(request,
					response);
		}

	}
}
