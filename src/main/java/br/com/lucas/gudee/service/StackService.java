package br.com.lucas.gudee.service;

import static br.com.lucas.gudee.connection.StackConnection.findALL;
import static br.com.lucas.gudee.connection.StackConnection.findByID;
import static br.com.lucas.gudee.connection.StackConnection.savE;

import java.sql.SQLException;
import java.util.List;

import br.com.lucas.gudee.model.Stack;

public class StackService {

	public void save(Stack stack) throws SQLException {

		savE(stack);

	}

	public List<Stack> findAll() throws SQLException {

		List<Stack> list = findALL();

		return list;

	}

	public Stack findById(Integer id) throws SQLException {
		Stack stack =findByID(id);
		return stack;
	}

}
