package br.com.comex.main;
import br.com.comex.modelo.*;
public class MainItemPedido {
    public static void main(String[] args) {
        String outS = "**************\nITEM DE PEDIDO %s\nPREÇO UNITÁRIO: %s\nQUANTIDADE: %s\nPRODUTO: %s\nPEDIDO: %s\nDESCONTO: %s\nTIPO DE DESCONTO: %s \n**************";
        // CATEGORIAS
        Categoria cat1 = new Categoria(1,"INFORMÁTICA", "ativa");
        Categoria cat2 = new Categoria(2,"LIVROS", "inativa");

        // CLIENTES
        Cliente cli1 = new Cliente(1,"Ana Paula", "00000000000", "11 9 99999999", "Rua Ali", "12", "Apt 2", "Bairro A", "São Paulo", "SP");
        Cliente cli2 = new Cliente(2,"Eli Maria", "11111111111", "48 9 88888888", "Rua Azul", "N/S", "N/S", "Bairro Cinza", "Florianópolis", "SC");

        // PEDIDOS FEITOS PELOS CLIENTES
        Pedido p1 = new Pedido(cli1);
        Pedido p2 = new Pedido(cli2);

        // PRODUTOS COMPRADOS
        Produto prod1 = new Produto(1,"Notebook Samsung", "descricao", 3523.00, 1, cat1);
        Produto prod2 = new ProdutoIsento(2,"Clean Architecture", "descricao", 102.90, 2, cat2);

        // COMPOSIÇÃO DO ITEM PEDIDO
        ItemPedido iPedido1 = new ItemPedido(2899.99, 2, prod1, p1, "PROMOCAO");
        ItemPedido iPedido2 = new ItemPedido(100, 11, prod2, p2, "QUANTIDADE");

        System.out.println(iPedido1.toString());

        System.out.println(String.format(outS, iPedido1.getId(), iPedido1.getPreco(), iPedido1.getQuantidade(),
                iPedido1.getProduto().getNome(), iPedido1.getIdPedido().getId(), iPedido1.getDesconto(),
                iPedido1.getTipoDesconto()));
        iPedido1.precoSdesconto();
        iPedido1.totalCdesconto();

        System.out.println(String.format(outS, iPedido2.getId(), iPedido2.getPreco(), iPedido2.getQuantidade(),
                iPedido2.getProduto().getNome(), iPedido2.getIdPedido().getId(), iPedido2.getDesconto(),
                iPedido2.getTipoDesconto()));
        iPedido2.precoSdesconto();
        iPedido2.totalCdesconto();
    }
}
