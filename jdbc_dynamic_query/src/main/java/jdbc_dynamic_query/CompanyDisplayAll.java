package jdbc_dynamic_query;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class CompanyDisplayAll {
	public static void main(String[] args) throws Exception {
		
		FileInputStream fileInputStream = new FileInputStream("companycongif.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("userName"), properties.getProperty("password"));
		
		CallableStatement callableStatement = connection.prepareCall("call companydb.company_display_all()");
		
		ResultSet resultSet = callableStatement.executeQuery();
		while (resultSet.next()) {
			System.out.print(resultSet.getInt(1)+" ");
			System.out.print(resultSet.getString(2)+" ");
			System.out.print(resultSet.getString(3)+" ");
			System.out.print(resultSet.getString(4)+" ");
			System.out.print(resultSet.getLong(5)+"\n");
			System.out.print("------------------------------------");
			
		}
		connection.close();
		
	}

}
