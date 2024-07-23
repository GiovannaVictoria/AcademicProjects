<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setBundle basename="messages" />
<fmt:setLocale value="${sessionScope.userLocale}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="clinicaMedica" /></title>
<link href="${pageContext.request.contextPath}/layout.css"
	rel="stylesheet" type="text/css" />
</head>
<body>

	<div align="center">
		<h1>
			<fmt:message key="clinicaMedica" />
		</h1>
	</div>

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
		<h2>
			<fmt:message key="autenticacaoUsuario" />
		</h2>
		<form method="post" action="index.jsp">
			<table>
				<tr>
					<th><fmt:message key="login" />:</th>
					<td><input type="text" name="login" value="${param.login}" /></td>
				</tr>
				<tr>
					<th><fmt:message key="senha" />:</th>
					<td><input type="password" name="senha" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" name="bOK"
						value="<fmt:message key="entrar" />" /></td>
				</tr>
			</table>
		</form>
	</div>

	<div align="center">
		<h2>
			<a href="${pageContext.request.contextPath}/listaGeralMedicos"><fmt:message
					key="listagemGeralMedicos" /></a>
		</h2>
	</div>

	<div align="center">
		<h2>
			<fmt:message key="listagemEspecialidadeMedicos" />
		</h2>

		<form method="post" action="listaEspecialidadeMedicos">
			<label for="especialidade"><fmt:message
					key="selecionarEspecialidade" />:</label> <select id="especialidade"
				name="especialidade">
				<c:forEach items="${especialidades}" var="especialidade">
					<option value="${especialidade}">
						<fmt:message key="especialidade.${especialidade}" />
					</option>
				</c:forEach>
			</select> <input type="submit" value="<fmt:message key="filtrar" />">
		</form>

	</div>

</body>
</html>