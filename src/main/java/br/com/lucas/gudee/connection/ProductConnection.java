package br.com.lucas.gudee.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.lucas.gudee.model.Product;
import br.com.lucas.gudee.repository.ProductRepository;

public class ProductConnection {

	public static void savE(Product product) {
		System.out.println("sql|" + Sql.createProduct(product));
		ConnectionJDBC.request(Sql.createProduct(product));

	}

	public static List<Product> findAll() {
		List<Product> list = new ArrayList<Product>();
		try {
			Connection connection = ConnectionJDBC.connectionNow();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.findAllProduct());

			while (rs.next()) {

				Product product = new Product(rs.getInt("productId"), rs.getString("productName"),
						rs.getString("description"));
				list.add(product);
			}
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}
		return list;
	}

	public static Product findBYID(Integer id) {
		Product product = new Product();

		try {
			Connection connection = ConnectionJDBC.connectionNow();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.findById(id));

			while (rs.next()) {

				product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getString("description"));

			}
		} catch (SQLException e) {
			product = null;
			e.printStackTrace();
		}
		return product;
	}

	public static List<Product> findBYNAME(String name) {
		List<Product> productList = new ArrayList<Product>();

		try {
			Connection connection = ConnectionJDBC.connectionNow();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.findByNome(name));

			while (rs.next()) {

				Product product = new Product(rs.getInt("productId"), rs.getString("productName"),
						rs.getString("description"));
				productList.add(product);
			}
		} catch (SQLException e) {
			productList = null;
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> findByStack(Integer stack) {

		return null;
	}

	public List<Product> findByTarget(Integer target) {

		return null;
	}

	public void upDate(Product obj) {
		// TODO Auto-generated method stub

	}

}
