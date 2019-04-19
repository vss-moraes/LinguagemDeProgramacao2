package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost/provalp2", "postgres", "senhadopostgres");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
