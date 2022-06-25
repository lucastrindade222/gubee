package jp.coppermine.ping;

import static jp.coppermine.connection.Connection.now;
import static jp.coppermine.connection.ConnectionJDBC.close;

import java.sql.Connection;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Sample JAX-RS resources.
 *
 */
@Path("hello")
@RequestScoped
public class HelloResource {

	@GET
	public String getMessage() {
		Connection Connection = now().connection();
		close(Connection);
		 
		return "<h1>Teste de conexão com o banco de dados</h1>";
	}

}
