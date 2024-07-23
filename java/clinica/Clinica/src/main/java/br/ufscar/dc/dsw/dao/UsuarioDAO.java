package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Usuario;

public class UsuarioDAO extends GenericDAO {

	public void insert(Usuario usuario) {
		String sql = "INSERT INTO Usuario (login, senha, papel, nome, email) VALUES (?, ?, ?, ?, ?)";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			;
			statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getLogin());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getPapel());
			statement.setString(4, usuario.getNome());
			statement.setString(5, usuario.getEmail());
			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> getAll() {
		List<Usuario> listaUsuarios = new ArrayList<>();
		String sql = "SELECT * from Usuario u";
		try {
			Connection conn = this.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String email = resultSet.getString("email");
				String login = resultSet.getString("login");
				String nome = resultSet.getString("nome");
				String papel = resultSet.getString("papel");
				String senha = resultSet.getString("senha");
				Usuario usuario = new Usuario(email, login, nome, papel, senha);
				listaUsuarios.add(usuario);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaUsuarios;
	}

	public void delete(Usuario usuario) {
		String sql = "DELETE FROM Usuario where login = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getLogin());
			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
		}
	}

	public void update(Usuario usuario) {
		String sql = "UPDATE Usuario SET senha = ?, papel = ?, nome = ?, email = ? WHERE login = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getSenha());
			statement.setString(2, usuario.getPapel());
			statement.setString(3, usuario.getNome());
			statement.setString(4, usuario.getEmail());
			statement.setString(5, usuario.getLogin());
			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario getbyLogin(String login) {
		Usuario usuario = null;
		String sql = "SELECT * from Usuario WHERE login = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, login);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String email = resultSet.getString("email");
				String nome = resultSet.getString("nome");
				String papel = resultSet.getString("papel");
				String senha = resultSet.getString("senha");
				usuario = new Usuario(email, login, nome, papel, senha);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usuario;
	}
}