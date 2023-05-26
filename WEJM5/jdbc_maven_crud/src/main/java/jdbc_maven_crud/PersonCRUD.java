package jdbc_maven_crud;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class PersonCRUD {
	
	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("userName"), properties.getProperty("password"));
		
		
		return connection;
		
	}

//Inserting the person's record.
	
	public void savePerson(Person person) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PERSON VALUES (?,?,?)");
		preparedStatement.setInt(1, person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setLong(3, person.getPhone());
		
		
		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Row Inserted Successfully...!!");
			
		} else {
			System.out.println("Row Not Inserted..");

		}
		
		connection.close();		
	}

//Updating the person's record.
	
	public void updatePerson(Person person) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PERSON SET NAME=?,PHONE=? WHERE ID=?");
		
		preparedStatement.setString(1, person.getName());
		preparedStatement.setLong(2, person.getPhone());
		preparedStatement.setInt(3, person.getId());
		
		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Row is updated..!!");
		} else {
			System.out.println("Not Updated..");

		}
		connection.close();
		
	}
	
//Deleting the person record.
	
	public void deletePerson(int id) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PERSON WHERE ID=?");
		preparedStatement.setInt(1, id);
		
		int count = preparedStatement.executeUpdate();
		
		if (count == 1) {
			System.out.println("Row Deleted Successfully..!!");
		} else {
			System.out.println("Not Deleted..");
		}
		connection.close();
	}

//Displaying record according to condition.
	
	public void displayRecord(int id) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERSON WHERE ID=?");
		
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			System.out.print(resultSet.getInt(1)+" ");
			System.out.print(resultSet.getString("name")+" ");
			System.out.print(resultSet.getLong(3)+"\n");
			System.out.println("----------------------------------------");
		}
		connection.close();
	}

//displaying the all record of person.
	
	public void displayAllRecord() throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERSON");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.print(resultSet.getInt(1)+" ");
			System.out.print(resultSet.getString(2)+" ");
			System.out.print(resultSet.getLong(3)+"\n");
			System.out.println("----------------------------------------");
		}
		connection.close();
	}
}
