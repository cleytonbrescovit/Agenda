<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="cabecalho.jsp" />
<%@ page import="java.util.*, Dao.*, Model.*, java.text.SimpleDateFormat" %>

<table border="1">
	
	<jsp:useBean id="dao" class="Dao.ContatoDao" />
	<tr>
	  	<td>Nome</td>
	  	<td>Email</td>
	  	<td>Endereço</td>
	  	<td>Data de Nascimento</td>
  	</tr>
  	<c:forEach var="contato" items="${dao.lista}">
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
  	</tr> 	
  	</c:forEach>
  	  	
</table>
<c:import url="rodape.jsp" />
</body>
</html>