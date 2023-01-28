package com.order;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.Product;

/**
 * Servlet implementation class OrderHistoryServlet
 */
@WebServlet("/orders")
public class OrderHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Order> ordersList = new ArrayList<>();
		List<OrderItem> itemO1 = new ArrayList<>();
		Product p1 = new Product(3,"shirt", "polo shirt", "cool blue shirt", "url", 19.99);
		Product p2 = new Product(4,"shoes", "Armani shoes", "cool black shoes", "url", 49.99);
		OrderItem oi1 = new OrderItem(5,5,p1,2);
		OrderItem oi2 = new OrderItem(6,6,p2,3);
		itemO1.add(oi1);
		itemO1.add(oi2);
		Order o1 = new Order(1,1,LocalDateTime.now(),itemO1);
		
		List<OrderItem> itemO2 = new ArrayList<>();
		Product p3 = new Product(2,"pants", "black pants", "black trousers", "url", 29.99);
		//Product p2 = new Product(4,"shoes", "Armani shoes", "cool black shoes", "url", 49.99);
		OrderItem oi3 = new OrderItem(2,2,p3,7);
		OrderItem oi4 = new OrderItem(7,7,p2,8);
		itemO2.add(oi3);
		itemO2.add(oi4);
		Order o2 = new Order(12,12,LocalDateTime.now(),itemO2);
		
		ordersList.add(o1);
		ordersList.add(o2);
		
		String destination = "orders.jsp";
		request.setAttribute("ordersList", ordersList);
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
		dispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
