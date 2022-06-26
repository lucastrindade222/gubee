package br.com.lucas.gudee.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.lucas.gudee.connection.DatabaseCreation;
import br.com.lucas.gudee.model.Product;
import br.com.lucas.gudee.service.ProductService;

/**
 * Sample JAX-RS resources.
 *
 */
@Path("hello")
public class HelloResource {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Product getMessage() {
		
		ProductService service = new ProductService();
		 Product productList = service.findById(1);
		return productList;
	}

}
