package br.com.ebix.desafio.crud.model;

public class Aluno {
	private Integer id;
	private String nome;
	private String endereco;
	
	public Aluno() {
		super();
	}
	
	public Aluno(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", endereco=" + endereco + "]";
	}
}
