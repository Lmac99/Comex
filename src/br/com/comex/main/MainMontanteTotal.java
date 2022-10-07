package br.com.comex.main;

import java.io.IOException;

import br.com.comex.csv.MontanteTotalVendas;

public class MainMontanteTotal {
    public static void main(String[] args) throws IOException {
        MontanteTotalVendas total = new MontanteTotalVendas();
        System.out.println("Montante de vendas: "+total.calcularMontanteVendas());
    }
}
