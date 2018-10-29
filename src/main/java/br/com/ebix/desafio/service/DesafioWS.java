package br.com.ebix.desafio.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import br.com.ebix.desafio.crud.model.Aluno;
import br.com.ebix.desafio.crud.model.Escola;
import br.com.ebix.desafio.crud.model.TransporteEscolar;

@Component
@WebService
public interface DesafioWS {
	
	@WebMethod
	public List<Aluno> listarAlunos();
	
	@WebMethod
	public void inserirAluno(Aluno a);

	@WebMethod
	public void removerAluno(Integer id);
	
	@WebMethod
	public Aluno retornarDadosAluno(Integer id);

	@WebMethod
	public void atualizarDadosAluno(Aluno a);
	
	@WebMethod
	public List<Escola> listarEscolas();
	
	@WebMethod
	public void inserirEscola(Escola a);

	@WebMethod
	public void removerEscola(Integer id);
	
	@WebMethod
	public Escola retornarDadosEscola(Integer id);

	@WebMethod
	public void atualizarDadosEscola(Escola a);
	
	@WebMethod
	public List<TransporteEscolar> listarTransporteEscolar();
	
	@WebMethod
	public void inserirTransporteEscolar(TransporteEscolar a);

	@WebMethod
	public void removerTransporteEscolar(Integer id);
	
	@WebMethod
	public TransporteEscolar retornarDadosTransporteEscolar(Integer id);

	@WebMethod
	public void atualizarDadosTransporteEscolar(TransporteEscolar a);
}