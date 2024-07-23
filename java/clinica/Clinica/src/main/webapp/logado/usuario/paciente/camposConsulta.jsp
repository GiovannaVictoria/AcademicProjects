<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setBundle basename="messages" />
<fmt:setLocale value="${sessionScope.userLocale}" />

<table border="1">
	<tr>
		<td><label for="nome"><fmt:message key="nomePaciente" /></label></td>
		<td><span>${paciente.nome}</span></td>
	</tr>
	<tr>
		<td><label for="CPF"><fmt:message key="cpfPaciente" /></label></td>
		<td><span>${paciente.CPF}</span></td>
	</tr>
	<tr>
		<td><label for="genero"><fmt:message key="genero" /></label></td>
		<td><span><fmt:message key="genero.${paciente.genero}" /></span></td>
	</tr>
	<tr>
		<td><label for="telefone"><fmt:message key="telefone" /></label></td>
		<td><span>${paciente.telefone}</span></td>
	</tr>
	<tr>
		<td><label for="dataNascimento"><fmt:message key="dataNascimento" /></label></td>
		<td><span>${paciente.dataNascimento}</span></td>
	</tr>
	<tr>
		<td><label for="email"><fmt:message key="emailPaciente" /></label></td>
		<td><span>${paciente.email}</span></td>
	</tr>
	<tr>
		<td><label for="login"><fmt:message key="login" /></label></td>
		<td><span>${usuario.login}</span></td>
	</tr>
	<tr>
		<td><label for="CRM"><fmt:message key="medico" /></label></td>
		<td><select id="CRM" name="CRM">
				<c:forEach items="${listaMedicos}" var="medico">
					<option value="${medico.CRM}">${medico.nome} -
						<fmt:message key="especialidade.${medico.especialidade}" /></option>
				</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td><label for="data"><fmt:message key="dataConsulta" /></label></td>
		<td><input type="date" id="data" name="data" size="45"/></td>
	</tr>
	<tr>
		<td><label for="hora"><fmt:message key="horaConsulta" /></label></td>
		<td><select id="hora" name="hora">
				<c:forEach items="${horas}" var="hora">
					<option value="${hora.value}">${hora.value}</option>
				</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="<fmt:message key="salvar" />" /></td>
	</tr>
</table>