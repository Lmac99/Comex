package br.com.comex.csv;


import java.io.IOException;
import java.util.List;

public class MontanteTotalVendas {

    public float calcularMontanteVendas() throws IOException{
        float montante = 0f;
        List<PedidoCsv> pedidos = new LeitorPedidosCsv().lerPedidoCsv();
        for (PedidoCsv tempPedido : pedidos) {
            montante += Float.parseFloat(tempPedido.getPreco()) * Integer.parseInt(tempPedido.getQuantidade());
        }
        return montante;
    }
}
