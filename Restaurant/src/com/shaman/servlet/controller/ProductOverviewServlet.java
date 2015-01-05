package com.shaman.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shaman.servlet.controller.dao.DAOFactory;
import com.shaman.servlet.controller.dao.daoenum.TableName;
import com.shaman.servlet.model.Item;

/**
 * Servlet implementation class ProductOverviewServlet
 */
public class ProductOverviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductOverviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Item> list = new DAOFactory().getDAORead().getAll(TableName.ITEM);
			request.setAttribute("itemList", list);		
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		request.getRequestDispatcher("pages/product-overview.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
