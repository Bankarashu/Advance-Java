package com.jspiders.crudoperation.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentUpdate {
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
		String query = "UPDATE STUDENT SET NAME=?,MARKS=?,EMAIL=? WHERE ID=?";
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, marks);
		preparedStatement.setString(3, email);
		preparedStatement.setInt(4, id);
		
		int count = preparedStatement.executeUpdate();
		
		if(count == 1) {
			System.out.println("Row Updated Successfully..!!");
		}else {
			System.out.println("No Rows Selected..!!");
		}
		
		connection.close();
	}

}
