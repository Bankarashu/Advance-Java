package com.jspiders.crudoperation.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserUpdate {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	String className = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/userdb?user=root&password=root";
	String query = "UPDATE USER SET PHONE='8412006746' WHERE ID=4";
	
	Class.forName(className);
	Connection connection = DriverManager.getConnection(url);
	Statement statement = connection.createStatement();
	
	statement.executeUpdate(query);
	connection.close();
	}

}
