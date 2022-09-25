package com.doctorapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static Connection connection;
	public Connection getConnection() {
		String url="jdbc:mysql://localhost:3306/doctordb";
		String username="root";
		String password="root";
		try {
			connection=DriverManager.getConnection(url, username, password);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;	
	}
	public void closeConnection() {
		try {
			if(connection!=null)
				connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
