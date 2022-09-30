package br.com.comex.main;
import br.com.comex.modelo.*;
public class MainCategoria {
    public static void main(String[] args) {
        String outS = "Categoria %s (%s - %s)";
        Categoria cat1 = new Categoria(1,"INFORMÁTICA", StatusCategoria.INATIVA); // funcionando normalmente
        Categoria cat2 = new Categoria(5,"INFORMÁTICA", StatusCategoria.ATIVA); // id fora de ordem -> erro
        Categoria cat3 = new Categoria(2,"MÓVEIS", StatusCategoria.INATIVA); // status incorreto -> erro
        Categoria cat4 = new Categoria(0,"LIVROS", StatusCategoria.INATIVA); // id igual a zero -> erro

        System.out.println(cat1.toString());

        System.out.println(String.format(outS, cat1.getNome(), cat1.getId(), cat1.getStatus()));
        System.out.println(String.format(outS, cat2.getNome(), cat2.getId(), cat2.getStatus()));
        System.out.println(String.format(outS, cat3.getNome(), cat3.getId(), cat3.getStatus()));
        System.out.println(String.format(outS, cat4.getNome(), cat4.getId(), cat4.getStatus()));
    }
}