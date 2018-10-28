package br.com.ebix.desafio.crud.dao;

import java.util.List;

import br.com.ebix.desafio.crud.model.TransporteEscolar;

public interface ITransporteEscolar {

	public List<TransporteEscolar> list();
	
	public void add(TransporteEscolar transporteEscolar);
	
	public void update(TransporteEscolar transporteEscolar);
	
	public void delete(TransporteEscolar transporteEscolar);
	
	public TransporteEscolar getById(TransporteEscolar transporteEscolar);
}
