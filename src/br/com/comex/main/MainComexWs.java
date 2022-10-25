package br.com.comex.main;

import javax.xml.ws.Endpoint;

import br.com.comex.ws.ComexWs;

/*
 * Publique o ComexWS no endereço http://localhost:8080/ComexWS, usando a classe Endpoint conforme visto na aula O primeiro serviço SOAP.
 * Bote o Web Service no ar!
 * Veja o WSDL gerado em: http://localhost:8080/ComexWS?wsdl
 */
public class MainComexWs {
    public static void main(String[] args) {
        ComexWs categoriaWs = new ComexWs();
        String URL = "http://0.0.0.0:8080/ComexWS";

        System.out.println("ComexWS rodando: " + URL);

        Endpoint.publish(URL, categoriaWs);
    }
}
