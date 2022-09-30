package br.com.comex.modelo;

import java.util.regex.Pattern;

public class Produto implements CalculadoraValorTotal {
    private static long count = 0;
    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;
    private Categoria categoria;

    public Produto(long idVirtual, String nome, String descricao, double preco, int quantidade, Categoria categoria){
        setNome(nome);
        this.descricao = descricao;
        setPreco(preco);
        setQuantidade(quantidade);
        setCategoria(categoria);
        setId(idVirtual);
    }
    public Produto(long idVirtual, String nome, double preco, int quantidade, Categoria categoria){
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setCategoria(categoria);
        setId(idVirtual);
    }

    public String getCategoria() {
        return categoria.getNome();
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
        if((id != ++count || id == 0)){
            throw new IllegalArgumentException("Id diferente do próximo ou igual a zero");
        }
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

    public void calcValorEstoque(){
        System.out.println("O valor do produto em estoque é: "+ this.quantidade * this.preco);
    }
    public void calcImposto(){
        System.out.println("O valor do imposto sobre o produto é: "+ this.preco * 0.4);
    }
    public double calcula(){
        double total = this.getPreco() * this.getQuantidade();
        return total;
    }
    @Override
    public String toString() {
        return "Objeto da classe Categoria Produto";
    }
}
