package connectionDB2;

import java.sql.Date;

public class Usuario {
	private int id;
	private String nome, senha;
	private Date data;

//	-----------construtores--------------------------------
	public Usuario(String nome, String senha, Date data) {

		this.nome = nome;
		this.senha = senha;
		this.data = data;
	}

	public Usuario() {

	}

//	-----------getters & setters---------------
	
	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
