package com.product;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DBConnection;
import com.database.ProductDao;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/products")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	@Override
//	public void init() throws ServletException {
//		DBConnection.connection();
//	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBConnection.connection();
//		Product p1 = new Product(1,"shirt", "Blue polo Shirt", "Pretty cool blue shirt", "https://cdn.shopify.com/s/files/1/0312/6537/products/TT51-Sport-Royal-F_1024x1024.jpg?v=1571272854", 9.99);
//		Product p2 = new Product(1,"shoes", "Black Armani shoes", "Pretty cool shoes", "https://www.armani.com/variants/images/17266703523613434/D/w400.jpg", 29.99);
//		Product p3 = new Product(1,"pants", "Black pants", "Levis pants", "https://cdn.shopify.com/s/files/1/0293/0298/0701/products/ScreenShot2020-05-29at7.36.00PM.png?v=1612648057", 39.99);
//		Product p4 = new Product(1,"shirt", "Plain white tshirt", "White t-shirt", "https://i.pinimg.com/originals/1e/f5/5f/1ef55fd0873ea77e63766cc6954a77e2.jpg", 11.99);
//		
//		List<Product> productList = new ArrayList<>();
//		productList.add(p1);
//		productList.add(p2);
//		productList.add(p3);
//		productList.add(p4);
		ProductDao productDao = new ProductDao();
		List<Product> productList = productDao.listProducts();
		String destination = "products.jsp";
		 
		request.setAttribute("productList", productList);
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
		dispatcher.forward(request, response);
	}
}
