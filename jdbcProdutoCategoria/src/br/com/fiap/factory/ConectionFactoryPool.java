package br.com.fiap.factory;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConectionFactoryPool {

	private static HikariDataSource dataSource;

	static {

		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@oracle.fiap.con.br:1521:ORCL");
		config.setUsername("");
		config.setPassword("");
		config.setMaximumPoolSize(10);
		config.setMinimumIdle(5);
		config.setIdleTimeout(60000);
		config.setConnectionTimeout(300000);
		dataSource = new HikariDataSource(config);
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close() {
		if (dataSource != null) {
			dataSource.close();
		}
	}

}
