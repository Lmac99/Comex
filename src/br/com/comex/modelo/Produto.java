package br.com.comex.modelo;

import java.util.regex.Pattern;

public class Produto implements CalculadoraValorTotal {
    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;
    private Categoria categoria;
    private TipoProduto tipo = TipoProduto.NAO_ISENTO;

    public Produto(long idVirtual, String nome, String descricao, double preco, int quantidade, Categoria categoria, TipoProduto tipo){
        setNome(nome);
        setDescricao(descricao);
        setPreco(preco);
        setQuantidade(quantidade);
        setCategoria(categoria);
        setId(idVirtual);
        setTipo(tipo);
    }
    public Produto(long idVirtual, String nome, double preco, int quantidade, Categoria categoria, TipoProduto tipo){
        setNome(nome);
        setDescricao(" ");
        setPreco(preco);
        setQuantidade(quantidade);
        setCategoria(categoria);
        setId(idVirtual);
        setTipo(tipo);
    }
    public TipoProduto getTipo() {
        return tipo;
    }
    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }
    public Categoria getCategoria() {
        return categoria;
    }public String getDescricao() {
        return descricao;
    }public long getId() {
        return id;
    }public String getNome() {
        return nome;
    }public double getPreco() {
        return preco;
    }public int getQuantidade() {
        return quantidade;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }public void setDescricao(String descricao) {
        this.descricao = descricao;
    }public void setId(long id) {
        this.id = id;
    }public void setNome(String nome) {
        if((nome.length() < 6) || Pattern.matches("\\d.*",nome)){
            throw new IllegalArgumentException("Nome inválido, número de caracteres menor que 6 ou começando com dígitos");
        }
        this.nome = nome;
    }public void setPreco(double preco) {
        if(preco < 1){
            throw new IllegalArgumentException("Preço inválido, zero ou menor");
        }
        this.preco = preco;
    }public void setQuantidade(int quantidade) {
        if(quantidade < 1){
            throw new IllegalArgumentException("Quantidade de estoque inválida, zero ou menor");
        }
        this.quantidade = quantidade;
    }

    public double calcValorEstoque(){
        double valorEstoque = this.quantidade * this.preco;
        System.out.println("O valor do produto em estoque é: "+ valorEstoque);
        return valorEstoque;
    }
    public double calcImposto(){
        double imposto = this.preco * 0.4;
        System.out.println("O valor do imposto sobre o produto é: "+ imposto);
        return imposto;
    }
    public double calcula(){
        double total = this.getPreco() * this.getQuantidade();
        return total;
    }
    @Override
    public String toString() {
        String outS = "Objeto da classe Produto Com as informações: ID: %s -- Nome: %s -- Descricao: %s --\nPreco: %s -- Quantidade: %s -- ID categoria: %s -- Tipo: %s";
        System.out.println(String.format(outS, this.id, this.nome, this.descricao, this.preco, this.quantidade, this.categoria, this.tipo));
        return "";
    }
}
