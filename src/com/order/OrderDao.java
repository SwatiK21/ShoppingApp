package com.order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.database.DBConnection;
import com.database.ProductDao;
import com.product.Product;


public class OrderDao {

	private static Connection connection;

	public static void init() {
		if (connection == null) {
			connection = DBConnection.connection();
		}
	}
	
	public static List<Order> getOrderForUser(int userId) {
		init();
		List<Order> ordersList = new ArrayList<>();
		
		try {
			String query = "select * from orders where user_id = " + userId;
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				Integer id = rs.getInt("id");
				LocalDateTime date = convertToLocalDateTime(rs.getDate("order_date"));
				
				List<OrderItem> itemList = getOrderItems(id);
				Order order = new Order(id,userId,date,itemList);
				
				ordersList.add(order);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return ordersList;
	}
	
	
	public static List<OrderItem> getOrderItems(int orderId) {
		init();
		List<OrderItem> itemsList = new ArrayList<>();
		
		try {
			String query = "select * from order_items where order_id = " + orderId;
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				Integer id = rs.getInt("id");
				Integer prodId = rs.getInt("product_id");
				Product product = ProductDao.getProductById(prodId);
				Integer quantity = rs.getInt("quantity");
				
				OrderItem orderItem = new OrderItem(id,orderId,product,quantity);
				
				itemsList.add(orderItem);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return itemsList;
	}
	
	private static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
}
