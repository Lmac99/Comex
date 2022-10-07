package br.com.comex.main;

import java.io.IOException;
import java.util.Locale;

import br.com.comex.csv.PedidoMaisBaratoEMaisCaro;

public class MainPedidoBaratoECaro {
    public static void main(String[] args) throws IOException {
		Locale.setDefault(new Locale("en", "US"));
        PedidoMaisBaratoEMaisCaro pedido = new PedidoMaisBaratoEMaisCaro();
        pedido.encontrarProdutoMaisCaroEBarato();
    }
}
