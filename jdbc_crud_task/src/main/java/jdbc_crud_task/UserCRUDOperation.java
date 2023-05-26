package jdbc_crud_task;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class UserCRUDOperation {

	public Connection getConnection() throws Exception {
		FileInputStream fileInputStream = new FileInputStream("udbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("userName"), properties.getProperty("password"));

		return connection;
	}

	// SignUp Page
	public void signUp(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO USER (id,name,email,password,address) VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(5, user.getAddress());

		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Signed Up Successfully..!!");

		} else {
			System.out.println("Not Able to Signed Up..!!");
		}
		connection.close();
	}

	// Login Page
	public boolean logIn(User user) throws Exception {
		Connection connection = getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER WHERE EMAIL=?");
		preparedStatement.setString(1, user.getEmail());

		ResultSet resultSet = preparedStatement.executeQuery();

		String password = null;
		while (resultSet.next()) {

			password = resultSet.getString("password");
		}

		connection.close();

		if (password.equals(user.getPassword())) {
			return true;
		}
		return false;
	}

//Displaying all the password's

	public void displayPasswords(String email) throws Exception {
		Connection connection = getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER WHERE EMAIL=?");
		preparedStatement.setString(1, email);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.println("The Saved Passwords are:\n");
			System.out.println("Facebook : " + resultSet.getString("facebookpassword"));
			System.out.println("What's up : " + resultSet.getString("whatsuppassword"));
			System.out.println("Snap Chat : " + resultSet.getString("snappassword"));
			System.out.println("Twitter : " + resultSet.getString("twitterpassword") + "\n");
		}

		connection.close();
	}

	public void updatePassword(User user) throws Exception {
		Connection connection = getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USER SET facebookpassword=?,whatsuppassword=?, snappassword=?, twitterpassword=? WHERE EMAIL=?");
		preparedStatement.setString(1, user.getFacebookpassword());
		preparedStatement.setString(2, user.getWhatsuppassword());
		preparedStatement.setString(3, user.getSnappassword());
		preparedStatement.setString(4, user.getTwitterpassword());
		preparedStatement.setString(5, user.getEmail());
		
		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Updated Successfully..!!");
		} else {
			System.out.println("Failed to Update");
		}
		connection.close();
		
	}

	// Displaying the record
	public void displayRecord() throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER");
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.print(resultSet.getInt(1) + " ");
			System.out.print(resultSet.getString(2) + " ");
			System.out.print(resultSet.getString(3) + " ");
			System.out.print(resultSet.getString(4) + " ");
			System.out.print(resultSet.getString(5) + " ");
			System.out.print(resultSet.getString(6) + " ");
			System.out.print(resultSet.getString(7) + " ");
			System.out.print(resultSet.getString(8) + " ");
			System.out.print(resultSet.getString(9) + "\n");
			System.out.println(
					"-----------------------------------------------------------------------------------------------");

		}
		connection.close();

	}
}
