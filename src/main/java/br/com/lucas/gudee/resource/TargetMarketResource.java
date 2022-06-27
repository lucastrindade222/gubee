package br.com.lucas.gudee.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.lucas.gudee.model.TargetMarket;
import br.com.lucas.gudee.resource.exception.DatabaseException;
import br.com.lucas.gudee.service.TargetMarketService;

@Path("targetMarket")
public class TargetMarketResource {

	public  TargetMarketService start() {
		return new TargetMarketService();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response findById(@PathParam("id") Integer id) {
		TargetMarketService service = start();
		try {
			TargetMarket targetMarket = service.findById(id);
			return Response.ok(targetMarket).build();
		} catch (SQLException e) {

			return Response.ok(new DatabaseException("Internal server error")).status(500).build();
		}

	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		try {
			List<TargetMarket> list;
			TargetMarketService service = start();
			list = service.findAll();

			return Response.ok(list).build();
		} catch (SQLException e) {
			return Response.ok(new DatabaseException("Internal server error")).status(500).build();
		}

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/salva/target")
	public Response salva(TargetMarket targetMarket) {
		TargetMarketService service = start();
		try {
			service.save(targetMarket);
			return Response.ok().build();
		} catch (SQLException e) {
			return Response.ok(new DatabaseException("Internal server error")).status(500).build();
		}

	}
	
}
