package connectionDB;

import java.sql.Date;

// modelo javabeans
public class Cliente {
//	---------------atributos correspondem aos campos da tabela cliente ------------------
	private int idCliente;
	private String nome, cpf, telefone;
	private Date dataNasc;

//	----------------construtor------------------------------------------------------------
	public Cliente(String nome, String cpf, String telefone, Date dataNasc) {

		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNasc = dataNasc;
	}

	// ---------------getters and setter---------------------------------------------------
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

}
