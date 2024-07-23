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
<title><fmt:message key="autorizacaoUsuario" /></title>
<link href="${pageContext.request.contextPath}/layout.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div align="center">
		<h1>
			<fmt:message key="autorizacaoUsuario" />
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
</body>
</html>