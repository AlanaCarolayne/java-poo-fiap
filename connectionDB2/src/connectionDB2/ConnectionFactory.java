package connectionDB2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private static final String SCHEMA = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private static DataSource conexao = null;

	public Connection conectar() {
		if (conexao == null) {
			final ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setJdbcUrl(SCHEMA);
			comboPooledDataSource.setUser("rm552261");
			comboPooledDataSource.setPassword("060204");

			comboPooledDataSource.setMaxPoolSize(10);
			conexao = comboPooledDataSource;
		}

		try {
			return DriverManager.getConnection(SCHEMA, "rm552261", "060204");
		} catch (SQLException e) {
			System.out.println("Erro ao conectar");
			throw new RuntimeException(e);
		}

	}

}
