package br.com.ebix.desafio.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.ebix.desafio.crud.model.Aluno;

@WebService
public interface DesafioWS {
	
	@WebMethod
	public List<Aluno> listarAlunos();
}