package com;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection	connection;

	public static Connection getconnection() {

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "admin", "admin");
		}
		catch (Exception e)
		{
			System.err.println("Error  : " + e);
		}
		return connection;
	}
}
