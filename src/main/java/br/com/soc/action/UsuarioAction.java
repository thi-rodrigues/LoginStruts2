package br.com.soc.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

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
	private List<Usuario> usuarioList = new ArrayList<>();
	private UsuarioService usuarioService = new UsuarioServiceImpl();

	@Override
	public Usuario getModel() {
		return usuario;
	}

	public String saveUsuario() throws SQLException, Exception {
		System.out.println(usuario);
		usuarioService.saveUsuario(usuario);
		return SUCCESS;
	}

	public String list() throws SQLException, Exception {
		usuarioList = usuarioService.listUsuario();
		return SUCCESS;
	}

	public String delete() throws SQLException, Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		usuarioService.deleteUsuario(Long.parseLong(request.getParameter("nome")));
		return SUCCESS;
	}

	public String edit() throws SQLException, Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		usuario = usuarioService.buscarUsuarioPorId(Long.parseLong(request.getParameter("nome")));
		return SUCCESS;
	}

	public String buscarUsuarios() throws SQLException, Exception {
		usuarioList = usuarioService.buscarUsuarios(usuario);
		return SUCCESS;
	}

}
