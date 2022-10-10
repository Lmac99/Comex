package br.com.comex.main;
import br.com.comex.modelo.*;
public class MainCategoria {
    public static void main(String[] args) {
        String outS = "Categoria %s (%s - %s)";
        Categoria cat1 = new Categoria(1,"INFORMÁTICA", StatusCategoria.INATIVA); // funcionando normalmente

        System.out.println(cat1.toString());

        System.out.println(String.format(outS, cat1.getNome(), cat1.getId(), cat1.getStatus()));
    }
}