package br.com.soc.service;

import java.sql.SQLException;

import br.com.soc.domain.Usuario;

public interface UsuarioService {

	public void saveUsuario(Usuario usuario) throws SQLException, Exception;
	
	Usuario buscarUsuario(Usuario usuario) throws SQLException, Exception;
	
}
