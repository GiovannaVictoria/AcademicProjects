<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setBundle basename="messages" />
<fmt:setLocale value="${sessionScope.userLocale}" />

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${paciente != null}">
				<fmt:message key="atualizacao" />
			</c:when>
			<c:otherwise>
				<fmt:message key="remocao" />
			</c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${paciente != null}">
		<input type="hidden" name="CPF" value="${paciente.CPF}" />
		<input type="hidden" name="login" value="${paciente.login}" />
	</c:if>
	<tr>
		<td><label for="nome"><fmt:message key="nomePaciente" /></label></td>
		<td><input type="text" id="nome" name="nome" required size="45"
			value="${paciente.nome}" /></td>
	</tr>
	<tr>
		<td><label for="CPF"><fmt:message key="cpfPaciente" /></label></td>
		<td><c:if test="${paciente != null}">
				<span>${paciente.CPF}</span>
			</c:if> <c:if test="${paciente == null}">
				<input type="text" id="CPF" name="CPF" size="45" required
					value="${paciente.CPF}" />
			</c:if></td>
	</tr>
	<tr>
		<td><label for="genero"><fmt:message key="genero" /></label></td>
		<td><select id="genero" name="genero">
				<c:forEach items="${generos}" var="genero">
					<option value="${genero}"><fmt:message key="genero.${genero}" /></option>
				</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td><label for="telefone"><fmt:message key="telefone" /></label></td>
		<td><input type="text" id="telefone" name="telefone" size="45"
			required value="${paciente.telefone}" /></td>
	</tr>
	<tr>
		<td><label for="dataNascimento"><fmt:message
					key="dataNascimento" /></label></td>
		<td><input type="date" id="dataNascimento" name="dataNascimento"
			size="45" required value="${paciente.dataNascimento}" /></td>
	</tr>
	<tr>
		<td><label for="email"><fmt:message key="emailPaciente" /></label></td>
		<td><input type="text" id="email" name="email" size="45" required
			value="${paciente.email}" /></td>
	</tr>
	<tr>
		<td><label for="login"><fmt:message key="login" /></label></td>
		<td><c:if test="${paciente != null}">
				<span>${paciente.login}</span>
			</c:if> <c:if test="${paciente == null}">
				<input type="text" id="login" name="login" size="45" required
					value="${paciente.login}" />
			</c:if></td>
	</tr>
	<tr>
		<td><label for="senha"><fmt:message key="senha" /></label></td>
		<td><input type="password" id="senha" name="senha" size="45"
			required value="${usuario != null ? usuario.senha : ''}" /></td>
	</tr>
	<tr>
		<td><label for="papel"><fmt:message key="papel" /></label></td>
		<td><select id="papel" name="papel">
				<c:forEach items="${papeis}" var="papel">
					<option value="${papel.value}"
						${usuario.papel==papel.value ? 'selected' : '' }>
						${papel.value}</option>
				</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="<fmt:message key="salvar" />" /></td>
	</tr>
</table>