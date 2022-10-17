package br.com.comex.csv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
// Foi utilizada a biblioteca do Google gson
// https://github.com/google/gson
public class ArquivoJson implements PedidosArquivo {

    @Override
    public List<PedidoCsv> lerPedido(String fileName) throws IOException {
        Gson gson = new Gson();
        List<PedidoCsv> pedidosJson = new ArrayList<PedidoCsv>();

        String s = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
        PedidoCsv[] p = gson.fromJson(s, PedidoCsv[].class);

        for(PedidoCsv pedido : p) {
            String categoria = pedido.getCategoria();
            String produto = pedido.getProduto();
            String preco = pedido.getPreco();
            String quantidade = pedido.getQuantidade();
            String data = pedido.getData();
            String cliente = pedido.getCliente();

            PedidoCsv pedidoTemp = new PedidoCsv(categoria,  produto,  cliente,  preco,  quantidade, data);
            pedidosJson.add(pedidoTemp);
        }
        return pedidosJson;
    }
}
