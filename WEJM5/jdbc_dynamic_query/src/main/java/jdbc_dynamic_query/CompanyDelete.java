package jdbc_dynamic_query;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

public class CompanyDelete {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id:");
		int id = scanner.nextInt();
		scanner.close();

		FileInputStream fileInputStream = new FileInputStream("companycongif.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("userName"), properties.getProperty("password"));

		CallableStatement callableStatement = connection.prepareCall("call companydb.company_delete(?)");

		callableStatement.setInt(1, id);
		int count = callableStatement.executeUpdate();

		if (count == 1) {
			System.out.println("Deleted Successfully..!!");

		} else {
			System.out.println("Record Does not Matched..");

		}
		connection.close();
	}

}
