package br.com.ggdio.ws.service;

import javax.jws.WebService;

import br.com.ggdio.ws.service.structure.ExemploService;

/**
 * Implementação do webservice definido na interface {@link ExemploService}
 * @author Guilherme Dio
 */
@WebService(
	    portName = "ExemploPort",
	    serviceName = "ExemploService",
	    targetNamespace = "http://exemplo.ggdio.com.br/ws",
	    endpointInterface = "br.com.ggdio.ws.service.structure.ExemploService")
public class ExemploServiceWs implements ExemploService {

	@Override
	public String helloWorld() {
		return "Hello World !";
	}

	@Override
	public String exibeMensagem(String msg) {
		return "Mensagem: "+msg;
	}

}
