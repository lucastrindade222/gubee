package br.com.lucas.gudee.connection;

import static br.com.lucas.gudee.connection.ConnectionJDBC.request;
import static br.com.lucas.gudee.connection.Sql.createStack_product;

import br.com.lucas.gudee.model.Stack_product;

public class Stack_productConnection {

	public static void savE(Stack_product stack_product) {

		request(createStack_product(stack_product));

	}
}
