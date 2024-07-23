<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Clinica</title>
</head>
<body>
	<div align="center">
		<h1>Listagem Geral de Médicos</h1>
		<h2>
			<a href="/${requestScope.contextPath}">Menu Principal</a>
			&nbsp;&nbsp;&nbsp;
		</h2>
	</div>

	<label for="especialidade">Especialidade</label>
	<select id="especialidade" name="especialidade">
		<c:forEach items="${especialidades}" var="especialidade">
			<option value="${especialidade.value}"
				${medico.especialidade == especialidade.value ? 'selected' : '' }>
				${especialidade.value}</option>
		</c:forEach>
	</select>

	<div align="center">
		<table border="1">
			<caption>Lista de Medicos</caption>
			<tr>
				<th>Nome</th>
				<th>Especialidade</th>
				<th>CRM</th>
				<th>E-mail</th>
			</tr>
			<c:forEach var="medico" items="${requestScope.listaFiltradaMedicos}">
				<tr>
					<td>${medico.nome}</td>
					<td>${medico.especialidade}</td>
					<td>${medico.CRM}</td>
					<td>${medico.email}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>