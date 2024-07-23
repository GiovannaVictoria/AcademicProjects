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
<title><fmt:message key="paginaNaoEncontrada" /></title>
<link href="${pageContext.request.contextPath}/layout.css"
	rel="stylesheet" type="text/css" />
</head>
<body>

	<div align="center">
		<h2>
			<fmt:message key="paginaNaoExiste" />
		</h2>
		<h3>
			<fmt:message key="sugestao404" />
		</h3>
		<a href="<c:url value='/index.jsp' />"><fmt:message
				key="paginaPrincipal" /></a>
	</div>

</body>
</html>