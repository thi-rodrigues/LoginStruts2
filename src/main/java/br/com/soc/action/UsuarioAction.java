package br.com.soc.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import br.com.soc.domain.Usuario;
import br.com.soc.service.UsuarioService;
import br.com.soc.service.impl.UsuarioServiceImpl;
import lombok.Getter;
import lombok.Setter;

public class UsuarioAction extends ActionSupport implements ModelDriven<Usuario> {

	private static final long serialVersionUID = -6659925652584240539L;

	@Getter
	@Setter
	private Usuario usuario = new Usuario();
	
	private UsuarioService usuarioService = new UsuarioServiceImpl();

	@Override
	public Usuario getModel() {
		return usuario;
	}
	
	public String welcome() throws SQLException, Exception {
		System.out.println("Bem Vindo!");
		return SUCCESS;
	}

	public String saveUsuario() throws SQLException, Exception {
		System.out.println(usuario);
		usuarioService.saveUsuario(usuario);
		return SUCCESS;
	}

	public String buscarUsuarios() throws SQLException, Exception {
		Usuario usuarioLogado = usuarioService.buscarUsuario(usuario);
		System.out.println(usuarioLogado);
		return usuarioLogado.getNome() != null ? SUCCESS : ERROR;
	}
	
//	public String error() throws SQLException, Exception {
//		System.out.println("error");
//		return SUCCESS;
//	}


}
