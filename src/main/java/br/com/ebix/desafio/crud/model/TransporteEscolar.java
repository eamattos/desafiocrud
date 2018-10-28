package br.com.ebix.desafio.crud.model;

public class TransporteEscolar {
	private String id;
	private String nome;
	private String cnpj;
	
	public TransporteEscolar() {
		super();
	}
	
	public TransporteEscolar(String id) {
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
