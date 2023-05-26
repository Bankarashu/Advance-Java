package com.jspiders.jdbc.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDelete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employeedb";
		String userName = "root";
		String password = "root";
		String query = "DELETE FROM EMPLOYEE WHERE ID=1";
		
		Class.forName(className);
		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(query);
		
		if (result == 1) {
			System.out.println("Row Deleted Successfully..!!");
			
		} else {
			System.out.println("No Rows Selected..!!");
		}
		connection.close();
		
	}

}
