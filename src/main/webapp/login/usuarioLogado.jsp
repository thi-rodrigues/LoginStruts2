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
			<h1>Bem Vindo Sr. <s:text name="%{nome}" /></h1>
		<hr>
			<h4>Usu�rios do Sistema</h4>
			
			<s:if test="usuariosList.size() > 0">
				<div>
					<table class="userTable" cellpadding="5px">
						<thead>
							<tr class="even">
	                            <th>Usu�rio</th>
	                            <th>Tempo</th>
	                            <th>A��o</th>
	                        </tr>
						</thead>
						<s:iterator value="usuariosList">
							<tr>
								<td><s:property value="nome"/></td>
								<td><s:property value="tempoInativividade"/></td>
								<td>
									<a href="updatedetails.action?submitType=updatedata&email=<s:property value="email"/>" class="txDecorationNone">
										<button> Update	</button>
									</a> 
									<a href="deleterecord.action?uemail=<s:property value="email"/>" class="txDecorationNone">
										<button> Delete </button>
									</a>
								</td>
							</tr>
						</s:iterator>
					</table>
				</div>
			</s:if>
			
			<hr>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
				<a href="autenticacao.action?nome=<s:property value="nome"/>" class="txDecorationNone button-acao">
					<button> Validar </button>
				</a> 
			
		<i class="userLogado">Usu�rio logado: </i><s:text name="%{nome}" />
	</body>
</html>