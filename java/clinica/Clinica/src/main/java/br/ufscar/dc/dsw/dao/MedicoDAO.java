package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Medico;

public class MedicoDAO extends GenericDAO {
	
	public void insert(Medico medico) {

		String sql = "INSERT INTO Medico (CRM, email, especialidade, nome, login, papel, senha) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			;

			statement = conn.prepareStatement(sql);
			statement.setString(1, medico.getCRM());
			statement.setString(2, medico.getEmail());
			statement.setString(3, medico.getEspecialidade());
			statement.setString(4, medico.getNome());
			statement.setString(5, medico.getLogin());
			statement.setString(6, medico.getPapel());
			statement.setString(7, medico.getSenha());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Medico> getAll() {

		List<Medico> listaMedicos = new ArrayList<>();
		String sql = "SELECT * from Medico";

		try {
			Connection conn = this.getConnection();
			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String CRM = resultSet.getString("CRM");
				String email = resultSet.getString("email");
				String especialidade = resultSet.getString("especialidade");
				String nome = resultSet.getString("nome");
				String login = resultSet.getString("login");
				String papel = resultSet.getString("papel");
				String senha = resultSet.getString("senha");
				
				Medico medico = new Medico(CRM, email, especialidade, login, nome, papel, senha);
				listaMedicos.add(medico);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaMedicos;
	}
	
	public void delete(Medico medico) {
		String sql = "DELETE FROM Medico where CRM = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, medico.getCRM());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Medico medico) {
		String sql = "UPDATE Medico SET email = ?, especialidade = ?, nome = ?, papel = ?, senha = ? WHERE CRM = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, medico.getEmail());
			statement.setString(2, medico.getEspecialidade());
			statement.setString(3, medico.getNome());
			statement.setString(4, medico.getPapel());
			statement.setString(5, medico.getSenha());
			statement.setString(6, medico.getCRM());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Medico getByCRM(String CRM) {
		Medico medico = null;
		String sql = "SELECT * from Medico where CRM = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, CRM);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String email = resultSet.getString("email");
				String especialidade = resultSet.getString("especialidade");
				String nome = resultSet.getString("nome");
				String login = resultSet.getString("login");
				String papel = resultSet.getString("papel");
				String senha = resultSet.getString("senha");
				
				medico = new Medico(CRM, email, especialidade, login, nome, papel, senha);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return medico;
	}
	
	public Medico getByLogin(String login) {
		Medico medico = null;
		String sql = "SELECT * from Medico where login = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, login);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String CRM = resultSet.getString("CRM");
				String email = resultSet.getString("email");
				String especialidade = resultSet.getString("especialidade");
				String nome = resultSet.getString("nome");
				String papel = resultSet.getString("papel");
				String senha = resultSet.getString("senha");
				
				medico = new Medico(CRM, email, especialidade, login, nome, papel, senha);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return medico;
	}
}