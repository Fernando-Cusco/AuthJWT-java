package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.UsuarioDAO;
import modelo.Usuario;

@Path("/auth")
public class Servicio {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response validar(Usuario usuario) {
		boolean s = UsuarioDAO.validar(usuario);
		if(s) {
			
		}
		return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
}
