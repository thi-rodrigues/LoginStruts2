package br.com.soc.service;

import java.sql.SQLException;
import java.util.List;

import br.com.soc.domain.Usuario;

public interface UsuarioService {

	public void saveUsuario(Usuario usuario) throws SQLException, Exception;
	
	public List<Usuario> listUsuario() throws SQLException, Exception;
	
	public List<Usuario> buscarUsuarios(Usuario usuario) throws SQLException, Exception;
	
	public Usuario buscarUsuarioPorId(Long usuarioId) throws SQLException, Exception;
	
	public void deleteUsuario(Long usuarioId) throws SQLException, Exception;;
	
	public void updateUsuario(Usuario funcionario) throws SQLException, Exception;
}
