package service;

import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import dao.UsuarioDAO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import modelo.Usuario;

@Path("/auth")
public class Servicio {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response validar(Usuario usuario) {
		boolean s = UsuarioDAO.validar(usuario);
		if(s) {
			long tiempo = System.currentTimeMillis();
			String key = "password";
			String jwt = Jwts.builder()
					.signWith(SignatureAlgorithm.HS256, key)
					.setSubject("Fernando Cusco")
					.setIssuedAt(new Date(tiempo))
					.setExpiration(new Date(tiempo+900000))
					.claim("email", "admin@admin.com")
					.compact();
		
			JsonObject json = Json.createObjectBuilder()
								.add("JWT", jwt).build();
			return Response.status(Response.Status.CREATED).entity(json).build();
		}
		return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
}
