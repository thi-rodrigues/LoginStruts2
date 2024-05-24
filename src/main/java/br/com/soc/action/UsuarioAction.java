package br.com.soc.action;

import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import br.com.soc.domain.Usuario;
import br.com.soc.service.UsuarioService;
import br.com.soc.service.impl.UsuarioServiceImpl;
import lombok.Getter;
import lombok.Setter;

@Result(type="redirectAction",name="usuarioLogado")
public class UsuarioAction extends ActionSupport implements ModelDriven<Usuario> {

	private static final long serialVersionUID = -6659925652584240539L;

	@Getter
	@Setter
	private Usuario usuario = new Usuario();
	
	private UsuarioService usuarioService = new UsuarioServiceImpl();

	@Override
	public Usuario getModel() {
		System.out.println("getModel()");
		return usuario;
	}
	
	public String welcome() throws SQLException, Exception {
		System.out.println("welcome()");
		return SUCCESS;
	}

	public String saveUsuario() throws SQLException, Exception {
		usuarioService.saveUsuario(usuario);
		return SUCCESS;
	}

//	public String logar() throws SQLException, Exception {
//		System.out.println("logar()");
//		usuario = usuarioService.buscarUsuario(usuario);
//		return usuario.getNome() != null ? "usuarioLogado" : ERROR;
//	}
	
}
