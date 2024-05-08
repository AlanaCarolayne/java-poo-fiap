package connectionDB;

import java.sql.Date;

public class Main {

	public static void main(String[] args) {
		Date data = new Date(0);
		Cliente cliente = new Cliente("Ivo", "22222222", "3333-333000", data);
		ClienteDAO dao = new ClienteDAO();
		dao.insert(cliente);
		
		
		

	}

}
