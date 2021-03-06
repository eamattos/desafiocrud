package br.com.ebix.desafio.crud.model;

import java.beans.Transient;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class Aluno {
	private Integer id;
	
	//@XmlElement( required = true )
	private String nome;
	
	//@XmlElement( required = true )
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
