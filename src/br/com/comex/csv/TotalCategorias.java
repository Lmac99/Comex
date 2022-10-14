package br.com.comex.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TotalCategorias {
    // CLASSE INSTÂNCIADA E EXECUTADA NA CLASSE MainTotalCategoria
    public void calcularTotalCategorias() throws IOException{
        List<PedidoCsv> pedidosSemDuplicatas = new LeitorPedidosCsv().lerPedidoCsv();
        List<String> categoriasUnicas = new ArrayList<String>();
        for (PedidoCsv tempPedido : pedidosSemDuplicatas) {
            String categoria = tempPedido.getCategoria();
            if(!categoriasUnicas.contains(categoria)){
                categoriasUnicas.add(categoria);
            }
        }
        System.out.println("Total de categorias: "+categoriasUnicas.size());
    }
}
