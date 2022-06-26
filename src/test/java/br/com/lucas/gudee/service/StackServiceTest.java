package br.com.lucas.gudee.service;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.lucas.gudee.model.Stack;

public class StackServiceTest {

	private StackService service;

	@Before
	public void before() {
		service = new StackService();
	}

	@Test
	public void saveTest() {

		Stack stack = new Stack("Teste 1");

		service.save(stack);

	}
    @Test
	public void findAll() {
		List<Stack> list = null;

		
		list = service.findAll();

		assertNotEquals(list, null);

	}

    @Test
	public void findAById() {
		 Stack stack = null;

		
		 stack = service.findById(1);

		assertNotEquals(stack, null);

	}
    
    
}
