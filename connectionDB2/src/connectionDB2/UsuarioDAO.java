package connectionDB2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CRUD usuario
public class UsuarioDAO {

	private Connection connection;

	public UsuarioDAO() {
		this.connection = new ConnectionFactory().conectar();
	}

	// insert
	public void insert(Usuario usuario) {
		String sql = "insert into usuario (nome, senha,data) values (?, ?, ?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setDate(3, usuario.getData());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// selectAll
	public List<Usuario> selectAll() {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			String sql = "select * from usuario";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setData(rs.getDate("data"));
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
			return usuarios;
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	public Usuario selectById(int id) {
		Usuario usuario= null;
		try {
			String sql = "select * from usuario where id = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			usuario = new Usuario();
			usuario.setId(rs.getInt("id"));
			usuario.setNome(rs.getString("nome"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setData(rs.getDate("data"));
			}
			rs.close();
			stmt.close();
			return usuario;
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	public void update(Usuario usuario, int id) {
		String sql = "update usuario set nome=?, senha=?, data =? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setDate(3, usuario.getData());
			stmt.setInt(4, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(int id) {
		try {
			String sql = "delete from usuario where id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
