package com.jspiders.crudoperation.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentDelete {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id that U wnat to delete:");
		int id = scanner.nextInt();
		
		scanner.close();
		
		String url = "jdbc:mysql://localhost:3306/studentdb?user=root&password=root";
		String query = "DELETE FROM STUDENT WHERE ID=?";
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setInt(1, id);
		int count = preparedStatement.executeUpdate();
		
		if(count == 1) {
			System.out.println("Row Deleted Successfully..!!");
		}else {
			System.out.println("Now Rows Selected..!!");
		}
		
		
		
	}

}
