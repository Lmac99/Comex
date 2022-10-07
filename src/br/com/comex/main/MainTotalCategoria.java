package br.com.comex.main;

import java.io.IOException;

import br.com.comex.csv.TotalCategorias;

public class MainTotalCategoria {
    public static void main(String[] args) throws IOException {
        TotalCategorias total = new TotalCategorias();
        total.calcularTotalCategorias();
    }
}
