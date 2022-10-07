package br.com.comex.main;

import java.io.IOException;

import br.com.comex.csv.TotalProdutoVendidos;

public class MainTotalVendidos {
    public static void main(String[] args) throws IOException {
        TotalProdutoVendidos totalProdutos = new TotalProdutoVendidos();
        System.out.println("Total de produtos vendidos: "+totalProdutos.CalculaTotal());
    }
}
