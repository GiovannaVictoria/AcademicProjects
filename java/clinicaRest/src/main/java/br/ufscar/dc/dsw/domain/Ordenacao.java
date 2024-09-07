package br.ufscar.dc.dsw.domain;

import java.util.Comparator;

public enum Ordenacao {
	// Comparadores para Medico
	MEDICO_POR_ESPECIALIDADE_NOME_CRM(
			Comparator.comparing(Medico::getEspecialidade)
				.thenComparing(Medico::getName)
				.thenComparing(Medico::getCRM)),

	// Comparadores para Paciente
	PACIENTE_POR_NOME_EMAIL_CPF_TELEFONE_DATANASCIMENTO_GENERO(
			Comparator.comparing(Paciente::getName)
				.thenComparing(Paciente::getEmail)
				.thenComparing(Paciente::getCPF)
				.thenComparing(Paciente::getTelefone)
				.thenComparing(Paciente::getGenero)
				.thenComparing(Paciente::getDataNascimento)),
	
	// Comparadores para Consulta
	CONSULTA_POR_DATA_HORA_MEDICO_PACIENTE(
            Comparator.comparing(Consulta::getData)
                .thenComparing(Consulta::getHora)
                .thenComparing(consulta -> consulta.getMedico().getEspecialidade())
                .thenComparing(consulta -> consulta.getMedico().getName())
                .thenComparing(consulta -> consulta.getMedico().getCRM())
                .thenComparing(consulta -> consulta.getMedico().getUsername())
                .thenComparing(consulta -> consulta.getMedico().getEmail())
                .thenComparing(consulta -> consulta.getPaciente().getName())
                .thenComparing(consulta -> consulta.getPaciente().getEmail())
    			.thenComparing(consulta -> consulta.getPaciente().getCPF())
    			.thenComparing(consulta -> consulta.getPaciente().getDataNascimento())
    			.thenComparing(consulta -> consulta.getPaciente().getTelefone())
    			.thenComparing(consulta -> consulta.getPaciente().getGenero())
    			.thenComparing(consulta -> consulta.getPaciente().getUsername()));
	
	private final Comparator<?> comparator;

	<T> Ordenacao(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@SuppressWarnings("unchecked")
	public <T> Comparator<T> getComparator() {
		return (Comparator<T>) comparator;
	}
}