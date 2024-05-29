<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
	<html>
        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
            <link href="../style.css" rel="stylesheet" media="screen">
            <title>Cadastrar Login</title>
            <sb:head />
        </head>

        <body>
        	<script src="https://code.jquery.com/jquery.js"></script>
    		<script src="js/bootstrap.min.js"></script>
            
            <div class="container">
            	<div class="create-login">
            		<s:form action="saveUsuario" enctype="multipart/form-data" theme="bootstrap" class="form-horizontal">
		            	<h1>Cadastrar Usuário</h1>
		                <s:push value="usuario">
		                    <s:textfield name="nome" label="Login" class="col-md-3" required="true"/>
		                    <s:password name="senha" label="Senha" class="col-md-3" required="true"/>
		                    <s:textfield type="number" name="tempoInativividade" label="Tempo de Inatividade" min="1" max="90" required="true"/>
		                    <s:submit value="Gravar" class="btn btn-primary" />
		                </s:push>
		            </s:form>
		            <div style="padding-top: 10px">
		                <s:a action="avaliacao.action" class="txDecorationNone">
		                    <button class="txDecorationNone">Voltar</button>
		                </s:a>
		            </div>
            	</div>
            </div>
        </body>
	</html>