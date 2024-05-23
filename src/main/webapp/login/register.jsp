<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@taglib uri="/struts-tags" prefix="s" %>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Cadastrar Login</title>
            <s:head />
            <style type="text/css">
                @import url(style.css);
            </style>
        </head>

        <body>
            <br>
            <hr>
            <br>
            <s:form action="saveUsuario">
            	<h4>Novo Login</h4>
                <s:push value="usuario">
                    <s:textfield name="nome" label="Login" />
                    <s:password name="senha" label="Senha" />
                    <s:textfield name="tempoativividade" label="Tempo de Inatividade" size="1"  maxLength="2"/>
                    <s:submit value="Gravar"/>
                </s:push>
            </s:form>
            
        </body>

        </html>