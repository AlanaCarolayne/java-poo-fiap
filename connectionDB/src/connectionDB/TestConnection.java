package connectionDB;

import java.sql.Date;
import java.util.List;

public class TestConnection {

	public static void main(String[] args) {

		
		ClienteDAO dao = new ClienteDAO();
		Date dataNasc = new Date(0);
//		Cliente ivo = new Cliente("Ivo", "123456", "321654", dataNasc);
//		dao.insert(ivo);
		Usuario geraldo = new Usuario("Geraldo", "321456", "7894456", dataNasc);
		dao.insert(geraldo);
		List<Usuario> listaClientes = dao.selectAll();

		for (Usuario cliente : listaClientes) {
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("Telefone: " + cliente.getTelefone());
			System.out.println("Data nascimento: " + cliente.getDataNasc());
			System.out.println("----------------------------------------");
		}
//		
		 dao.update(geraldo, 1);
		 dao.delete(1);
		
//		
//		Cliente cliente = dao.selectById(1);
//		System.out.println(cliente.getNome());
//		
//		dao.update(cliente, 3);

	}
}
