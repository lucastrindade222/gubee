package br.com.lucas.gudee.connection;

import static br.com.lucas.gudee.connection.ConnectionJDBC.connectionNow;
import static br.com.lucas.gudee.connection.ConnectionJDBC.request;
import static br.com.lucas.gudee.connection.Sql.createProduct;
import static br.com.lucas.gudee.connection.Sql.findAllFullByStackId;
import static br.com.lucas.gudee.connection.Sql.findAllProduct;
import static br.com.lucas.gudee.connection.Sql.findByIdProduct;
import static br.com.lucas.gudee.connection.Sql.findByNameProduct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.lucas.gudee.model.Product;

public class ProductConnection {

	public static void savE(Product product) {

		request(createProduct(product));

	}

	public static List<Product> findAll() {
		List<Product> list = new ArrayList<Product>();
		try {
			Connection connection = connectionNow();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(findAllProduct());

			while (rs.next()) {
				System.out.println(
						rs.getInt("productId") + "|" + rs.getString("productName") + "|" + rs.getString("description"));
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
			Connection connection = connectionNow();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(findByIdProduct(id));

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
			Connection connection = connectionNow();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(findByNameProduct(name));

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

 

	public static List<Product> findAllFullByStackID(List<Integer> ids) {
		List<Product> productList = new ArrayList<Product>();

		try {
			Connection connection = connectionNow();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(findAllFullByStackId(ids));

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

}
