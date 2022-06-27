package br.com.lucas.gudee.resource;

import static java.util.stream.Collectors.toList;

import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.lucas.gudee.connection.DatabaseCreation;
import br.com.lucas.gudee.dto.ProductDTO;
import br.com.lucas.gudee.dto.ProductLinkDTO;
import br.com.lucas.gudee.dto.ProductLinkStringDTO;
import br.com.lucas.gudee.model.Product;
import br.com.lucas.gudee.resource.exception.DatabaseException;
import br.com.lucas.gudee.service.ProductService;
import static br.com.lucas.gudee.service.utility.CodeToBeCleaned.toConvert;

@Path("produc")
public class ProductResource {

	public ProductService start() {
		return new ProductService();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response findById(@PathParam("id") Integer id) {

		ProductService service = start();
		try {
			Product products = service.findById(id);
			return Response.ok(products).build();
		} catch (SQLException e) {
			return Response.ok(new DatabaseException("Internal server error")).status(500).build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/sear/")
	public Response findSear(@QueryParam("ids") String Ids) throws SQLException {
		String textoDeserializado = new String(Base64.getDecoder().decode(Ids));
		System.out.println("ids:" + textoDeserializado);
		ProductService service = start();
		 

			List<Product> products = service.findAllFullByStackId(toConvert(textoDeserializado));
			return Response.ok(products).build();
		 

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		try {
			DatabaseCreation.bankCreationTest();
			List<Product> list;
			ProductService service = start();
			list = service.findAllFull();
			List<ProductDTO> listDTO = list.stream().map(obj -> new ProductDTO(obj)).collect(toList());

			return Response.ok(listDTO).build();
		} catch (SQLException e) {
			return Response.ok(new DatabaseException("Internal server error")).status(500).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/salva/produto")
	public Response salva(Product product) {
		ProductService service = start();
		try {
			service.save(product);
			return Response.ok().build();
		} catch (SQLException e) {
			return Response.ok(new DatabaseException("Internal server error")).status(500).build();
		}

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/link")
	public Response salva(ProductLinkStringDTO productLinkStringDTO) {
		System.out.println(productLinkStringDTO.toString());
		ProductService service = start();
		try {
			ProductLinkDTO productLinkDTO = service.fromDTO(productLinkStringDTO);
			service.ProductLink(productLinkDTO);
			return Response.ok().build();
		} catch (SQLException e) {
			return Response.ok(new DatabaseException("Internal server error")).status(500).build();
		}

	}

}
