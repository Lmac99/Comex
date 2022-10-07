package br.com.comex.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorPedidosCsv {
    public List<PedidoCsv> lerPedidoCsv() throws IOException {
        List<PedidoCsv> pedidosCsv = new ArrayList<PedidoCsv>();

        BufferedReader buffReader = new BufferedReader(new FileReader("pedidos.csv"));
        buffReader.readLine();
        String linha = buffReader.readLine();

        while (linha != null) {
            String[] valores = linha.split(",");

            String categoria = valores[0];
            String produto = valores[1];
            String preco = valores[2];
            String quantidade = valores[3];
            String data = valores[4];
            String cliente = valores[5];

            PedidoCsv pedido = new PedidoCsv(categoria,  produto,  cliente,  preco,  quantidade, data);
            pedidosCsv.add(pedido);

            linha = buffReader.readLine();
        }

        buffReader.close();
        return pedidosCsv;
    }
}
