package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionFactory;
import modelo.Usuario;

public class UsuarioDao {

	private Connection con;
	
	public UsuarioDao () {
		con = new ConnectionFactory().getConnection();
	}
	
	public Usuario getUsuario(Long id) {
		String sql = "SELECT * FROM usuarios WHERE id= ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			Usuario usuario = new Usuario();
			while (rs.next()) {
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("senha"));
				usuario.setSenha(rs.getString("senha"));
			}
			
			return usuario;
				
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean adicionaUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean editaUsuario (Usuario usuario) {
		String sql = "UPDATE usuarios SET nome=?, email=?, senha=? WHERE id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			ps.setLong(4, usuario.getId());
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean removeUsuario (Usuario usuario) {
		String sql = "DELETE FROM usuarios WHERE id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1, usuario.getId());
			ps.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Usuario> getListaUsuarios () {
		String sql = "SELECT * FROM usuarios";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				
				usuarios.add(usuario);
			}
			
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
			return usuarios;
		}
	}
}
