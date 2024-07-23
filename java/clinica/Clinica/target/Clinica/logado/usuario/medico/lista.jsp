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
		<h1>Listagem de Consultas</h1>
		<h2>
			<a href="/${requestScope.contextPath}/usuario/">Menu Principal</a>
			&nbsp;&nbsp;&nbsp;
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Consultas</caption>
			<tr>
				<th>CPF do Paciente</th>
				<th>CRM do Médico</th>
				<th>Horário da Consulta</th>
			</tr>
			<c:forEach var="consulta" items="${requestScope.listaConsultas}">
				<tr>
					<td>${consulta.CPF}</td>
					<td>${consulta.CRM}</td>
					<td>${consulta.horario}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>