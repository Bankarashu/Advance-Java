package com.jspiders.crudoperation.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentInsert {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id:");
		int id = scanner.nextInt();
		System.out.println("Enter the name:");
		String name = scanner.next();
		System.out.println("Enter the marks:");
		int marks = scanner.nextInt();
		System.out.println("Enter the email");
		String email = scanner.next();
		scanner.close();
		
		String url = "jdbc:mysql://localhost:3306/studentdb?user=root&password=root";
		String query = "INSERT INTO STUDENT VALUES(?,?,?,?)";
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setInt(3, marks);
		preparedStatement.setString(4, email);
		
		int count = preparedStatement.executeUpdate();
		
		if(count == 1) {
			System.out.println("Row Inserted Successfully..!!");
		}else {
			System.out.println("Not Inserted..!!");
		}
		
		connection.close();
	}

}
