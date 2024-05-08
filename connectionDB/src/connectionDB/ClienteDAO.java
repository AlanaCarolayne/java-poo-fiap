package connectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//DAO - data access object - é um design pattern
// grupos de comandos principais 
//  ddl -CREATE, ALTER, DROP - tabelas, sequences, trigger
//	dml -INSERT, DELETE, UPDATE - registros na tabela 
//	dcl - GRANTE, REVOKE  - permissoes de usuario  
//  dql - SELECT - consultas
//  dtl - begin, commit,rollback - confimarcoes, retorno ao save point 

public class ClienteDAO {

	private Connection connection;

	public ClienteDAO(Connection connection) {

		this.connection = new ConnectionFactory().conectar();

	}
	
	public void insert(Cliente cliente) {
		String sql = "insert into cliente(nome, telefone, cpf, dataNasc) values (?,?,?,?)";		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,cliente.getNome());
			stmt.setString(2,cliente.getCpf());
			stmt.setString(3,cliente.getTelefone());
			stmt.setDate(4,cliente.getDataNasc());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
