package dao;

import modelo.Usuario;

public class UsuarioDAO {
	
	public boolean validar(Usuario usuario) {
		return (usuario.getUsuario().equals("admin") && usuario.getPassword().equals("admin"));
	}

}
