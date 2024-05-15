package connectionDB2;

public class TestConnectionPool {

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			 new ConnectionFactory().conectar();
			 System.out.println("conexao: " +i);
		}

	}

}
