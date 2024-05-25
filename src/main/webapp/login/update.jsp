<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Usu�rio Logado</title>
		<s:head />
		<style type="text/css"> @import url(style.css);
			.txDecorationNone {
				text-decoration: none;
			}
		</style>
	</head>

	<body>
		<hr>
			<h1>UPDATE <s:text name="%{nome}" /></h1>
		<hr>
			<div>
				<s:form action="updateUser" method="POST">
					<s:push value="usuario">
						<input type="hidden" name="id" value='<s:property value="id"/>'>
						<b>Login: </b>
						<input type="text" name="nome" value='<s:property value="nome"/>'>
						<b>Tempo: </b>
						<input type="text" name="tempoInativividade" value='<s:property value="tempoInativividade"/>'>
						<button type="submit">Update</button>
					</s:push>
				</s:form>
			</div>
			
		<i class="userLogado">Usu�rio logado: </i><s:text name="%{nome}" />
	</body>
</html>