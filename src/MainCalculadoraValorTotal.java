public class MainCalculadoraValorTotal {
    public static void main(String[] args) {
        CalculadoraValorTotal calc = new CalculadoraValorTotal();
        //CATEGORIAS
        Categoria cat1 = new Categoria("INFORMÁTICA");
        Categoria cat2 = new Categoria("LIVROS");

        // CLIENTES
        Cliente cli1 = new Cliente("Ana", "001", "11 9 99999999", "Rua A", "12", "Apt 2", "Bairro A", "São Paulo","São Paulo");
        Cliente cli2 = new Cliente("Eli", "002", "48 9 88888888", "Rua Azul", "N/S", "N/S", "Bairro Cinza","Florianópolis", "Santa Catarina");

        // PEDIDOS FEITOS PELOS CLIENTES
        Pedido p1 = new Pedido(cli1);
        Pedido p2 = new Pedido(cli2);

        // PRODUTOS COMPRADOS
        Produto prod1 = new Produto("Notebook Samsung", "descricao", 3523.00, 1, cat1);
        Produto prod2 = new ProdutoIsento("Clean Architecture", "descricao", 102.90, 2, cat2);

        // COMPOSIÇÃO DO ITEM PEDIDO
        ItemPedido iPedido1 = new ItemPedido(2899.99, 2, prod1, p1, "PROMOCAO");
        ItemPedido iPedido2 = new ItemPedido(100, 11, prod2, p2, "QUANTIDADE");

        System.out.println("Total produto "+ prod1.getId()+ ": " +calc.calcula(prod1));
        System.out.println("Total produto "+ prod2.getId()+ ": " +calc.calcula(prod2));

        System.out.println("Total Item pedido "+ iPedido1.getId()+ ": " +calc.calcula(iPedido1));
        System.out.println("Total Item pedido "+ iPedido2.getId()+ ": " +calc.calcula(iPedido2));
    }
}
