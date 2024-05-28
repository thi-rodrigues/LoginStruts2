package br.com.soc.domain;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import br.com.soc.action.UsuarioLogadoAction;
import br.com.soc.service.UsuarioService;
import br.com.soc.service.impl.UsuarioServiceImpl;

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -406679312046914501L;
	
	private UsuarioService usuarioService = new UsuarioServiceImpl();

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();

		// sb: feel free to change this to some other type of an object which
		// represents that the user is logged in. for this example, I am using
		// an integer which would probably represent a primary key that I would
		// look the user up by with Hibernate or some other mechanism.
		
		Usuario usuarioLogado = (Usuario) session.get("usuarioLogado");
		
		// VERIFICA SE O USUÁRIO ESTÁ COM TEMPO VÁLIDO
		Boolean usuarioAutenticado = false;
		if (usuarioLogado != null)
			usuarioAutenticado = usuarioService.usuarioAutenticado(usuarioLogado);

		// sb: if the user is already signed-in, then let the request through.
		if (usuarioAutenticado) {
			return invocation.invoke();
		}

		Object action = invocation.getAction();

		// sb: if the action doesn't require sign-in, then let it through.
		if (!(action instanceof LoginRequired)) {
			return invocation.invoke();
		}

		// sb: if this request does require login and the current action is
		// not the login action, then redirect the user
		if (!(action instanceof UsuarioLogadoAction)) {
			return "loginRedirect";
		}

		// sb: they either requested the login page or are submitting their
		// login now, let it through
//		return invocation.invoke();
		if (!usuarioAutenticado) {
			return "loginRedirect";
		}
		return null;
	}

}
