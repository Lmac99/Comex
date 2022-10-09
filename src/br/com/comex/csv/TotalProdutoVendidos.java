package br.com.comex.csv;

import java.io.IOException;
import java.util.List;

public class TotalProdutoVendidos {
    public int CalculaTotal() throws IOException {
        int quantidade = 0;
        List<PedidoCsv> pedidosCsv = new LeitorPedidosCsv().lerPedidoCsv();
        for(PedidoCsv p: pedidosCsv){
            quantidade += Integer.parseInt(p.getQuantidade());
        }
        return quantidade;
    }
}
