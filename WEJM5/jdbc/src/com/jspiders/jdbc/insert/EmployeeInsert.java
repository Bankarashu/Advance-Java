package com.jspiders.jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//1.Load/Register the driver.
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.Establish Connection
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
		
		//3.Create Statement
		
		Statement statement= connection.createStatement();
		
		//4.Execute Statement
		
		statement.execute("INSERT INTO EMPLOYEE VALUES(4,'DHRUV',7875688801,'BARAMATI')");
		
		//5.Close Connection
		
		connection.close();
	}

}
