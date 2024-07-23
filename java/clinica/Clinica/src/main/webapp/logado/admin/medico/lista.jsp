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
			<fmt:message key="gerenciamentoMedicos" />
		</h1>
		<h2>
			<a href="/${requestScope.contextPath}/admin/"><fmt:message
					key="menuPrincipal" /></a> &nbsp;&nbsp;&nbsp; <a
				href="/${requestScope.contextPath}/medico/cadastro"><fmt:message
					key="cadastrarMedico" /></a>
		</h2>
	</div>

	<c:if test="${requestScope.listaMedicos == null}">
		<p align="center">
			<fmt:message key="semMedicosAdmin" />
		</p>
	</c:if>

	<c:if test="${requestScope.listaMedicos != null}">
		<div align="center">
			<table border="1">
				<caption>
					<fmt:message key="listaMedicos" />
				</caption>
				<tr>
					<th><fmt:message key="especialidade" /></th>
					<th><fmt:message key="nomeMedico" /></th>
					<th><fmt:message key="crmMedico" /></th>
					<th><fmt:message key="emailMedico" /></th>
					<th><fmt:message key="acao" /></th>
				</tr>
				<c:forEach var="medico" items="${requestScope.listaMedicos}">
					<tr>
						<td><fmt:message key="especialidade.${medico.especialidade}" /></td>
						<td>${medico.nome}</td>
						<td>${medico.CRM}</td>
						<td>${medico.email}</td>
						<td><a
							href="/${requestScope.contextPath}/medico/edicao?CRM=${medico.CRM}"><fmt:message
									key="atualizar" /></a> &nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/${requestScope.contextPath}/medico/remocao?CRM=${medico.CRM}"
							onclick="return confirm('<fmt:message key="confirmarRemoverMedico" />');">
								<fmt:message key="remover" />
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
</body>
</html>