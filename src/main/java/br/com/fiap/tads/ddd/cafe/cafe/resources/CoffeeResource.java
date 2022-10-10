package br.com.fiap.tads.ddd.cafe.cafe.resources;

import java.util.List;

import br.com.fiap.tads.ddd.cafe.cafe.model.Coffee;
import br.com.fiap.tads.ddd.cafe.cafe.model.repository.CoffeeRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/coffee")
public class CoffeeResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		List<Coffee> lista = CoffeeRepository.findAll();
		ResponseBuilder response = Response.ok(lista);
		response.entity(lista);
		return response.build(); // Padrão Builder
	}
}
