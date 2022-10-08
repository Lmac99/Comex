package br.com.comex.main;

import java.io.IOException;

import br.com.comex.csv.PedidoMaisBaratoEMaisCaro;

public class MainPedidoBaratoECaro {
    public static void main(String[] args) throws IOException {
        
        PedidoMaisBaratoEMaisCaro pedido = new PedidoMaisBaratoEMaisCaro();
        pedido.encontrarProdutoMaisCaroEBarato();
    }
}
