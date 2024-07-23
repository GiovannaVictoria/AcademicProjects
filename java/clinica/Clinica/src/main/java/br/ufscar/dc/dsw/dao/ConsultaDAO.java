package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Consulta;

public class ConsultaDAO extends GenericDAO {

	public void insert(Consulta consulta) {
		
		String sql = "INSERT INTO Consulta (protocolo, CPF, CRM, especialidade, nomeMedico, nomePaciente, horario) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			;

			statement = conn.prepareStatement(sql);
			statement.setLong(1, consulta.getProtocolo());
			statement.setString(2, consulta.getCPF());
			statement.setString(3, consulta.getCRM());
			statement.setString(4, consulta.getEspecialidade());
			statement.setString(5, consulta.getNomeMedico());
			statement.setString(6, consulta.getNomePaciente());
			statement.setString(7, consulta.getHorario());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Consulta> getAllByPatient(String CPF) {

		List<Consulta> listaConsultas = new ArrayList<>();
		String sql = "SELECT * from Consulta where CPF = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, CPF);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {				
				long protocolo = resultSet.getLong("protocolo");
				String CRM = resultSet.getString("CRM");
				String especialidade = resultSet.getString("especialidade");
				String nomeMedico = resultSet.getString("nomeMedico");
				String nomePaciente = resultSet.getString("nomePaciente");
				String horario = resultSet.getString("horario");
				Consulta consulta = new Consulta(protocolo, CPF, CRM, especialidade, nomeMedico, nomePaciente, horario);
				listaConsultas.add(consulta);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return listaConsultas;
	}
	
	public List<Consulta> getAllByDoctor(String CRM) {

		List<Consulta> listaConsultas = new ArrayList<>();
		String sql = "SELECT * from Consulta where CRM = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, CRM);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {				
				long protocolo = resultSet.getLong("protocolo");
				String CPF = resultSet.getString("CPF");
				String especialidade = resultSet.getString("especialidade");
				String nomeMedico = resultSet.getString("nomeMedico");
				String nomePaciente = resultSet.getString("nomePaciente");
				String horario = resultSet.getString("horario");
				Consulta consulta = new Consulta(protocolo, CPF, CRM, especialidade, nomeMedico, nomePaciente, horario);
				listaConsultas.add(consulta);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return listaConsultas;
	}
	
	public List<Consulta> getAllByDateTime(String horario) {

		List<Consulta> listaConsultas = new ArrayList<>();
		String sql = "SELECT * from Consulta where horario = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, horario);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {				
				long protocolo = resultSet.getLong("protocolo");
				String CPF = resultSet.getString("CPF");
				String CRM = resultSet.getString("CRM");
				String especialidade = resultSet.getString("especialidade");
				String nomeMedico = resultSet.getString("nomeMedico");
				String nomePaciente = resultSet.getString("nomePaciente");
				Consulta consulta = new Consulta(protocolo, CPF, CRM, especialidade, nomeMedico, nomePaciente, horario);
				listaConsultas.add(consulta);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return listaConsultas;
	}
	
}