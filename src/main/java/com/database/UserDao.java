package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import com.product.Product;
import com.user.User;

public class UserDao {

	private static Connection connection;

	public static void init() {
		if (connection == null) {
			connection = DBConnection.connection();
		}
	}

	public static void register(User user) {
		init();
		try {
			Statement stmt = connection.createStatement();
			String sql = String.format("INSERT INTO users VALUES (null, \'%s\', \'%s\', \'%s\', \'%s\')",
					user.getName(), user.getEmail(), user.getPassword(), user.getPhoneNumber());
			System.out.println("Executing sql " + sql);
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Optional<Integer> login(String email, String password) {
		init();
		try {
			String query = String.format("select * from users where email = \'%s\' and password = \'%s\'", email,
					password);
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Extract data from result set
			if (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				return Optional.of(id);

			} else {
				System.out.println("Username or password mismatched");
				return Optional.empty();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
