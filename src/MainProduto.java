public class MainProduto {
    public static void main(String[] args) {
        
        Produto prod1 = new Produto(1, "Notebook Samsung", "descricao", 3523.00, 1, "Informática");
        //Produto prod2 = new Produto(2, "Clean Architecture", "descricao", 102.90, 2, "Livros"); <- exercício de criar o produto
        Produto prod2 = new ProdutoIsento(2, "Clean Architecture", "descricao", 102.90, 2, "Livros");
        Produto prod3 = new Produto(3, "Monitor Dell 27", "descricao", 1889.00, 3, "Informática");

        imprimirInfo(prod1);
        imprimirInfo(prod2);
        imprimirInfo(prod3);
    }

    public static void imprimirInfo(Produto p){
        String outS = "*****************\nO produto %s de id: %s faz parte da categoria: %s. Atualmente existem %s em estoque, com valor de %s. Mais informações....%s";
        System.out.println(String.format(outS, p.getNome(), p.getId(), p.getCategoria(), p.getQuantidade(),p.getPreco(), p.getDescricao()));
        p.calcValorEstoque();
        p.calcImposto();
        System.out.println("*****************\n");
    }
}
