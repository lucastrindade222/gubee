package br.com.lucas.gudee.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.lucas.gudee.dto.ProductDTO;
import br.com.lucas.gudee.model.Product;
import br.com.lucas.gudee.service.ProductService;

@Path("produc")
public class ProductResource {

	public ProductService start() {
		return new ProductService();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductDTO> findAll() {
		ProductService service = start();
		List<Product> list = service.findAllFull();
		List<ProductDTO> listDTO = list.stream().map(obj -> new ProductDTO(obj)).collect(Collectors.toList());

		return listDTO;

	}

}
