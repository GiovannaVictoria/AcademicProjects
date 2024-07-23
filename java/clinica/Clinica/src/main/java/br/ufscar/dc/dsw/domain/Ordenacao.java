package br.ufscar.dc.dsw.domain;

import java.util.Comparator;

public enum Ordenacao {
	// Comparadores para Medico
	MEDICO_POR_ESPECIALIDADE_NOME_CRM(Comparator.comparing(Medico::getEspecialidade).thenComparing(Medico::getNome)
			.thenComparing(Medico::getCRM)),

	// Comparadores para Paciente
	PACIENTE_POR_NOME_CPF_DATANASCIMENTO_GENERO(Comparator.comparing(Paciente::getNome).thenComparing(Paciente::getCPF)
			.thenComparing(Paciente::getDataNascimento).thenComparing(Paciente::getGenero)),

	// Comparadores para Consulta
	CONSULTA_POR_HORARIO_NOMEPACIENTE_CPF_NOMEMEDICO_CRM_ESPECIALIDADE(
			Comparator.comparing(Consulta::getHorario).thenComparing(Consulta::getNomePaciente)
					.thenComparing(Consulta::getCPF).thenComparing(Consulta::getNomeMedico)
					.thenComparing(Consulta::getCRM).thenComparing(Consulta::getEspecialidade));

	private final Comparator<?> comparator;

	<T> Ordenacao(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@SuppressWarnings("unchecked")
	public <T> Comparator<T> getComparator() {
		return (Comparator<T>) comparator;
	}
}
