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
		<h1>Gerenciamento de Pacientes</h1>
		<h2>
			<a href="/${requestScope.contextPath}">Menu Principal</a>
			&nbsp;&nbsp;&nbsp; <a
				href="/${requestScope.contextPath}/pacientes/cadastro">Adicione Novo Paciente</a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Paciente</caption>
			<tr>
				<th>Nome</th>
				<th>CPF</th>
				<th>E-mail</th>
				<th>Genero</th>
				<th>Telefone</th>
				<th>Data de nascimento</th>
			</tr>
			<c:forEach var="paciente" items="${requestScope.listaPacientes}">
				<tr>
					<td>${paciente.nome}</td>
					<td>${paciente.CPF}</td>
					<td>${paciente.email}</td>
					<td>${paciente.genero}</td>
					<td>${paciente.telefone}</td>
					<td>${paciente.dataNascimento}</td>
					<td><a
						href="/${requestScope.contextPath}/pacientes/edicao?CPF=${paciente.CPF}">Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/${requestScope.contextPath}/pacientes/remocao?CPF=${paciente.CPF}"
						onclick="return confirm('Tem certeza de que deseja excluir este paciente?');">
							Remoção </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>