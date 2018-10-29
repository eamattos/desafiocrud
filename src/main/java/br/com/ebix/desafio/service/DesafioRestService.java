package br.com.ebix.desafio.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SQLException_Exception;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;

@ApplicationPath("desafio")
@Path("/correios")
public class DesafioRestService {
	
	@GET
	@Path("/cep")
	public Response retornaCep() {
		  AtendeClienteService atendeClienteService = new AtendeClienteService();
		  AtendeCliente atendeCliente = atendeClienteService.getAtendeClientePort();
		  String retorno = "";
		  
		  try {
			  EnderecoERP enderecoERP = atendeCliente.consultaCEP("24120350"); 
		  	  retorno = enderecoERP.getEnd();
		  } catch (SigepClienteException sce) {
			  return Response.serverError().status(502, sce.getMessage()).build();
		  } catch (SQLException_Exception see) {
			  return Response.serverError().status(502, see.getMessage()).build();
		  }
		  
		  return Response.ok(retorno).build();
	}
}