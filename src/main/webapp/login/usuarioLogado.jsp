<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Usuário Logado</title>
		<s:head />
		<style type="text/css">
		@import url(style.css);
		</style>
	</head>

	<body>
		<hr>
		<s:form action="usuarioLogado">
			<h4>Usuários do Sistema</h4>
			<s:push value="usuario">
				<h1>Bem Vindo Sr.</h1><b name="nome" ></b>
				<s:textfield name="nome" label="Login" />
			</s:push>
		</s:form>
	</body>
</html>