package br.com.lucas.gudee.service;

import java.sql.SQLException;
import java.util.Arrays;
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
	public void saveTest() throws SQLException {

		Product product = new Product("java", "dic");

		service.save(product);

	}

	@Test
	public void fandall() throws SQLException {

		List<Product> list = null;

		list = service.findall();

		System.out.println(list.size());
		Assert.assertNotEquals(list, null);

	}

	@Test
	public void fandById() throws SQLException {

		Product product = null;

		product = service.findById(1);

		System.out.println("||id:" + product.toString());
		Assert.assertNotEquals(product, null);

	}

	@Test
	public void findByName() {
		List<Product> product = null;

		product = service.findByName("java");

		System.out.println(product.size());
		Assert.assertNotEquals(product, null);
	}

	@Test
	public void findokAll() throws SQLException {

		List<Product> list = null;

		list = service.findall();
		Assert.assertNotEquals(list, null);
	}

	@Test
	public void findAllFull() throws SQLException {

		List<Product> productList = null;

		productList = service.findAllFull();

		productList.stream().forEach(p -> Assert.assertNotEquals(p.getStack(), null));
		productList.stream().forEach(p -> Assert.assertNotEquals(p.getTargetMarket(), null));

	}

	@Test
	public void findAllFullByStackId() throws SQLException {

		List<Product> productList = null;
		List<Integer> Ids = Arrays.asList(1, 2);

		productList = service.findAllFullByStackId(Ids);

		productList.stream().forEach(p -> Assert.assertNotEquals(p.getStack(), null));
		productList.stream().forEach(p -> Assert.assertNotEquals(p.getTargetMarket(), null));

	}

}
