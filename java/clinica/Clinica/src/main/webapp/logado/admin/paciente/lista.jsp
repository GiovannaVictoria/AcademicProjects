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
			<fmt:message key="gerenciamentoPacientes" />
		</h1>
		<h2>
			<a href="/${requestScope.contextPath}/admin/"><fmt:message
					key="menuPrincipal" /></a> &nbsp;&nbsp;&nbsp; <a
				href="/${requestScope.contextPath}/paciente/cadastro"><fmt:message
					key="cadastrarPaciente" /></a>
		</h2>
	</div>
	
	<c:if test="${requestScope.listaPacientes == null}">
		<p align="center">
			<fmt:message key="semPacientesAdmin" />
		</p>
	</c:if>

	<c:if test="${requestScope.listaPacientes != null}">
		<div align="center">
			<table border="1">
				<caption>
					<fmt:message key="listaPacientes" />
				</caption>
				<tr>
					<th><fmt:message key="nomePaciente" /></th>
					<th><fmt:message key="cpfPaciente" /></th>
					<th><fmt:message key="dataNascimento" /></th>
					<th><fmt:message key="genero" /></th>
					<th><fmt:message key="emailPaciente" /></th>
					<th><fmt:message key="telefone" /></th>
					<th><fmt:message key="acao" /></th>
				</tr>
				<c:forEach var="paciente" items="${requestScope.listaPacientes}">
					<tr>
						<td>${paciente.nome}</td>
						<td>${paciente.CPF}</td>
						<td>${paciente.dataNascimento}</td>
						<td><fmt:message key="genero.${paciente.genero}" /></td>
						<td>${paciente.email}</td>
						<td>${paciente.telefone}</td>
						<td><a
							href="/${requestScope.contextPath}/paciente/edicao?CPF=${paciente.CPF}"><fmt:message
									key="atualizar" /></a> &nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/${requestScope.contextPath}/paciente/remocao?CPF=${paciente.CPF}"
							onclick="return confirm('<fmt:message key="confirmarRemoverPaciente" />');">
								<fmt:message key="remover" />
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
</body>
</html>