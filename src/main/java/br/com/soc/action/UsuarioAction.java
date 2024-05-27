package br.com.soc.action;

import java.sql.SQLException;

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
		return SUCCESS;
	}

	public String saveUsuario() throws SQLException, Exception {
		if (usuario.getNome() != null && usuario.getSenha() != null && usuario.getTempoInativividade() != null)
			usuarioService.saveUsuario(usuario);
		return SUCCESS;
	}

}
