package br.com.fiap.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
private Connection connection;
private final String url ="jdbc:oracle:thin:@oracle.fiap.con.br:1521:ORCL";
private final String user = "";
private final String password = "" ;

public Connection getConnection() {
	try {
		this.connection = DriverManager.getConnection(url, user, password);
	} catch (SQLException e) {
	throw new RuntimeException("Erro ao conectar ao banco de dados");
	}
	return connection;
}



} 
