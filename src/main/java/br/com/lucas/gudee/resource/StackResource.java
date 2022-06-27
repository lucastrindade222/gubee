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

import br.com.lucas.gudee.model.Stack;
import br.com.lucas.gudee.resource.exception.DatabaseException;
import br.com.lucas.gudee.service.StackService;

@Path("stack")
public class StackResource {

	public StackService start() {
		return new StackService();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response findById(@PathParam("id") Integer id) {
		StackService service = start();
		try {
			Stack stack = service.findById(id);
			return Response.ok(stack).build();
		} catch (SQLException e) {

			return Response.ok(new DatabaseException("Internal server error")).status(500).build();
		}

	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		try {
			List<Stack> list;
			StackService service = start();
			list = service.findAll();

			return Response.ok(list).build();
		} catch (SQLException e) {
			return Response.ok(new DatabaseException("Internal server error")).status(500).build();
		}

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/salva/stack")
	public Response salva(Stack stack) {
		StackService service = start();
		try {
			service.save(stack);
			return Response.ok().build();
		} catch (SQLException e) {
			return Response.ok(new DatabaseException("Internal server error")).status(500).build();
		}

	}

}
