package jdbc_productdb;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BatchExecution {
	public static void main(String[] args) throws Exception {
		Product product1 = new Product();
		product1.setId(15);
		product1.setName("Laptop");
		product1.setCost(58000);
		product1.setManufacturer("SONY");

		Product product2 = new Product();
		product2.setId(16);
		product2.setName("TV");
		product2.setCost(25000);
		product2.setManufacturer("LG");

		Product product3 = new Product();
		product3.setId(17);
		product3.setName("AC");
		product3.setCost(30000);
		product3.setManufacturer("BlueStar");

		List<Product> list = new ArrayList<Product>();
		list.add(product1);
		list.add(product2);
		list.add(product3);

		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		FileInputStream fileInputStream = new FileInputStream("productconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("userName"), properties.getProperty("password"));
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUCT VALUES (?,?,?,?)");

		for (Product product : list) {
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getCost());
			preparedStatement.setString(4, product.getManufacturer());

			preparedStatement.addBatch();
		}

		preparedStatement.executeBatch();
		System.out.println("Data Inserted Successfully..!!");
		connection.close();
	}

}
