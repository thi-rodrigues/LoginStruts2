package br.com.soc.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import br.com.soc.domain.LoginRequired;
import br.com.soc.domain.Usuario;
import br.com.soc.service.UsuarioService;
import br.com.soc.service.impl.UsuarioServiceImpl;
import lombok.Getter;
import lombok.Setter;

public class UsuarioLogadoAction extends ActionSupport implements ModelDriven<Usuario>, LoginRequired {

	private static final long serialVersionUID = -6659925652584240539L;

	@Getter
	@Setter
	private Usuario usuario = new Usuario();
	
	@Getter
	@Setter
	private Usuario usuarioLogado = new Usuario();
	
	@Getter
	@Setter
	private List<Usuario> usuariosList;
	
	private UsuarioService usuarioService = new UsuarioServiceImpl();
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
			.get(ServletActionContext.HTTP_REQUEST);

	@Override
	public Usuario getModel() {
		Usuario u = (Usuario) session.get("usuarioLogado");
		
		if (u != null)
			usuarioLogado = (Usuario) session.get("usuarioLogado");
		
		return usuario;
	}
	
	public String logar() throws SQLException, Exception {
		Usuario user = null;
		if (usuario.getNome() != null && !usuario.getNome().equals("")) {
			user  = usuarioService.buscarUsuario(usuario);
			if (user.getId() != null) {
				usuarioLogado = user;
				session.put("usuarioLogado", usuarioLogado);
				usuariosList = usuarioService.buscarUsuarios();
			}
		}
		return user.getId() != null ? SUCCESS : ERROR;
	}
	
	public String buscarUsuarioPorId() throws SQLException, Exception {
		if (request.getParameter("id") != null && !request.getParameter("id").equals(""))
			usuario = usuarioService.buscarUsuarioPorId(Long.valueOf(request.getParameter("id")));
		return SUCCESS;
	}
	
	public String atualizarUsuario() throws SQLException, Exception {
		if (request.getParameter("id") != null && !request.getParameter("id").equals(""))
			usuarioService.atualizarUsuario(request.getParameter("nome"), 
					Long.valueOf(request.getParameter("tempoInativividade")), Long.valueOf(request.getParameter("id")));
			
		return SUCCESS;
	}
	
	public String deletarUsuario() throws SQLException, Exception {
		if (request.getParameter("id") != null && !request.getParameter("id").equals(""))
			usuarioService.deletarUsuario(Long.valueOf(request.getParameter("id")));
		
		return SUCCESS;	
	}
	
	public String usuariosSistema() throws SQLException, Exception {
		usuariosList = usuarioService.buscarUsuarios();
		return SUCCESS;
	}
	
	public String logoutUsuario() throws SQLException, Exception {
		session.remove(usuarioLogado);
		return SUCCESS;	
	}

}
