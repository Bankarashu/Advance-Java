package com.jspiders.crudoperation.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentDisplay {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id that U want to diaplay:");
		int id = scanner.nextInt();
		scanner.close();
		String url = "jdbc:mysql://localhost:3306/studentdb?user=root&password=root";
		String query = "SELECT * FROM STUDENT";
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			System.out.print(resultSet.getInt(1)+" ");
			System.out.print(resultSet.getString(2)+" ");
			System.out.print(resultSet.getInt(3)+" ");
			System.out.print(resultSet.getString(4)+"\n");
			System.out.println("-------------------------------------");
			
		}
		connection.close();
	}

}
