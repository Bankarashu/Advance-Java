package jdbc_dynamic_query;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

public class CompanyMain {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the id:");
		int id = scanner.nextInt();
		System.out.println("Enter the name:");
		String name = scanner.next();
		System.out.println("Enter the gst:");
		String gst = scanner.next();
		System.out.println("Enter the address:");
		String address = scanner.next();
		System.out.println("Enter the phone:");
		long phone = scanner.nextLong();
		scanner.close();

		FileInputStream fileInputStream = new FileInputStream("companycongif.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("userName"), properties.getProperty("password"));
		CallableStatement callableStatement = connection.prepareCall("call companydb.company_insert(?,?,?,?,?)");

		callableStatement.setInt(1, id);
		callableStatement.setString(2, name);
		callableStatement.setString(3, gst);
		callableStatement.setString(4, address);
		callableStatement.setLong(5, phone);
		int count = callableStatement.executeUpdate();

		if (count == 1) {
			System.out.println("Data Inserted Successfully..!!");

		} else {
			System.out.println("Not Able to Insert.");

		}
		connection.close();
	}
}
