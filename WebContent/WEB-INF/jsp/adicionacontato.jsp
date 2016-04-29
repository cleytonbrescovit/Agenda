<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="me" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="cabecalho.jsp" />
	<form action="mvc?logica=AdicionaAlteraContatoLogic" method="post">
		Nome:
		<input type="text" name="nome" />
		<br />
		E-mail:
		<input type="email" name="email" />
		<br />
		Endereço:
		<input type="text" name="endereco" />
		<br />
		Data Nascimento:
		<me:campoData id="dataNascimento" />
		<br />
		<input type="submit" value="Gravar" />
	</form>
<c:import url="rodape.jsp" />
</body>
</html>