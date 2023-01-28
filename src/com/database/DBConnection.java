package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection dbConnection = null;
	
	public static Connection connection() {
		if(dbConnection != null) {
			return dbConnection;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("******* MySQL Driver Registered");
		} catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
			System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
            e.printStackTrace();
            return null;
        }
		
		try {
            // DriverManager: The basic service for managing a set of JDBC drivers.
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_house", "root", "1234567890");
            if (dbConnection != null) {
            	System.out.println("Connection Successful! Enjoy. Now it's time to push data");
            } else {
            	System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
        	System.out.println("MySQL Connection Failed!");
            e.printStackTrace();
            return null;
        }
		return dbConnection;
	}

}
