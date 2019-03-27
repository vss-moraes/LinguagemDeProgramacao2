package lp2.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/lp2", "postgres", "senhadopostgres");
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
