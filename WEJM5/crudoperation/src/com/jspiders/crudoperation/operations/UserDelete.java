package com.jspiders.crudoperation.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDelete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/userdb?user=root&password=root";
		String qurey = "DELETE FROM USER WHERE ADDRESS='WAKAD'";
		
		Class.forName(className);
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		
		int result = statement.executeUpdate(qurey);
		
		if(result == 1) {
			System.out.println("Row Deleted Successfully..!!");
		}else {
			System.out.println("No Rows Selected..!!");
		}
	}

}
