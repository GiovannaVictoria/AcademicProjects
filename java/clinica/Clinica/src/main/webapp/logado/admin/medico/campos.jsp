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
			<c:when test="${medico != null}">
                                  <fmt:message key="atualizacao" />
                              </c:when>
			<c:otherwise>
                                  <fmt:message key="cadastro" />
                              </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${medico != null}">
		<input type="hidden" name="CRM" value="${medico.CRM}" />
		<input type="hidden" name="login" value="${medico.login}" />
	</c:if>
	<tr>
		<td><label for="nome"><fmt:message key="nomeMedico" /></label></td>
		<td><input type="text" id="nome" name="nome" required size="45"
			value="${medico.nome}" /></td>
	</tr>
	<tr>
		<td><label for="CRM"><fmt:message key="crmMedico" /></label></td>
		<td><c:if test="${medico != null}">
				<span>${medico.CRM}</span>
			</c:if> <c:if test="${medico == null}">
				<input type="text" id="CRM" name="CRM" size="45" required
					value="${medico.CRM}" />
			</c:if></td>
	</tr>
	<tr>
		<td><label for="especialidade"><fmt:message key="especialidade" /></label></td>
		<td><select id="especialidade" name="especialidade">
				<c:forEach items="${especialidades}" var="especialidade">
					<option value="${especialidade}">
						<fmt:message key="especialidade.${especialidade}" /></option>
				</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td><label for="email"><fmt:message key="emailMedico" /></label></td>
		<td><input type="text" id="email" name="email" size="45" required
			value="${medico.email}" /></td>
	</tr>
	<tr>
		<td><label for="login"><fmt:message key="login" /></label></td>
		<td><c:if test="${medico != null}">
				<span>${medico.login}</span>
			</c:if> <c:if test="${medico == null}">
				<input type="text" id="login" name="login" size="45" required
					value="${medico.login}" />
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
		<td colspan="2" align="center"><input type="submit" value="<fmt:message key="salvar" />" /></td>
	</tr>
</table>