package br.com.lucas.gudee.service;

import java.util.List;

import javax.ws.rs.Encoded;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.lucas.gudee.model.Targe_product;

public class Targe_productServiceTeste {

	private Targe_productService server;

	@Before
	public void before() {
		server = new Targe_productService();
	}

	@Test
	@Ignore
	public void saveTest() {
		Targe_product targe_product = new Targe_product(1, 2);

		server.save(targe_product);

	}

	@Test
	public void findAll() {
		List<Targe_product> list = null;

		list = server.findAll();
		
		Assert.assertNotEquals(list, null);
	}

}
