package com.jspiders.crudoperation.operations;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/userdb?user=root&password=root";
		
		Class.forName(className);
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		/*statement.execute("INSERT INTO USER VALUES (1,'BHUMI',7875688801,'bhumiS@gmail.com','Bhumi@123','Baramati'),"
												+ "(2,'DHRUV',9860980925,'dhruvS@gmail.com','Dhruv@321','Baramati'),"
												+ "(3,'ROSHANI',7768036990,'roshaniS@gmail.com','Roshani@7117','PUNE'),"
												+ "(4,'BATTERY',8080943339,'batteryS@gmail.com','Battery@1799','PUNE')");*/
		
		statement.execute("INSERT INTO USER VALUES(5,'ABC',7845962145,'ABC@GMAIL.COM','ABC123','WAKAD')");
		
		connection.close();
	}
}

