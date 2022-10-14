package br.com.comex.main;

import br.com.comex.modelo.*;

public class MainCalculadoraValorTotal {
    public static void main(String[] args) {
        //CATEGORIAS
        Categoria cat1 = new Categoria(1,"INFORMÁTICA", StatusCategoria.ATIVA);
        Categoria cat2 = new Categoria(2,"LIVROS", StatusCategoria.INATIVA);

        // CLIENTES
        Cliente cli1 = new Cliente(1,"Ana Paula", "00000000000", "(11) 9 9999-9999", "Rua Ali", "12", "Apt 2", "Bairro A", "São Paulo", EstadoClienteSigla.SP);
        Cliente cli2 = new Cliente(2,"Eli Maria", "11111111111", "(48) 9 8888-8888", "Rua Azul", "N/S", "N/S", "Bairro Cinza", "Florianópolis", EstadoClienteSigla.SC);

        // PEDIDOS FEITOS PELOS CLIENTES
        Pedido p1 = new Pedido(cli1);
        Pedido p2 = new Pedido(cli2);

        // PRODUTOS COMPRADOS
        Produto prod1 = new Produto(1,"Notebook Samsung", "descricao", 3523.00, 1, cat1);
        Produto prod2 = new ProdutoIsento(2,"Clean Architecture", "descricao", 102.90, 2, cat2);

        // COMPOSIÇÃO DO ITEM PEDIDO
        ItemPedido iPedido1 = new ItemPedido(2899.99, 2, prod1, p1, "PROMOCAO");
        ItemPedido iPedido2 = new ItemPedido(100, 11, prod2, p2, "QUANTIDADE");

        System.out.println("Total produto "+ prod1.getId()+ ": " +prod1.calcula());
        System.out.println("Total produto "+ prod2.getId()+ ": " +prod1.calcula());

        System.out.println("Total Item pedido "+ iPedido1.getId()+ ": " +iPedido1.calcula());
        System.out.println("Total Item pedido "+ iPedido2.getId()+ ": " +iPedido1.calcula());
    }
}
