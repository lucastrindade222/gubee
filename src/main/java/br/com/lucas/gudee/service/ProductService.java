package br.com.lucas.gudee.service;

import static br.com.lucas.gudee.connection.ProductConnection.findAll;
import static br.com.lucas.gudee.connection.ProductConnection.findBYID;
import static br.com.lucas.gudee.connection.ProductConnection.findBYNAME;
import static br.com.lucas.gudee.connection.ProductConnection.savE;

import java.util.List;

import br.com.lucas.gudee.model.Product;

public class ProductService {

	public Product findById(Integer id) {
		Product product = findBYID(id);
		return product;
	}

	public List<Product> findByName(String name) {
		List<Product> product = findBYNAME(name);
		return product;
	}

	public List<Product> findall() {

		return findAll();

	}

	public void save(Product product) {

		savE(product);

	}

}
