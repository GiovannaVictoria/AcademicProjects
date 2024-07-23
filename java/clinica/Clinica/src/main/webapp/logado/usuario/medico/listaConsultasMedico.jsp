<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setBundle basename="messages" />
<fmt:setLocale value="${sessionScope.userLocale}" />

<html>
<head>
<title><fmt:message key="clinicaMedica" /></title>
<link href="${pageContext.request.contextPath}/layout.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<c:if test="${erros.existeErros}">
		<div id="erro" align="center">
			<c:forEach var="erro" items="${erros.erros}">
				<p>${erro}</p>
			</c:forEach>
		</div>
	</c:if>
	<c:if test="${sucessos.existeSucessos}">
		<div id="sucesso" align="center">
			<c:forEach var="sucesso" items="${sucessos.sucessos}">
				<p>${sucesso}</p>
			</c:forEach>
		</div>
	</c:if>
	<div align="center">
		<h1>
			<fmt:message key="listagemConsultas" />
		</h1>
		<h2>
			<a href="/${requestScope.contextPath}/usuario/"><fmt:message
					key="menuPrincipal" /></a> &nbsp;&nbsp;&nbsp;
		</h2>
	</div>

	<c:if test="${requestScope.listaConsultas == null}">
		<p align="center">
			<fmt:message key="semConsultas" />
		</p>
	</c:if>

	<c:if test="${requestScope.listaConsultas != null}">
		<div align="center">
			<table border="1">
				<caption>
					<fmt:message key="listagemConsultas" />
				</caption>
				<tr>
					<th><fmt:message key="horarioConsulta" /></th>
					<th><fmt:message key="nomePaciente" /></th>
					<th><fmt:message key="cpfPaciente" /></th>
				</tr>
				<c:forEach var="consulta" items="${requestScope.listaConsultas}">
					<tr>
						<td>${consulta.horario}</td>
						<td>${consulta.nomePaciente}</td>
						<td>${consulta.CPF}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
</body>
</html>