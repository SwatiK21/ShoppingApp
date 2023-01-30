package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.product.Product;

public class ProductDao {
	private static Connection connection;
	
	public static void init() {
		if(connection == null) {
			connection = DBConnection.connection();
		}
	}
	
	public List<Product> listProducts() {
		SessionFactory sessionFactory;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        criteria.from(Product.class);
        List<Product> products = session.createQuery(criteria).getResultList();
        session.close();
        return products;
	}
	
	
	public static List<Product> listProducts2() {
		init();
		List<Product> productsList = new ArrayList<>();
		try {
			String query = "select * from products";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String type = rs.getString("type");
				String name = rs.getString("name");
				String description = rs.getNString("description");
				String image = rs.getString("image");
				Double price = rs.getDouble("price");
				System.out.println(String.format("Fetched %d, %s, %s, %f", id, name, image, price));
				
				Product product = new Product(id,type,name,description, image, price);
				
				productsList.add(product);
			} 
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return productsList;
	}
	
	public static Product getProductById(int productId) {
		return null;
	}

}
