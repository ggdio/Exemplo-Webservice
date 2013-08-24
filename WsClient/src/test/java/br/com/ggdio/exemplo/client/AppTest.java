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
			/* -- Cria uma conexão com o webservice -- */
			wsdl = new URL("http://localhost:8080/ws/services/exemplo");
			serviceName = new QName("http://exemplo.ggdio.com.br/ws",
					"ExemploService");
			client = new ExemploServiceClient(wsdl, serviceName);

			/* -- Recupera o conexão para a realização de chamadas -- */
			exemploService = client.getPort(ExemploService.class);

			/* -- Execução do método 'helloWorld' -- */
			System.out.println("Método 'helloWorld': ");
			System.out.println("Resposta = " + exemploService.helloWorld());

			/* -- Execução do método 'exibeMensagem' -- */
			System.out.println("\nMétodo 'exibeMensagem': ");
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
