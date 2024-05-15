package connectionDB2;

import java.sql.Date;
import java.util.List;

public class TestConnection {

	public static void main(String[] args) {

		
		UsuarioDAO dao = new UsuarioDAO();
		Date data = new Date(0);
		Usuario ivo = new Usuario("Ivo", "456", data);
		dao.insert(ivo);
		Usuario geraldo = new Usuario("Geraldo", "123",data);
		dao.insert(geraldo);
		List<Usuario> listaUsuario = dao.selectAll();

		for (Usuario usuario : listaUsuario) {
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Data: " + usuario.getData());
			System.out.println("----------------------------------------");
		}
		
		 dao.update(geraldo, 1);
		 dao.delete(2);
		
		
		Usuario usuario= dao.selectById(3);
		System.out.println(usuario.getNome());
		
		dao.update(usuario, 3);

	}
}
