package com.jspiders.jdbc.display;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDisplay {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employeedb?user=root&password=root";
		String qurey = "SELECT * FROM EMPLOYEE";
		
		Class.forName(className);
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(qurey);
		while (resultSet.next()) {
			System.out.print(resultSet.getInt(1)+" ");
			System.out.print(resultSet.getString(2)+" ");
			System.out.print(resultSet.getLong(3)+" ");
			System.out.print(resultSet.getString(4)+"\n");
			System.out.println("---------------------------");
			
		}
		connection.close();
	}

}
