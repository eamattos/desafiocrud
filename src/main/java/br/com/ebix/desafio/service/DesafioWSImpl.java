package br.com.ebix.desafio.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ebix.desafio.crud.model.Aluno;
import br.com.ebix.desafio.crud.repository.AlunoRepository;

@WebService(endpointInterface = "br.com.ebix.desafio.service.DesafioWS", serviceName = "DesafioWS")
public class DesafioWSImpl implements DesafioWS {
	
	@Autowired
	AlunoRepository alunoRepo;
	
	public List<Aluno> listarAlunos() {
		return alunoRepo.list();
	}
}