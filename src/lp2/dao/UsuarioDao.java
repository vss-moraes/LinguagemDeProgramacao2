package lp2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lp2.conexao.ConnectionFactory;
import lp2.model.Usuario;

public class UsuarioDao {
	
	Connection con;

	public UsuarioDao () {
		this.con = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Usuario usuario) {
		String sql = "INSERT INTO usuarios "
				+ "(nome, email, senha) "
				+ "values (?, ?, ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
