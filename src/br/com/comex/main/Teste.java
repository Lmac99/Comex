package br.com.comex.main;

import java.io.IOException;
import java.util.List;

import br.com.comex.csv.ArquivoCsv;
import br.com.comex.csv.ArquivoJson;
import br.com.comex.csv.LeitorPedidos;
import br.com.comex.csv.PedidoCsv;

public class Teste {
    public static void main(String[] args) throws IOException {
        LeitorPedidos arq = new LeitorPedidos();
        List<PedidoCsv> pedido =  arq.lerCsvJson(new ArquivoJson(), "pedidos.json");
        for(PedidoCsv pedidoJson: pedido){
            System.out.println(pedidoJson);
        }
        System.out.println("**********************************************\n");
        List<PedidoCsv> pedidoCsvList =  arq.lerCsvJson(new ArquivoCsv(), "pedidos.csv");
        for(PedidoCsv pedidoCsv: pedidoCsvList){
            System.out.println(pedidoCsv);
        }
    }
}
