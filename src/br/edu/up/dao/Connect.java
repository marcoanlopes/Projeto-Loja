package br.edu.up.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	private static final String URL = "jdbc:sqlite:D:\\Eclipse\\Workspace\\DB\\projetoloja.db";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL);
		
	}
}
