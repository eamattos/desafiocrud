package br.com.ebix.desafio.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import br.com.ebix.desafio.crud.model.Aluno;

@Component
@WebService
public interface DesafioWS {
	
	@WebMethod
	public List<Aluno> listarAlunos();
	
	@WebMethod
	public void inserirAluno(Aluno a);

	@WebMethod
	public void removerAluno(Aluno a);

	@WebMethod
	public void atualizarDadosAluno(Aluno a);
}