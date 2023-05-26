package jdbc_student_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Student {
	private static Scanner scanner = new Scanner(System.in);
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static int count = 0;
	private static ResultSet resultSet;
	private final static String className = "com.mysql.cj.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/studentdb";
	private final static String userName = "root";
	private final static String password = "root";
	private static String query;

	public static void main(String[] args) throws Exception {
		Class.forName(className);
		connection = DriverManager.getConnection(url, userName, password);
		statement = connection.createStatement();

		// CREATING THE TABLE

		query = "CREATE TABLE STUDENT1 (ROLLNO INT(4) PRIMARY KEY ,SNAME VARCHAR(20), EMAIL VARCHAR(20), PHONE INT(20))";
		count = statement.executeUpdate(query);

		System.out.println("Table created successfully..!!");
		count = 0;

		// INSERTING DATA INTO THE TABLE

		query = "INSERT INTO STUDENT1 VALUES (?,?,?,?)";
		preparedStatement = connection.prepareStatement(query);
		for (int i = 1; i <= 5; i++) {
			System.out.println("Enter the roll no:");
			preparedStatement.setInt(1, scanner.nextInt());

			System.out.println("Enter the name:");
			preparedStatement.setString(2, scanner.next());

			System.out.println("Enter the email");
			preparedStatement.setString(3, scanner.next());

			System.out.println("Enter the mobile number:");
			preparedStatement.setInt(4, scanner.nextInt());

			count = count + preparedStatement.executeUpdate();
		}
		System.out.println(count + " record is inserted..!!");
		count = 0;

		// DISPLAYING ALL THE RECORD

		query = "SELECT * FROM STUDENT1";
		resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getInt(4));
		}

		// UPDATING ALL RECORD
		query = "UPDATE STUDENT1 SET SNAME=?,EMAIL=?,PHONE=? WHERE ROLLNO=?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, scanner.next());
		preparedStatement.setString(2, scanner.next());
		preparedStatement.setInt(3, scanner.nextInt());
		preparedStatement.setInt(4, scanner.nextInt());

		count = preparedStatement.executeUpdate();
		System.out.println(count + " record updated..!!");
		count = 0;

		// UPDATING 1 RECORD
		query = "UPDATE STUDENT1 SET SNAME=? WHERE ROLLNO=?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, scanner.next());
		preparedStatement.setInt(2, scanner.nextInt());

		count = preparedStatement.executeUpdate();
		System.out.println(count + " record updated..!!");
		count = 0;

		// DISPLAY ALL RECORD
		query = "SELECT * FROM STUDENT1";
		resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getInt(4));
		}

		// deleting 1 record
		query = "DELETE * FROM STUDENT1 WHERE ROLLNO=?";
		preparedStatement = connection.prepareStatement(query);
		System.out.println("Enter the roll no to delete:");
		preparedStatement.setInt(1, scanner.nextInt());
		count = preparedStatement.executeUpdate();
		System.out.println(count + " record deleted..!!");
		count = 0;

		// DISPLAYING ALL RECORD
		query = "SELECT * FROM STUDENT1";
		resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getInt(4));
		}

	}

}
