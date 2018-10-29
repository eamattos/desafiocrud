package br.com.ebix.desafio.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RestController;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SQLException_Exception;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;

@RestController
@Path("/correios")
public class DesafioRestService {
	
	@GET
	@Path("/cep/{cep}")
	public Response retornaCep(@PathParam("cep") String cep) {
		  AtendeClienteService atendeClienteService = new AtendeClienteService();
		  AtendeCliente atendeCliente = atendeClienteService.getAtendeClientePort();
		  String retorno = "";
		  
		  try {
			  EnderecoERP enderecoERP = atendeCliente.consultaCEP(cep);
			  StringBuilder strBuilder = new StringBuilder(enderecoERP.getEnd())
					  .append(enderecoERP.getComplemento()).append(" ")
					  .append(enderecoERP.getComplemento2()).append(" ")
					  .append(enderecoERP.getBairro()).append(" ")
					  .append(enderecoERP.getCidade()).append(" ")
					  .append(enderecoERP.getUf());
		  	  retorno = strBuilder.toString();
		  } catch (SigepClienteException sce) {
			  return Response.serverError().status(502, sce.getMessage()).build();
		  } catch (SQLException_Exception see) {
			  return Response.serverError().status(502, see.getMessage()).build();
		  }
		  
		  return Response.ok(retorno).build();
	}
}