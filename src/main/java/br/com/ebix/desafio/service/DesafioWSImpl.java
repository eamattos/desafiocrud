package br.com.ebix.desafio.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.ebix.desafio.crud.model.Aluno;
import br.com.ebix.desafio.crud.repository.AlunoRepository;

@WebService(endpointInterface = "br.com.ebix.desafio.service.DesafioWS", serviceName = "DesafioWS")
public class DesafioWSImpl implements DesafioWS {
	
	@Autowired
	AlunoRepository alunoRepo;
	
    @PostConstruct
	public void init() {
	    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	    
	public List<Aluno> listarAlunos() {
		return alunoRepo.list();
	}
}