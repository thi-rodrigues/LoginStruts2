package br.com.soc.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import br.com.soc.domain.Usuario;
import br.com.soc.service.UsuarioService;
import br.com.soc.service.impl.UsuarioServiceImpl;
import lombok.Getter;
import lombok.Setter;

public class UsuarioLogadoAction extends ActionSupport implements ModelDriven<Usuario> {

	private static final long serialVersionUID = -6659925652584240539L;

	@Getter
	@Setter
	private Usuario usuario = new Usuario();
	
	@Getter
	@Setter
	private Usuario usuarioLogado = new Usuario();
	
	@Getter
	@Setter
	private Long idUsuarioLogado;
	
	@Getter
	@Setter
	private List<Usuario> usuariosList;
	
	private UsuarioService usuarioService = new UsuarioServiceImpl();

	@Override
	public Usuario getModel() {
		return usuario;
	}
	
	public String logar() throws SQLException, Exception {
		usuarioLogado = usuarioService.buscarUsuario(usuario);
		usuariosList = usuarioService.buscarUsuarios();
		return SUCCESS;
	}
	
	public String buscarUsuarioPorId() throws SQLException, Exception {
		usuario = usuarioService.buscarUsuarioPorId(usuario.getId());
		usuarioLogado = usuarioService.buscarUsuarioPorId(idUsuarioLogado);
		return SUCCESS;
	}
	
	public String atualizarUsuario() throws SQLException, Exception {
		usuarioService.atualizarUsuario(usuario);
		return SUCCESS;
	}
	
	public String deletarUsuario() throws SQLException, Exception {
		usuarioService.deletarUsuario(usuario.getId());
		return SUCCESS;	
	}
	
	// VERIFICA SE O USUÁRIO ESTÁ COM TEMPO VÁLIDO
	public String usuarioAutenticado() throws SQLException, Exception {
		boolean usuarioAutenticado = usuarioService.usuarioAutenticado(usuario);
		return usuarioAutenticado ? SUCCESS : ERROR;
	}
	
	public String usuariosSistema() throws SQLException, Exception {
		usuariosList = usuarioService.buscarUsuarios();
		return SUCCESS;
	}
	

}
