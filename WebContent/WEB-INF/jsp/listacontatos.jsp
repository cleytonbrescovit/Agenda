<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<table border="1">
		<tr>
		  	<td>Nome</td>
		  	<td>Email</td>
		  	<td>Endereço</td>
		  	<td>Data de Nascimento</td>
		  	<td>Remover</td>
		  	<td>Altera</td>
	  	</tr>
	  	<c:forEach var="contato" items="${contatos}">
	  	<tr bgcolor="#${contato.id % 2 == 0 ? 'aaee88' : 'ffffff' }">
	  		<td>${contato.nome}</td>
	  		<td>
	  		<c:choose>
	  			<c:when test="${not empty contato.email }">
	  				<a href="mailto:${contato.email }">${contato.email }</a>
	  			</c:when>
	  			<c:otherwise>
	  				Email não encontrado.
	  			</c:otherwise>
	  		</c:choose>  			
	  		</td>
	  		<td>${contato.endereco}</td>
	  		<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
	  		<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remove</a></td>
	  		<td><a href="mvc?logica=AlteraContatoLogic&id=${contato.id}&nome=${contato.nome}&email=${contato.email}&endereco=${contato.endereco}&dataNascimento=${contato.dataNascimento.time}">Change</a></td> 
	  	</tr> 	
  		</c:forEach>
	</table>
<c:import url="rodape.jsp" />
</body>
</html>