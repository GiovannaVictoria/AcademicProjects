<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu do Sistema</title>
</head>
<body>
	<div align="center">
		<h1>Página do Usuário</h1>
	</div>
	<div align="center">
		<h2>
			<p>Olá ${sessionScope.usuarioLogado.login}</p>
		</h2>
	</div>
	<div align="center">
		<h3>
			<a
				href="${pageContext.request.contextPath}/consulta/listaConsultasMedico?login=${usuarioLogado.login}">Listagem
				de consultas agendadas</a>
		</h3>
	</div>
	<div align="center">
		<h4>
			<a href="${pageContext.request.contextPath}/logout.jsp">Sair</a>
		</h4>
	</div>
</body>
</html>