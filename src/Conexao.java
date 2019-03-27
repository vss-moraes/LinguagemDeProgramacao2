import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
	
	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost/lp2", "postgres", "senhadopostgres");
			System.out.println("Conectado");
			
			String sql = "INSERT INTO contatos " +
					"(nome, email, senha) " +
					"values (?, ?, ?)";
			
			Usuario u = new Usuario();
			u.setNome("Vinicius");
			u.setEmail("email");
			u.setSenha("senha");
			

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, u.getNome());
			preparedStatement.setString(2, u.getEmail());
			preparedStatement.setString(3, u.getSenha());
			
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
