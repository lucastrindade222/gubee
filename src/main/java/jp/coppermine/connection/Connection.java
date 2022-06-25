package jp.coppermine.connection;

import java.sql.SQLException;

public class Connection {

	public static ConnectionJDBC now() {
		return new ConnectionJDBC();
	}

}
