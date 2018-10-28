package br.com.ebix.desafio.crud.dao;

import java.util.List;

import br.com.ebix.desafio.crud.model.Aluno;

public interface IAlunoDao {
	public List<Aluno> list();
	
	public void add(Aluno aluno);
	
	public void update(Aluno aluno);
	
	public void delete(Aluno aluno);
	
	public Aluno getById(Aluno aluno);
}
