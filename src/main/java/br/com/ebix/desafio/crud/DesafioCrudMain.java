package br.com.ebix.desafio.crud;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.ebix.desafio.crud.repository.AlunoRepository;
import br.com.ebix.desafio.crud.repository.EscolaRepository;
import br.com.ebix.desafio.crud.repository.TransporteEscolarRepository;

/**
 * Testes de acesso a base de dados
 * 
 * @author emattos
 *
 */
public class DesafioCrudMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				DesafioCrudMain.class.getPackage().getName());
		
		AlunoRepository alunoRepo = applicationContext.getBean(AlunoRepository.class);
		alunoRepo.list().forEach(aluno -> System.out.println("Aluno listar(): " + aluno.toString()));
	
		System.out.println("Aluno getById(Integer): " + alunoRepo.getById(2).toString());
		
		EscolaRepository escolaRepo = applicationContext.getBean(EscolaRepository.class);
		escolaRepo.list().forEach(escola -> System.out.println("Escola listar(): " + escola.toString()));
	
		System.out.println("Escola - getById(Integer): " + escolaRepo.getById(2).toString());
		
		TransporteEscolarRepository transpEscolarRepo = applicationContext.getBean(TransporteEscolarRepository.class);
		transpEscolarRepo.list().forEach(transporteEscolar -> System.out.println("Transp Escolar listar(): " + transporteEscolar.toString()));
	
		System.out.println("Transp Escolar getById(Integer): " + transpEscolarRepo.getById(2).toString());
		
		applicationContext.close();
		
		System.out.println("Fim!");
	}
}
