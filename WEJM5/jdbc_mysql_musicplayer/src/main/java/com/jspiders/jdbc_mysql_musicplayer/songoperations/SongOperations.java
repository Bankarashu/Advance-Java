package com.jspiders.jdbc_mysql_musicplayer.songoperations;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.jspiders.jdbc_mysql_musicplayer.song.Song;

public class SongOperations {
	public Connection getConnection() throws Exception {
		FileInputStream fileInputStream = new FileInputStream("musicdbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("userName"), properties.getProperty("password"));

		return connection;
	}

	public void addSong(Song song) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO music (id,name,album,singer) VALUES(?,?,?,?)");

		preparedStatement.setInt(1, song.getId());
		preparedStatement.setString(2, song.getName());
		preparedStatement.setString(3, song.getAlbum());
		preparedStatement.setString(4, song.getSinger());

		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Signed Up Successfully..!!");

		} else {
			System.out.println("Not Able to Signed Up..!!");
		}
		connection.close();
	}

	public void playAllSong() throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MUSIC");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.print(resultSet.getInt(1) + " ");
			System.out.print(resultSet.getString(2) + " ");
			System.out.print(resultSet.getString(3) + " ");
			System.out.print(resultSet.getString(4) + "\n");
			System.out.println("----------------------------------------");
		}
		connection.close();
	}

	public void chooseSong(int id) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MUSIC WHERE ID=?");

		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.print(resultSet.getInt(1) + " ");
			System.out.print(resultSet.getString("name") + " ");
			System.out.print(resultSet.getString(3) + " ");
			System.out.print(resultSet.getString(4) + "\n");
			System.out.println("----------------------------------------");
		}

		connection.close();
	}

	public void removeSong(int id) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM MUSIC WHERE ID=?");
		preparedStatement.setInt(1, id);

		int count = preparedStatement.executeUpdate();

		if (count == 1) {
			System.out.println("Row Deleted Successfully..!!");
		} else {
			System.out.println("Not Deleted..");
		}
		connection.close();
	}

	public void editSong(Song song) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE MUSIC SET NAME=?,ALBUM=?, SINGER=? WHERE ID=?");

		preparedStatement.setString(1, song.getName());
		preparedStatement.setString(2, song.getAlbum());
		preparedStatement.setString(3, song.getSinger());
		preparedStatement.setInt(4, song.getId());

		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Row is updated..!!");
		} else {
			System.out.println("Not Updated..");
		}
		connection.close();
	}

}
