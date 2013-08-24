package br.com.ggdio.exemplo.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import br.com.ggdio.ws.service.client.ExemploServiceClient;
import br.com.ggdio.ws.service.structure.ExemploService;

/**
 * Realiza as chamadas ao webservice para testar
 * @author Guilherme Dio
 */
public class AppTest {

	public static void main(String[] args) {
		URL wsdl;
		QName serviceName;
		ExemploServiceClient client;
		ExemploService exemploService;
		try {
			/* -- Cria uma conex�o com o webservice -- */
			wsdl = new URL("http://localhost:8080/ws/services/exemplo");
			serviceName = new QName("http://exemplo.ggdio.com.br/ws",
					"ExemploService");
			client = new ExemploServiceClient(wsdl, serviceName);

			/* -- Recupera o conex�o para a realiza��o de chamadas -- */
			exemploService = client.getPort(ExemploService.class);

			/* -- Execu��o do m�todo 'helloWorld' -- */
			System.out.println("M�todo 'helloWorld': ");
			System.out.println("Resposta = " + exemploService.helloWorld());

			/* -- Execu��o do m�todo 'exibeMensagem' -- */
			System.out.println("\nM�todo 'exibeMensagem': ");
			System.out.println("Resposta = "+exemploService.exibeMensagem("Ola teste 123 abc"));
		} catch (MalformedURLException e) {
			System.err.println(e.toString());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(e.toString());
			e.printStackTrace();
		} finally {
			System.out.println("Finalizando....");
			wsdl = null;
			serviceName = null;
			client = null;
			exemploService = null;
		}
		System.exit(0);

	}

}
