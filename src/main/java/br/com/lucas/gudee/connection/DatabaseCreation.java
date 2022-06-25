package br.com.lucas.gudee.connection;

import static br.com.lucas.gudee.connection.ConnectionJDBC.request;
import static br.com.lucas.gudee.connection.Sql.databaseCreation;

public  class DatabaseCreation {

	
	public static void creation() {
		
		
		request(databaseCreation());
	
		 
	}
	
	
	
	
	
	
	
	
	
	
}
