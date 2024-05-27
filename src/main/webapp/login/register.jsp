<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
	<html>
        <head>
        <!-- 
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
         -->
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Cadastrar Login</title>
            <sb:head />
        </head>

        <body>
            <hr>
            <s:form action="saveUsuario" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal">
            	<h4>Cadastrar Usuário</h4>
                <s:push value="usuario">
                    <s:textfield name="nome" label="Login" class="col-md-3"/>
                    <s:password name="senha" label="Senha" class="col-md-3"/>
                    <s:textfield type="number" name="tempoInativividade" label="Tempo de Inatividade" min="1" max="90"/>
                    <s:submit value="Gravar"/>
                </s:push>
            </s:form>
            <br>
            <hr>
            <br>
            <s:form action="logarUsuario">
            	<h4>Login</h4>
                <s:push value="usuario">
                    <s:textfield name="nome" label="Login" />
                    <s:password name="senha" label="Senha" />
                    <s:submit value="Login"/>
                </s:push>
            </s:form>
        </body>
	</html>