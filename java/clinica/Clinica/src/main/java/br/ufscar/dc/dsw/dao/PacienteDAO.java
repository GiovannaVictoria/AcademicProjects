package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Paciente;

public class PacienteDAO extends GenericDAO {

	public void insert(Paciente paciente) {
		
		String sql = "INSERT INTO Paciente (CPF, dataNascimento, email, genero, nome, telefone, login, senha, papel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			;

			statement = conn.prepareStatement(sql);
			statement.setString(1, paciente.getCPF());
			statement.setDate(2, Date.valueOf(paciente.getDataNascimento()));
			statement.setString(3, paciente.getEmail());
			statement.setString(4, paciente.getGenero());
			statement.setString(5, paciente.getNome());
			statement.setString(6, paciente.getTelefone());
			statement.setString(7, paciente.getLogin());
			statement.setString(8, paciente.getSenha());
			statement.setString(9, paciente.getPapel());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Paciente> getAll() {

		List<Paciente> listaPacientes = new ArrayList<>();
		String sql = "SELECT * from Paciente";

		try {
			Connection conn = this.getConnection();
			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String CPF = resultSet.getString("CPF");
				String dataNascimento = resultSet.getString("dataNascimento");
				String email = resultSet.getString("email");
				String genero = resultSet.getString("genero");
				String nome = resultSet.getString("nome");
				String telefone = resultSet.getString("telefone");
				String login = resultSet.getString("login");
				String senha = resultSet.getString("senha");
				String papel = resultSet.getString("papel");
				Paciente paciente = new Paciente(CPF, dataNascimento, email, genero, login, nome, papel, senha, telefone);
				listaPacientes.add(paciente);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaPacientes;
	}

	public void delete(Paciente paciente) {
		String sql = "DELETE FROM Paciente where CPF = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, paciente.getCPF());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Paciente paciente) {
		String sql = "UPDATE Paciente SET dataNascimento = ?, email = ?, genero = ?, nome = ?, telefone = ?, senha = ?, papel = ? WHERE CPF = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setDate(1, Date.valueOf(paciente.getDataNascimento()));
			statement.setString(2, paciente.getEmail());
			statement.setString(3, paciente.getGenero());
			statement.setString(4, paciente.getNome());
			statement.setString(5, paciente.getTelefone());
			statement.setString(6, paciente.getSenha());
			statement.setString(7, paciente.getPapel());
			statement.setString(8, paciente.getCPF());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Paciente getByCPF(String CPF) {
		Paciente paciente = null;

		String sql = "SELECT * from Paciente where CPF = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, CPF);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String dataNascimento = resultSet.getString("dataNascimento");
				String email = resultSet.getString("email");
				String genero = resultSet.getString("genero");
				String nome = resultSet.getString("nome");
				String telefone = resultSet.getString("telefone");
				String login = resultSet.getString("login");
				String papel = resultSet.getString("papel");
				String senha = resultSet.getString("senha");
				
				paciente = new Paciente(CPF, dataNascimento, email, genero, login, nome, papel, senha, telefone);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return paciente;
	}
	
	public Paciente getByLogin(String login) {
		Paciente paciente = null;
		String sql = "SELECT * from Paciente where login = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, login);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String CPF = resultSet.getString("CPF");
				String dataNascimento = resultSet.getString("dataNascimento");
				String email = resultSet.getString("email");
				String genero = resultSet.getString("genero");
				String nome = resultSet.getString("nome");
				String telefone = resultSet.getString("telefone");
				String papel = resultSet.getString("papel");
				String senha = resultSet.getString("senha");
				
				paciente = new Paciente(CPF, dataNascimento, email, genero, login, nome, papel, senha, telefone);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return paciente;
	}
	
}