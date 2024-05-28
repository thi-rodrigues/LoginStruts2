package br.com.soc.action;

import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
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
	
	@Getter
	@Setter
	private Usuario usuarioLogado = new Usuario();
	
	private UsuarioService usuarioService = new UsuarioServiceImpl();
	
	Map<String, Object> session = ActionContext.getContext().getSession();

	@Override
	public Usuario getModel() {
		usuarioLogado = (Usuario) session.get("usuarioLogado");
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
