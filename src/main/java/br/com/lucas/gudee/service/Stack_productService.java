package br.com.lucas.gudee.service;

import static br.com.lucas.gudee.connection.Stack_productConnection.savE;

import br.com.lucas.gudee.model.Stack_product;

public class Stack_productService {

	public void save(Stack_product stack_product) {
	     
		savE(stack_product);
	}

}
