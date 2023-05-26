package com.jspiders.crudoperation.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDisplay {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/userdb?user=root&password=root";
		String query = "SELECT * FROM USER";
		
		Class.forName(className);
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			System.out.print(resultSet.getInt(1)+" ");
			System.out.print(resultSet.getString(2)+" ");
			System.out.print(resultSet.getLong(3)+" ");
			System.out.print(resultSet.getString(4)+" ");
			System.out.print(resultSet.getString(5)+" ");
			System.out.print(resultSet.getString(6)+"\n");
			System.out.println("-----------------------------------------------------------");
			
		}
		
		connection.close();
	}

}
