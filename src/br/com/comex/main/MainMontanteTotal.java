package br.com.comex.main;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.comex.csv.MontanteTotalVendas;

public class MainMontanteTotal {
    public static void main(String[] args) throws IOException {
        Locale br = new Locale("pt", "BR");
        NumberFormat brFormat = NumberFormat.getCurrencyInstance(br);
        MontanteTotalVendas total = new MontanteTotalVendas();
        System.out.println("Montante de vendas: "+brFormat.format(total.calcularMontanteVendas()));
    }
}
