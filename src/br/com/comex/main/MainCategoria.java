package br.com.comex.main;
import br.com.comex.modelo.*;
public class MainCategoria {
    public static void main(String[] args) {
        String outS = "Categoria %s (%s - %s)";
        Categoria cat1 = new Categoria("INFORMÁTICA", StatusCategoria.INATIVA); // funcionando normalmente
        Categoria cat2 = new Categoria("INFMÁTICA", StatusCategoria.INATIVA);
        Categoria cat3 = new Categoria("INFTICA");

        System.out.println(cat1.toString());

        System.out.println(String.format(outS, cat1.getNome(), cat1.getId(), cat1.getStatus()));
        System.out.println(String.format(outS, cat2.getNome(), cat2.getId(), cat2.getStatus()));
        System.out.println(String.format(outS, cat3.getNome(), cat3.getId(), cat3.getStatus()));
    }
}