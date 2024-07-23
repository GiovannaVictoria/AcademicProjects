<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">
	<caption>
		<c:choose>
			<c:when test="${medico != null}">
                                  Edição
                              </c:when>
			<c:otherwise>
                                  Cadastro
                              </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${medico != null}">
		<input type="hidden" name="CRM" value="${medico.CRM}" />
		<input type="hidden" name="login" value="${medico.login}" />
	</c:if>
	<tr>
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome" required size="45"
			value="${medico.nome}" /></td>
	</tr>
	<tr>
		<td><label for="CRM">CRM</label></td>
		<td><c:if test="${medico != null}">
				<span>${medico.CRM}</span>
			</c:if> <c:if test="${medico == null}">
				<input type="text" id="CRM" name="CRM" size="45" required
					value="${medico.CRM}" />
			</c:if></td>
	</tr>
	<tr>
		<td><label for="especialidade">Especialidade</label></td>
		<td><select id="especialidade" name="especialidade">
				<c:forEach items="${especialidades}" var="especialidade">
					<option value="${especialidade.value}"
						${medico.especialidade==especialidade.value ? 'selected' : '' }>
						${especialidade.value}</option>
				</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td><label for="email">E-mail</label></td>
		<td><input type="text" id="email" name="email" size="45" required
			value="${medico.email}" /></td>
	</tr>
	<tr>
		<td><label for="login">Login</label></td>
		<td><c:if test="${medico != null}">
				<span>${medico.login}</span>
			</c:if> <c:if test="${medico == null}">
				<input type="text" id="login" name="login" size="45" required
					value="${medico.login}" />
			</c:if></td>
	</tr>
	<tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="password" id="senha" name="senha" size="45"
			required value="${usuario != null ? usuario.senha : ''}" /></td>
	</tr>
	<tr>
		<td><label for="papel">Papel</label></td>
		<td><select id="papel" name="papel">
				<c:forEach items="${papeis}" var="papel">
					<option value="${papel.value}"
						${usuario.papel==papel.value ? 'selected' : '' }>
						${papel.value}</option>
				</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>