package br.com.ggdio.ws.service.structure;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Definição da estrutura e dos metodos do webservice
 * @author Guilherme Dio
 */
@WebService
public interface ExemploService {
	
	@WebMethod
	public String helloWorld();
	
	@WebMethod
	public String exibeMensagem(String msg);

}
