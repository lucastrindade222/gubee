package br.com.lucas.gudee.service;

import static br.com.lucas.gudee.connection.StackConnection.findALL;
import static br.com.lucas.gudee.connection.StackConnection.findByID;
import static br.com.lucas.gudee.connection.StackConnection.savE;

import java.util.List;

import br.com.lucas.gudee.model.Stack;

public class StackService {

	public void save(Stack stack) {

		savE(stack);

	}

	public List<Stack> findAll() {

		List<Stack> list = findALL();

		return list;

	}

	public Stack findById(Integer id) {
		Stack stack =findByID(id);
		return stack;
	}

}
