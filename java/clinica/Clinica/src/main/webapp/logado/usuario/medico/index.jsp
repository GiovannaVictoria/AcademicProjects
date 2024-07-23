<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
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
			<fmt:message key="paginaUsuario" />
		</h1>
	</div>
	<div align="center">
		<h2>
			<p>
				<fmt:message key="ola" />
				${sessionScope.usuarioLogado.login}
			</p>
		</h2>
	</div>
	<div align="center">
		<h3>
			<a
				href="${pageContext.request.contextPath}/consulta/listaConsultasMedico?login=${usuarioLogado.login}"><fmt:message
					key="listagemConsultas" /></a>
		</h3>
	</div>
	<div align="center">
		<h4>
			<a href="${pageContext.request.contextPath}/logout.jsp"><fmt:message
					key="sair" /></a>
		</h4>
	</div>
</body>
</html>