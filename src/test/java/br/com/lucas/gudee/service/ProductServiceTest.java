package br.com.lucas.gudee.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.lucas.gudee.model.Product;

public class ProductServiceTest {

	private ProductService service;

	@Before
	public void before() {
		service = new ProductService();
	}

	@Test
	public void saveTest() {

		Product product = new Product("java", "dic");

		service.save(product);

	}

	@Test
	public void fandall() {

		List<Product> list = null;

		list = service.findall();

		System.out.println(list.size());
		Assert.assertNotEquals(list, null);

	}

	@Test
	public void fandById() {

		Product product = null;

		product = service.findById(1);

		System.out.println("||id:"+product.toString());
		Assert.assertNotEquals(product, null);

	}
	@Test
	public void findByName() {
		List<Product> product = null;

		product = service.findByName("java");

		System.out.println(product.size());
		Assert.assertNotEquals(product, null);
	}

}
