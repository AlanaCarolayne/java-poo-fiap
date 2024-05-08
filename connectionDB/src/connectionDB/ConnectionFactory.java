package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
//	jdbc
	
	public Connection conectar() {
		
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "rm552261", "060204");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
 	
	
	

}
