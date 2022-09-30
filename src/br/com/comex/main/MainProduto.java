package br.com.comex.main;
import br.com.comex.modelo.*;

public class MainProduto {
    public static void main(String[] args) {
        //-------------------------
        Categoria cat1 = new Categoria(1,"INFORMÁTICA", "ativa");
        Categoria cat2 = new Categoria(2,"LIVROS", "inativa");
        //-------------------------
        //-------------------------
        Produto prod1 = new Produto(1,"Notebook Samsung", 3523.00, 1, cat1);
        Produto prod2 = new ProdutoIsento(2,"Clean Architecture", "descricao", 102.90, 2, cat2);
        Produto prod3 = new Produto(3,"Monitor Dell 27", "descricao", 1889.00, 3, cat1);
        //-------------------------
        //-------------------------
        Produto prod4 = new Produto(5,"Notebook Samsung", "descricao", 3523.00, 1, cat1); // id inválido
        Produto prod5 = new ProdutoIsento(5,"Clea", "descricao", 102.90, 2, cat2); // nome inválido
        Produto prod6 = new Produto(6,"Monitor Dell 27", "descricao", 0.00, 3, cat1); // preço inválido
        Produto prod7 = new Produto(7,"Monitor Dell 27", "descricao", 10.00, 0, cat1); // quantidade inválida


        System.out.println(prod1.toString());

        imprimirInfo(prod1);
        imprimirInfo(prod2);
        imprimirInfo(prod3);
        imprimirInfo(prod4);
        imprimirInfo(prod5);
        imprimirInfo(prod6);
        imprimirInfo(prod7);
    }

    public static void imprimirInfo(Produto p){
        String outS = "*****************\nO produto %s de id: %s faz parte da categoria: %s. Atualmente existem %s em estoque, com valor de %s. Mais informações....%s";
        System.out.println(String.format(outS, p.getNome(), p.getId(), p.getCategoria(), p.getQuantidade(),p.getPreco(), p.getDescricao()));
        p.calcValorEstoque();
        p.calcImposto();
        System.out.println("*****************\n");
    }
}
