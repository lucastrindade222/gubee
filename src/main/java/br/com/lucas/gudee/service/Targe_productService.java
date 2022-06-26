package br.com.lucas.gudee.service;

import java.util.List;

import br.com.lucas.gudee.connection.Targe_productConnection;
import br.com.lucas.gudee.model.Targe_product;

public class Targe_productService {

	public void save(Targe_product targe_product) {
		Targe_productConnection.savE(targe_product);

	}

	public List<Targe_product> findAll() {
		List<Targe_product> list = Targe_productConnection.findALL();
		return list;
	}

}
