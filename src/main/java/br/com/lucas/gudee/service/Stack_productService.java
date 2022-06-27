package br.com.lucas.gudee.service;

import static br.com.lucas.gudee.connection.Stack_productConnection.savE;

import java.sql.SQLException;

import br.com.lucas.gudee.model.Stack_product;

public class Stack_productService {

	public void save(Stack_product stack_product) throws SQLException {
	     
		savE(stack_product);
	}

}
