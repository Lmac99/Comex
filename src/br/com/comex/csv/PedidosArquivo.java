package br.com.comex.csv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface PedidosArquivo {
    public List<PedidoCsv> lerPedido(String fileName) throws FileNotFoundException, IOException;
}
