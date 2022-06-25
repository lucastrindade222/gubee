package br.com.lucas.gudee.test;

import static br.com.lucas.gudee.connection.Sql.createProduct;
import static br.com.lucas.gudee.connection.Sql.createStack;
import static br.com.lucas.gudee.connection.Sql.findAllProduct;
import org.junit.Assert;
import org.junit.Test;

import br.com.lucas.gudee.connection.ConnectionJDBC;
import br.com.lucas.gudee.connection.DatabaseCreation;
import br.com.lucas.gudee.model.Product;
import br.com.lucas.gudee.model.Stack;
 

public class SqlTest {

	
	@Test
	public void createProductTest() {
		
		
		Product product = new Product("lucas","disc");
		String sql = createProduct(product);
		Assert.assertEquals("Erro na craçao do sql Produto","INSERT INTO product (product.productName,product.description) VALUES ('lucas','disc')", sql);
		
	}
	@Test
	public void createStackTest() {
		
		
		Stack stack = new Stack("nome");
		String sql = createStack(stack);
		Assert.assertEquals("Erro na craçao do sql Stack","INSERT INTO stack (stack.nome) VALUES ('nome')", sql);
		
	}
	
	@Test
	public void findAllStackTest() {
		
		
 
		String sql = findAllProduct();
		Assert.assertEquals("Erro na craçao do sql findAll","SELECT productId, productName, description FROM product", sql);
		
	}
	
	
	
	@Test
	public void createDatabase() {
		 
		DatabaseCreation.creation();
 
	}
	
	
	
	
	
	
}
