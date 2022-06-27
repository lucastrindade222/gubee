package br.com.lucas.gudee.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.lucas.gudee.model.TargetMarket;

public class TargetMarketServiceTeste {

	private TargetMarketService service;

	@Before
	public void before() {
		service = new TargetMarketService();
	}

	@Test
	public void saveTeste() throws SQLException {

		TargetMarket targetMarket = new TargetMarket("teste 1");

		service.save(targetMarket);

	}

	@Test
	public void findAllTeste() throws SQLException {

		List<TargetMarket> list = null;

		list = service.findAll();

		Assert.assertNotEquals(list, null);

	}
	
	@Test
	public void findById() throws SQLException {
		
		TargetMarket targetMarket;
		
		targetMarket = service.findById(1);
		
		Assert.assertNotEquals(targetMarket, null);
	}
	

}
