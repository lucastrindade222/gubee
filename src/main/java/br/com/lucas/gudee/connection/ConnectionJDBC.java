package br.com.lucas.gudee.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionJDBC {

 
	private static Connection connection = null;
	private static Statement stmt = null;
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:./db/gubee";
	static final String USER = "sa";
	static final String PASS = "";

	//
	public ConnectionJDBC() {
	};

	public static Connection connectionNow() {

		try {

			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			 

			System.out.println("Connection established to the database");

			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void request(String sql) {

		try {
			connectionNow();
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			connection.close();

		} catch (SQLException e) {
          if(e.getErrorCode() != 42101)
			e.printStackTrace();
		}

	}

	public static ResultSet requestResult(String sql) {

		try {
			connectionNow();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			close();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void close() {
		try {
			connection.close();
			System.out.println("Closed connection to database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
