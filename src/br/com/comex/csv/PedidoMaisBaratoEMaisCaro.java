package br.com.comex.csv;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

// Classe que vai receber o retorno da função que busca os valores e armazenar eles.
final class Valores {
    private final double valorMaisCaro;
    private final double valorMaisBarato;
    private final int indexCaro;
    private final int indexBarato;

    public Valores(double valorMaisCaro, double valorMaisBarato, int indexCaro, int indexBarato) {
        this.valorMaisCaro = valorMaisCaro;
        this.valorMaisBarato = valorMaisBarato;
        this.indexCaro = indexCaro;
        this.indexBarato = indexBarato;
    }
    public double getValorMaisCaro() {
        return valorMaisCaro;
    }
    public double getValorMaisBarato() {
        return valorMaisBarato;
    }
    public int getIndexCaro() {
        return indexCaro;
    }
    public int getIndexBarato() {
        return indexBarato;
    }
    
}

public class PedidoMaisBaratoEMaisCaro {
    Locale br = new Locale("pt", "BR");
    NumberFormat brFormat = NumberFormat.getCurrencyInstance(br);

    public void ProdutoMaisCaroEBarato() throws IOException {
        
        List<PedidoCsv> pedidosCsv = new LeitorPedidos().lerCsvJson(new ArquivoCsv(), "pedidos.json");

        Valores val = encontrarProdutoMaisCaroEBarato(pedidosCsv);
        
        System.out.println("Pedido mais barato: " + brFormat.format(val.getValorMaisBarato()) + " ("+ pedidosCsv.get(val.getIndexBarato()).getProduto() + ")");
        System.out.println("Pedido mais caro: " + brFormat.format(val.getValorMaisCaro()) + " ("+ pedidosCsv.get(val.getIndexCaro()).getProduto() + ")");
    }

    // Solução escolhida: Buscar os valores e armazenar sem alterar a lista original
    // É viável também ordenar a lista com sort e com a implementação da interface Comparator usando o montante e então escolher o primeiro e o último elemento
    private Valores encontrarProdutoMaisCaroEBarato(List<PedidoCsv> pedidos){
        int index = 0;
        int indexCaro = 0;
        double valorMaisCaro = 0;

        int indexBarato = 0;
        double valorMaisBarato = 0;
        for (PedidoCsv p : pedidos) {
            double montante = Double.parseDouble(p.getPreco()) * Integer.parseInt(p.getQuantidade());
            if (index == 0) {
                indexCaro = index;
                valorMaisCaro = montante;
                indexBarato = index;
                valorMaisBarato = montante;
                index++;
            } else {
                if (valorMaisCaro < montante) {
                    indexCaro = index;
                    valorMaisCaro = montante;
                    index++;
                } else if (montante < valorMaisBarato) {
                    indexBarato = index;
                    valorMaisBarato = montante;
                    index++;
                } else {
                    index++;
                }
            }
        }
        return new Valores(valorMaisCaro, valorMaisBarato, indexCaro, indexBarato);
    }
}
