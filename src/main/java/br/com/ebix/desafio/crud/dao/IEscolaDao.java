package br.com.ebix.desafio.crud.dao;

import java.util.List;

import br.com.ebix.desafio.crud.model.Escola;

public interface IEscolaDao {
	public List<Escola> list();
	
	public void add(Escola escola);
	
	public void update(Escola escola);
	
	public void delete(Escola escola);
	
	public Escola getById(Escola escola);
}
