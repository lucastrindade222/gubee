package br.com.lucas.gudee.service;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import br.com.lucas.gudee.model.Stack_product;

public class Stack_productServiceTest {

	public Stack_productService service;

	@Before
	public void before() {
		service = new Stack_productService();
	}

	@Test
	public void saveTest() throws SQLException {

		Stack_product stack_product = new Stack_product(1, 2);

		service.save(stack_product);

	}

}
