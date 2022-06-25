package br.com.lucas.gudee.service;

import java.util.List;

import br.com.lucas.gudee.connection.ProductConnection;
import br.com.lucas.gudee.model.Product;

public class ProductService {
	
	

	public void save(Product product) {

		ProductConnection.save(product);

	}

	public List<Product> findall() {

		return ProductConnection.findAll();

	}

}
