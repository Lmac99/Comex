public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;
    private String categoria;

    public Produto(int id, String nome, String descricao, double preco, int quantidade, String categoria){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }public String getDescricao() {
        return descricao;
    }public int getId() {
        return id;
    }public String getNome() {
        return nome;
    }public double getPreco() {
        return preco;
    }public int getQuantidade() {
        return quantidade;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }public void setDescricao(String descricao) {
        this.descricao = descricao;
    }public void setId(int id) {
        this.id = id;
    }public void setNome(String nome) {
        this.nome = nome;
    }public void setPreco(double preco) {
        this.preco = preco;
    }public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void calcValorEstoque(){
        System.out.println("O valor do produto em estoque é: "+ this.quantidade * this.preco);
    }
    public void calcImposto(){
        System.out.println("O valor do imposto sobre o produto é: "+ this.preco * 0.4);
    }
}
