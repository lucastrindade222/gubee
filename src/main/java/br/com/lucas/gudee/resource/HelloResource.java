package br.com.lucas.gudee.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Sample JAX-RS resources.
 *
 */
@Path("hello")
public class HelloResource {

	
	@GET
	 
	public String getMessage() {
		
		 
		return "Holla";
	}

}
