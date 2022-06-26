package br.com.lucas.gudee.service;

import static br.com.lucas.gudee.connection.ProductConnection.findAll;
import static br.com.lucas.gudee.connection.ProductConnection.findBYID;
import static br.com.lucas.gudee.connection.ProductConnection.findBYNAME;
import static br.com.lucas.gudee.connection.ProductConnection.savE;
import static br.com.lucas.gudee.connection.StackConnection.findStackByProductId;

import java.util.List;

import br.com.lucas.gudee.connection.ProductConnection;
import br.com.lucas.gudee.connection.TargetMarketConnection;
import br.com.lucas.gudee.model.Product;
import br.com.lucas.gudee.model.Stack;
import br.com.lucas.gudee.model.TargetMarket;

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

	public List<Product> findAllFull() {
		 
		List<Product> list = findAll(); 
	 
		
		
		return  fromListProduct(list);
	}

	public List<Product> findAllFullByStackId(Integer[] ids) {
		List<Product> list = ProductConnection.findAllFullByStackID(ids); 
		
		
		 
		return  fromListProduct(list);
	}
	public List<Product> fromListProduct(List<Product> list){
		
		int counter = 0;
		for (Product product : list) {
			
			List<Stack> stackList =	findStackByProductId(product.getProductId());
		    List<TargetMarket> targetMarket =TargetMarketConnection.findTargetMarketByProductId(product.getProductId());
			list.get(counter).setStack(stackList);
			list.get(counter).setTargetMarket(targetMarket);
			counter++;
		}
		
		return list;
		
	}

}
