package jdbc_wejm5_crud_task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EmpMain {
	private static Scanner scanner = new Scanner(System.in);
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static int count = 0;
	private static ResultSet resultSet;

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");
		count = 0;

		// INSERTING DATA
		System.out.println("Insert the data:\n");

		for (int i = 1; i <= 5; i++) {
			preparedStatement = connection.prepareStatement("INSERT INTO EMP VALUES(?,?,?,?)");
			preparedStatement.setInt(1, scanner.nextInt());
			preparedStatement.setString(2, scanner.next());
			preparedStatement.setString(3, scanner.next());

			preparedStatement.setInt(4, scanner.nextInt());
			count = preparedStatement.executeUpdate();
			if (count == 1) {
				System.out.println("Row inserted successfully.");
			} else {
				System.out.println("Not inserted");

			}
		}

		System.out.println("\nDISPLAYING ALL RECORD: \n");

		// DISPLAYING RECORD
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * FROM EMP");
		while (resultSet.next()) {
			System.out.print(resultSet.getInt(1) + " ");
			System.out.print(resultSet.getString(2) + " ");

			System.out.print(resultSet.getString(3) + " ");
			System.out.print(resultSet.getInt(4) + "\n");

			System.out.println("-----------------------------------------------------------");

		}

		System.out.println("\nENTER THE ENAME, JOB, SAL AND EMPNO:\n");
		// UPDATING RECORD

		preparedStatement = connection.prepareStatement("UPDATE EMP SET ENAME=?,JOB=?, SAL=? WHERE EMPNNO=?");

		preparedStatement.setString(1, scanner.next());
		preparedStatement.setString(2, scanner.next());
		preparedStatement.setInt(3, scanner.nextInt());
		preparedStatement.setInt(4, scanner.nextInt());

		count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Row is updated..!!");
		} else {
			System.out.println("Not Updated..");

		}

		System.out.println("\nENTER THE JOB AND EMPNO:\n");
		// UPDATING 1 RECORD

		preparedStatement = connection.prepareStatement("UPDATE EMP SET JOB=? WHERE EMPNNO=?");

		preparedStatement.setString(1, scanner.next());

		preparedStatement.setInt(2, scanner.nextInt());

		int count2 = preparedStatement.executeUpdate();
		if (count2 == 1) {
			System.out.println("Row is updated..!!");
		} else {
			System.out.println("Not Updated..");
		}

		System.out.println("\nENTER THE EMPNO:\n");

		// DELETING 1 RECORD

		preparedStatement = connection.prepareStatement("DELETE FROM EMP WHERE EMPNNO=?");
		preparedStatement.setInt(1, scanner.nextInt());

		int res = preparedStatement.executeUpdate();
		if (res == 1) {
			System.out.println("Row Deleted Successfully..!!");
		} else {
			System.out.println("Not Deleted..");
		}

		// DISPLAYING ALL RECORD

		System.out.println("\nDISPLAYING ALL RECORD:\n");

		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * FROM EMP");
		while (resultSet.next()) {
			System.out.print(resultSet.getInt(1) + " ");
			System.out.print(resultSet.getString(2) + " ");

			System.out.print(resultSet.getString(3) + " ");
			System.out.print(resultSet.getInt(4) + "\n");

			System.out.println("-----------------------------------------------------------");

		}

		connection.close();

	}

}
