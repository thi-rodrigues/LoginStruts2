package br.com.soc.service;

import java.sql.SQLException;
import java.util.List;

import br.com.soc.domain.Usuario;

public interface UsuarioService {

	public void saveUsuario(Usuario usuario) throws SQLException, Exception;
	
	Usuario buscarUsuario(Usuario usuario) throws SQLException, Exception;

	public boolean usuarioAutenticado(Usuario usuario) throws SQLException, Exception;
	
	List<Usuario> buscarUsuarios() throws SQLException, Exception;

	public void atualizarUsuario(Usuario usuario) throws SQLException, Exception;

	public Usuario buscarUsuarioPorId(Long id) throws SQLException, Exception;

	void deletarUsuario(Long id) throws SQLException, Exception;
	
}
