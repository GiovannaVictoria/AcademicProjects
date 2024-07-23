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
</head>

<body>
	
	<div align="center">
		<h1><fmt:message key="agendamentoConsulta" /></h1>
		<h2>
			<a href="${pageContext.request.contextPath}/usuario/"><fmt:message key="menuPrincipal" /></a> &nbsp;&nbsp;&nbsp;
		</h2>
	</div>
	<div align="center">
		<form action="insercao" method="post">
			<%@include file="camposConsulta.jsp"%>
		</form>
	</div>
	<c:if test="${!empty requestScope.mensagens}">
		<ul class="erro">
			<c:forEach items="${requestScope.mensagens}" var="mensagem">
				<li>${mensagem}</li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>