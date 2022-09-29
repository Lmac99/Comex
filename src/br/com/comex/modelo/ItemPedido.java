package br.com.comex.modelo;

import java.util.Objects;

public class ItemPedido implements CalculadoraValorTotal {
    private static int count = 0;
    private int id;
    private double preco;
    private int quantidade;
    private Produto produto;
    private Pedido idPedido;
    private double desconto;
    private String tipoDesconto;

    public double getDesconto() {
        return desconto;
    }public int getId() {
        return id;
    }public Pedido getIdPedido() {
        return idPedido;
    }public double getPreco() {
        return preco;
    }public Produto getProduto() {
        return produto;
    }public int getQuantidade() {
        return quantidade;
    }public String getTipoDesconto() {
        return tipoDesconto;
    }
    public ItemPedido(double preco, int quantidade, Produto produto, Pedido idPedido, String tipoDesconto) {
        this.preco = preco;
        this.quantidade = quantidade;
        this.produto = produto;
        this.idPedido = idPedido;
        this.tipoDesconto = tipoDesconto;
        this.id = ++count;
        calcDesconto();
    }

    public void precoSdesconto(){
        System.out.println("Preço do pedido sem desconto: "+this.preco * this.quantidade);
    }
    private void calcDesconto(){
        if(Objects.equals(this.tipoDesconto, "PROMOCAO")){
            this.desconto =  0.2;
        }
        else if(Objects.equals(this.tipoDesconto, "QUANTIDADE") && this.quantidade > 10){
            this.desconto = 0.1;
        }
        else{
            this.desconto = 0;
        }
    }
    public void totalCdesconto(){
        double total = this.preco * this.quantidade;
        System.out.println("Preço do pedido com desconto: "+ (total - total*this.desconto));
    }
    public double calcula(){
        double total = this.getPreco() * this.getQuantidade();
        return total;
    }
}
