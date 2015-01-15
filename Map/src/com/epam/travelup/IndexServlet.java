package com.epam.travelup;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ResultSet rs = null;
		List<String> list = null;
		try {
			PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement("SELECT m.x_coord, m.y_coord FROM map m WHERE m.route_id = ?");
			stmt.setInt(1, 2);
			rs = stmt.executeQuery();

			list = new ArrayList<>();

			while (rs.next()) {
				list.add(rs.getString("x_coord") + ", "
						+ rs.getString("y_coord"));
			}
		} catch (SQLException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String origin = list.get(0);
		String destination = list.get(list.size()-1);
		list.remove(0);
		list.remove(list.size()-1);
		
		request.setAttribute("orig", origin);
		request.setAttribute("dest", destination);
		request.setAttribute("list", list);

		request.getRequestDispatcher("pages/index.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
