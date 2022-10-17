package br.com.comex.csv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class LeitorPedidos {
    public List<PedidoCsv> lerCsvJson(PedidosArquivo p,String filename) throws FileNotFoundException, IOException{
        return p.lerPedido(filename);
    }
}
