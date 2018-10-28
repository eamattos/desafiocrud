package br.com.ebix.desafio.crud.model;

public class Aluno {
	private String id;
	private String nome;
	private String endereco;
	
	public Aluno() {
		super();
	}
	
	public Aluno(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
