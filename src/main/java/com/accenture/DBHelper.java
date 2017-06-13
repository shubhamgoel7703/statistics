package com.accenture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private static Connection connection = null;

	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/shubham", "root", "root");
		return connection;
	}

	public static void closeConnection() throws SQLException {
		connection.close();
	}
}
