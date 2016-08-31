package t1.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection createConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:8080"; //Nome da base de dados
		String user = "root"; //nome do usuário do MySQL
		String password = "root"; //senha do MySQL
		
		Connection conexao = null;
		conexao = DriverManager.getConnection(url, user, password);
		
		return conexao;
	}
}