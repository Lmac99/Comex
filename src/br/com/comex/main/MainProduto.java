package br.com.comex.main;
import br.com.comex.modelo.*;

public class MainProduto {
    public static void main(String[] args) {
        Categoria cat1 = new Categoria(1,"INFORMÁTICA", "ativa");
        Categoria cat2 = new Categoria(2,"LIVROS", "inativa");
        Produto prod1 = new Produto("Notebook Samsung", "descricao", 3523.00, 1, cat1);
        //Produto prod2 = new Produto(2, "Clean Architecture", "descricao", 102.90, 2, "Livros"); <- exercício de criar o produto
        Produto prod2 = new ProdutoIsento("Clean Architecture", "descricao", 102.90, 2, cat2);
        Produto prod3 = new Produto("Monitor Dell 27", "descricao", 1889.00, 3, cat1);

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
