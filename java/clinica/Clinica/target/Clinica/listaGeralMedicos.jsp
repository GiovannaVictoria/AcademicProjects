<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setBundle basename="messages" />
<fmt:setLocale value="${sessionScope.userLocale}" />

<!DOCTYPE html>
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
			<fmt:message key="listagemGeralMedicos" />
		</h1>
		<h2>
			<a href="/${requestScope.contextPath}"><fmt:message
					key="menuPrincipal" /></a> &nbsp;&nbsp;&nbsp;
		</h2>
	</div>

	<c:if test="${requestScope.listaGeralMedicos == null}">
		<p align="center">
			<fmt:message key="semMedicosGeral" />
		</p>
	</c:if>

	<c:if test="${requestScope.listaGeralMedicos != null}">
		<div align="center">
			<table border="1">
				<caption>
					<fmt:message key="listagemGeralMedicos" />
				</caption>
				<tr>
					<th><fmt:message key="especialidade" /></th>
					<th><fmt:message key="nomeMedico" /></th>
					<th><fmt:message key="crmMedico" /></th>
					<th><fmt:message key="emailMedico" /></th>
				</tr>
				<c:forEach var="medico" items="${requestScope.listaGeralMedicos}">
					<tr>
						<td><fmt:message key="especialidade.${medico.especialidade}" /></td>
						<td>${medico.nome}</td>
						<td>${medico.CRM}</td>
						<td>${medico.email}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
</body>
</html>