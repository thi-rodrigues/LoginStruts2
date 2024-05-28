<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Update</title>
		<s:head />
		<style type="text/css"> @import url(style.css);
			.txDecorationNone {
				text-decoration: none;
			}
		</style>
	</head>

	<body>
		<hr>
			<h1>UPDATE</h1>
		<hr>
			<div>
				<s:form action="updateUser" method="POST">
					<s:push value="usuario">
						<input type="hidden" name="id" value='<s:property value="id"/>'>
						<b>Login: </b>
						<input type="text" name="nome" value='<s:property value="nome"/>'><br>
						<b>Tempo: </b>
						<input type="text" name="tempoInativividade" value='<s:property value="tempoInativividade"/>'>
						<s:hidden name="idUsuarioLogado" />
						<a href="updateUser.action?idUsuarioLogado=<s:property value="usuarioLogado.id" />"
							class="txDecorationNone">
							<button> Update </button>
						</a> 
					</s:push>
				</s:form>
			</div>
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