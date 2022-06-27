package br.com.lucas.gudee.service;

import static br.com.lucas.gudee.connection.ProductConnection.findAll;
import static br.com.lucas.gudee.connection.ProductConnection.findBYID;
import static br.com.lucas.gudee.connection.ProductConnection.findBYNAME;
import static br.com.lucas.gudee.connection.ProductConnection.savE;
import static br.com.lucas.gudee.connection.StackConnection.findStackByProductId;
import static br.com.lucas.gudee.connection.TargetMarketConnection.findTargetMarketByProductId;
import static br.com.lucas.gudee.service.utility.CodeToBeCleaned.toConvert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lucas.gudee.connection.ProductConnection;
import br.com.lucas.gudee.dto.ProductLinkDTO;
import br.com.lucas.gudee.dto.ProductLinkStringDTO;
import br.com.lucas.gudee.dto.SearDTO;
import br.com.lucas.gudee.model.Product;
import br.com.lucas.gudee.model.Stack;
import br.com.lucas.gudee.model.Stack_product;
import br.com.lucas.gudee.model.Targe_product;
import br.com.lucas.gudee.model.TargetMarket;
import br.com.lucas.gudee.service.utility.CodeToBeCleaned;

public class ProductService {

	public Product findById(Integer id) throws SQLException {
		Product product = findBYID(id);
		return product;
	}

	public List<Product> findByName(String name) {
		List<Product> product = findBYNAME(name);
		return product;
	}

	public List<Product> findall() throws SQLException {

		return findAll();

	}

	public void save(Product product) throws SQLException {

		savE(product);

	}

	public List<Product> findAllFull() throws SQLException {

		List<Product> list = findAll();

		return fromListProduct(list);
	}

	public List<Product> findAllFullByStackId(List<Integer> ids) throws SQLException {
		System.out.println("ok aqui entrou");
		List<Product> list = ProductConnection.findAllFullByStackID(ids);
		System.out.println("ok aqui saiu");
		return list;
	}

	public List<Product> fromListProduct(List<Product> list) throws SQLException {

		int counter = 0;
		for (Product product : list) {

			List<Stack> stackList = findStackByProductId(product.getProductId());
			List<TargetMarket> targetMarket = findTargetMarketByProductId(product.getProductId());
			list.get(counter).setStack(stackList);
			list.get(counter).setTargetMarket(targetMarket);
			counter++;
		}

		return list;

	}

	public void ProductLink(ProductLinkDTO productLinkDTO) throws SQLException {

		Stack_productService stack_productService = new Stack_productService();
		Targe_productService targe_productService = new Targe_productService();

		for (Integer idStack : productLinkDTO.getStack()) {
			stack_productService.save(new Stack_product(productLinkDTO.getProduto(), idStack));
		}

		for (Integer idTargetMarket : productLinkDTO.getTargetMarket()) {
			targe_productService.save(new Targe_product(idTargetMarket, productLinkDTO.getProduto()));
		}

	}

	public ProductLinkDTO fromDTO(ProductLinkStringDTO dto) {

		return new ProductLinkDTO(dto.getProduct(), toConvert(dto.getStack()), toConvert(dto.getMaket()));
	}

	public List<Integer> fromDTO(SearDTO dto) {

		return toConvert(dto.getIds().toString());
	}

}
