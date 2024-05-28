<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Usuário Logado</title>
		<s:head />
		<style type="text/css"> @import url(style.css);
			.txDecorationNone {
				text-decoration: none;
			}
		</style>
	</head>

	<body>
		<hr>
			<h1>Bem Vindo Sr. <s:text name="%{usuarioLogado.nome}" /></h1>
		<hr>
			<h4>Usuários do Sistema</h4>
			
			<s:if test="usuariosList.size() > 0">
				<div>
					<table class="userTable" cellpadding="5px">
						<thead>
							<tr class="even">
	                            <th>Usuário</th>
	                            <th>Tempo</th>
	                            <th>Ação</th>
	                        </tr>
						</thead>
						<s:iterator value="usuariosList">
							<tr>
								<td><s:property value="nome"/></td>
								<td><s:property value="tempoInativividade"/> minutos</td>
								<td>
									<a href="buscarUsuario.action?id=<s:property value="id"/>"
										class="txDecorationNone">
										<button> Update	</button>
									</a> 
									<a href="deleteUser.action?id=<s:property value="id"/>"
										class="txDecorationNone">
										<button> Delete </button>
									</a>
								</td>
							</tr>
						</s:iterator>
					</table>
				</div>
			</s:if>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<hr>
		<i class="userLogado">Usuário logado: </i><s:text name="%{usuarioLogado.nome}" />
	</body>
</html>