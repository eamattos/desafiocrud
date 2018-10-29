package br.com.ebix.desafio.crud.model;

public class Escola {
	private Integer id;
	private String nome;
	private String endereco;
	
	public Escola() {
		super();
	}
	
	public Escola(Integer id) {
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
		return "Escola [nome=" + nome + ", endereco=" + endereco + "]";
	}
}
