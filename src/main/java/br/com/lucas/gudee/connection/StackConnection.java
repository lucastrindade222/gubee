package br.com.lucas.gudee.connection;

import static br.com.lucas.gudee.connection.ConnectionJDBC.connectionNow;
import static br.com.lucas.gudee.connection.Sql.createStack;
import static br.com.lucas.gudee.connection.Sql.findByIdStack;
import static br.com.lucas.gudee.connection.Sql.findStackByProductID;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.lucas.gudee.model.Stack;

public class StackConnection {

	public static void savE(Stack stack) {
		ConnectionJDBC.request(createStack(stack));
	}

	public static List<Stack> findALL() {
		List<Stack> list = new ArrayList<Stack>();
		try {
			Connection connection = connectionNow();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.findAllStack());

			while (rs.next()) {
				Stack stack = new Stack(rs.getInt("stackId"), rs.getString("name"));
				list.add(stack);
			}
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}
		return list;
	}

	public static Stack findByID(Integer id) {
		Stack stack = new Stack();
		try {
			Connection connection = connectionNow();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(findByIdStack(id));

			while (rs.next()) {

				stack = new Stack(rs.getInt("stackId"), rs.getString("name"));

			}
		} catch (SQLException e) {
			stack = null;
			e.printStackTrace();
		}

		return stack;
	}

	public static List<Stack> findStackByProductId(Integer productId) {
		List<Stack> list = new ArrayList<Stack>();
		try {
			Connection connection = connectionNow();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(findStackByProductID(productId));

			while (rs.next()) {
				Stack stack = new Stack(rs.getInt("stackId"), rs.getString("name"));
				list.add(stack);
			}
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}
		return list;
	}

}
