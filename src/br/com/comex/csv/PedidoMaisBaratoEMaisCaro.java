package br.com.comex.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PedidoMaisBaratoEMaisCaro {

    public void encontrarProdutoMaisCaroEBarato() throws IOException{
        int indexCaro = 0;
        double valorMaisCaro = 0;

        int indexBarato = 0;
        double valorMaisBarato = 0;
        List<PedidoCsv> pedidosCsv = lerPedidoCsv();
        

        int index = 0;
        for(PedidoCsv p: pedidosCsv){
            //System.out.println(p);
            //System.out.println("index caro: "+indexCaro);
            //System.out.println("1: "+valorMaisCaro);

            //System.out.println("index barato: "+indexBarato);
            //System.out.println("2: "+valorMaisBarato);
            double montante = Float.parseFloat(p.getPreco()) * Integer.parseInt(p.getQuantidade());
            if(index == 0){
                indexCaro = index;
                valorMaisCaro = montante;
                indexBarato = index;
                valorMaisBarato = montante;
                index++;
            }
            else{
                if(valorMaisCaro < montante){
                    indexCaro = index;
                    valorMaisCaro = montante;
                    index++;
                }
                else if(montante < valorMaisBarato){
                    indexBarato = index;
                    valorMaisBarato = montante;
                    index++;
                }
                else{
                    index++;
                }
        }
            
        }
        System.out.println("Pedido mais barato: "+String.format("%.2f", valorMaisBarato) +" ("+pedidosCsv.get(indexBarato).getProduto()+")");
        System.out.println("Pedido mais caro: "+String.format("%.2f", valorMaisCaro) +" ("+pedidosCsv.get(indexCaro).getProduto()+")");
        
        
    }
    private List<PedidoCsv> lerPedidoCsv() throws IOException{
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
