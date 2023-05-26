package com.jspiders.jdbc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeUpdate {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employeedb";
		String userName = "root";
		String password = "root";
		String qurey = "UPDATE EMPLOYEE SET PHONE=9860980925 WHERE ID=1";
		
		Class.forName(className);
		Connection connection = DriverManager.getConnection(url,userName,password);
		Statement statement = connection.createStatement();
		
		statement.execute(qurey);
	}

}
