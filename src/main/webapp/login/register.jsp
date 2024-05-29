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

        <body style="padding-top: 40px;
    padding-bottom: 40px;
    background-color: #f5f5f5;">
        	<script src="https://code.jquery.com/jquery.js"></script>
    		<script src="js/bootstrap.min.js"></script>
            
            <div class="container">
            	<div class="login" style="max-width: 300px;margin: 0 auto 20px;">
					<s:form action="logarUsuario" class="form-signin form-horizontal" enctype="multipart/form-data" theme="bootstrap" >
		            	<h1 style="text-align: center;">Login</h1>
		                <s:push value="usuario">
				                    <s:textfield name="nome" placeholder="Email" class="input-block-level" required="true" />
			                    	<s:password name="senha" placeholder="Password" class="input-block-level" required="true"/>
		                <div style="text-align: center;">
		                    <s:submit value="Entrar" class="btn-primary-login"/>
		                </div>
		                </s:push>
	            	</s:form>
	            	<div style="padding: 10px 0;text-align: center;">
	                 	<a href="cadastrar.action" class="txDecorationNone">
							<button> Cadastre-se </button>
						</a>
	            	</div>
            	</div>
            </div>
        </body>
	</html>