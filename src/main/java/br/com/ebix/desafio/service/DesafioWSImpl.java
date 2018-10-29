package br.com.ebix.desafio.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.ebix.desafio.crud.model.Aluno;
import br.com.ebix.desafio.crud.model.Escola;
import br.com.ebix.desafio.crud.model.TransporteEscolar;
import br.com.ebix.desafio.crud.repository.AlunoRepository;
import br.com.ebix.desafio.crud.repository.EscolaRepository;
import br.com.ebix.desafio.crud.repository.TransporteEscolarRepository;

@WebService(endpointInterface = "br.com.ebix.desafio.service.DesafioWS", serviceName = "DesafioWS")
public class DesafioWSImpl implements DesafioWS {
	
	@Autowired
	AlunoRepository alunoRepo;

	@Autowired
	EscolaRepository escolaRepo;
	
	@Autowired
	TransporteEscolarRepository transpEscolarRepo;
	
    @PostConstruct
	public void init() {
	    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	public List<Aluno> listarAlunos() {
		return alunoRepo.list();
	}

	@Override
	public void inserirAluno(Aluno a) {
		alunoRepo.insert(a);
	}

	@Override
	public void removerAluno(Integer id) {
		alunoRepo.delete(id);
	}

	@Override
	public Aluno retornarDadosAluno(Integer id) {
		return alunoRepo.getById(id);
	}
	
	@Override
	public void atualizarDadosAluno(Aluno a) {
		alunoRepo.update(a);
	}

	@Override
	public List<Escola> listarEscolas() {
		return escolaRepo.list();
	}

	@Override
	public void inserirEscola(Escola a) {
		escolaRepo.insert(a);
	}

	@Override
	public void removerEscola(Integer id) {
		escolaRepo.delete(id);		
	}

	@Override
	public Escola retornarDadosEscola(Integer id) {
		return escolaRepo.getById(id);
	}

	@Override
	public void atualizarDadosEscola(Escola a) {
		escolaRepo.update(a);
	}

	@Override
	public List<TransporteEscolar> listarTransporteEscolar() {
		return transpEscolarRepo.list();
	}

	@Override
	public void inserirTransporteEscolar(TransporteEscolar a) {
		transpEscolarRepo.insert(a);
	}

	@Override
	public void removerTransporteEscolar(Integer id) {
		transpEscolarRepo.delete(id);		
	}

	@Override
	public TransporteEscolar retornarDadosTransporteEscolar(Integer id) {
		return transpEscolarRepo.getById(id);
	}

	@Override
	public void atualizarDadosTransporteEscolar(TransporteEscolar a) {
		transpEscolarRepo.update(a);
	}
}