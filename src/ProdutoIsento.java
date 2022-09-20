public class ProdutoIsento extends Produto{
    public ProdutoIsento(String nome, String descricao, double preco, int quantidade, String categoria){
        super(nome, descricao, preco, quantidade, categoria);
    }

    @Override
    public void calcImposto() {
        System.out.println("O produto é isento de imposto");
    }
}
