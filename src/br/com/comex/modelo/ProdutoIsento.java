package br.com.comex.modelo;

public class ProdutoIsento extends Produto{
    public ProdutoIsento(long id, String nome, String descricao, double preco, int quantidade, Categoria categoria){
        super(id, nome, descricao, preco, quantidade, categoria);
    }
    public ProdutoIsento(long id, String nome, double preco, int quantidade, Categoria categoria){
        super(id, nome, preco, quantidade, categoria);
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
