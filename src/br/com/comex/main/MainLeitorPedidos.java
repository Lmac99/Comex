package br.com.comex.main;

import java.io.IOException;

import br.com.comex.csv.LeitorPedidosCsv;

public class MainLeitorPedidos {
    public static void main(String[] args) throws IOException {
        LeitorPedidosCsv leitor = new LeitorPedidosCsv();
        int totalPedidos = leitor.lerPedidoCsv().size();
        System.out.println("Total de pedidos: "+totalPedidos);
    }
}
