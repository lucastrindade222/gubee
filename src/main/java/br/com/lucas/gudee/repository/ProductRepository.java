package br.com.lucas.gudee.repository;

import java.util.List;

import br.com.lucas.gudee.model.Product;

public interface ProductRepository {

	public void save(Object obj);

	public List<Object> findAll();

	public Object findById(Integer id);

	public void upDate(Object obj);

}
