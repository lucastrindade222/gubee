package jp.coppermine.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

	private static String url = "jdbc:h2:mem:gubee";


	//
	public ConnectionJDBC() {
	};
	


	public   Connection connection() {
		    Connection connection;
		try {
			
			connection = DriverManager.getConnection(url);
			connection.close();
			System.out.println("Connection established to the database");

			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection clos) {
		try {
			clos.close();
			System.out.println("Closed connection to database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

 

}
