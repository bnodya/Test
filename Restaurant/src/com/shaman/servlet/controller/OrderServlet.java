package com.shaman.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shaman.servlet.controller.dao.daoenum.TableName;
import com.shaman.servlet.controller.service.OrderService;
import com.shaman.servlet.model.Item;
import com.shaman.servlet.model.Order;

/**
 * Servlet implementation class OrderServlet
 */

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
		List<Order> orderList = null;	
		orderList = OrderService.getOrderList();	
		
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("pages/orderlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object  obj = null;
		if((obj = request.getAttribute("update")) != null){
		int orderId = Integer.parseInt((String)obj);
		
		}
		boolean orderPay = request.getParameterValues("orderPay") != null;
		boolean orderApply = request.getParameterValues("orderApply") != null;
		System.out.println(orderApply + " " + orderPay + " ");
	}

}
