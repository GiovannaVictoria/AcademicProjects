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
		<h1>Gerenciamento de Medicos</h1>
		<h2>
			<a href="/${requestScope.contextPath}">Menu Principal</a>
			&nbsp;&nbsp;&nbsp; <a
				href="/${requestScope.contextPath}/medicos/cadastro">Adicione Novo Medico</a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Medicos</caption>
			<tr>
				<th>Nome</th>
				<th>Especialidade</th>
				<th>CRM</th>
				<th>E-mail</th>
			</tr>
			<c:forEach var="medico" items="${requestScope.listaMedicos}">
				<tr>
					<td>${medico.nome}</td>
					<td>${medico.especialidade}</td>
					<td>${medico.CRM}</td>
					<td>${medico.email}</td>
					<td><a
						href="/${requestScope.contextPath}/medicos/edicao?CRM=${medico.CRM}">Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/${requestScope.contextPath}/medicos/remocao?CRM=${medico.CRM}"
						onclick="return confirm('Tem certeza de que deseja excluir este medico?');">
							Remoção </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>