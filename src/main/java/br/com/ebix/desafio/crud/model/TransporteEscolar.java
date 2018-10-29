package br.com.ebix.desafio.crud.model;

public class TransporteEscolar {
	private Integer id;
	private String nome;
	private String cnpj;
	
	public TransporteEscolar() {
		super();
	}
	
	public TransporteEscolar(Integer id) {
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "TransporteEscolar [nome=" + nome + ", cnpj=" + cnpj + "]";
	}
}
