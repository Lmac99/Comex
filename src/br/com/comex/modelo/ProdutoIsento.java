package br.com.comex.modelo;

public class ProdutoIsento extends Produto{
    public ProdutoIsento(long idVirtual, String nome, String descricao, double preco, int quantidade, Categoria categoria){
        super(idVirtual, nome, descricao, preco, quantidade, categoria, TipoProduto.ISENTO);
    }
    public ProdutoIsento(long idVirtual, String nome, double preco, int quantidade, Categoria categoria){
        super(idVirtual, nome, preco, quantidade, categoria,TipoProduto.ISENTO);
    }

    @Override
    public double calcImposto() {
        System.out.println("O produto é isento de imposto");
        return 0;
    }
    @Override
    public String toString() {
        return "Objeto da classe Categoria Produto isento";
    }
}
