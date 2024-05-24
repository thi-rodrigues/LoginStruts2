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
	private List<Usuario> usuariosList;
	
	private UsuarioService usuarioService = new UsuarioServiceImpl();

	@Override
	public Usuario getModel() {
		System.out.println("getModelUsuario()");
		return usuario;
	}
	
	public String logar() throws SQLException, Exception {
		System.out.println("logar()");
		usuario = usuarioService.buscarUsuario(usuario);
		
		if (usuario.getNome() != null)
			usuariosSistema();
		
		return usuario.getNome() != null ? SUCCESS : ERROR;
	}
	
	public String usuariosSistema() throws SQLException, Exception {
		System.out.println("usuariosSistema()");
		usuariosList = usuarioService.buscarUsuarios();
		return SUCCESS;
	}
	
	// VERIFICA SE O USUÁRIO ESTÁ COM TEMPO VÁLIDO
	public String usuarioAutenticado() throws SQLException, Exception {
		boolean usuarioAutenticado = usuarioService.usuarioAutenticado(usuario);
		return usuarioAutenticado ? SUCCESS : ERROR;
	}

}
