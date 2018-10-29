package br.com.ebix.desafio.crud.model;

import java.beans.Transient;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class TransporteEscolar {
	private Integer id;

	//@XmlElement( required = true )
	private String nome;
	
	//@XmlElement( required = true )
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
