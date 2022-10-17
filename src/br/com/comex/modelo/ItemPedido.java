package br.com.comex.modelo;

public class ItemPedido implements CalculadoraValorTotal {
    private long id;
    private double preco;
    private int quantidade;
    private long produtoId;
    private long pedidoId;
    private double desconto;
    private TipoDesconto tipoDesconto = TipoDesconto.NENHUM;

    public double getDesconto() {
        return desconto;
    }public long getId() {
        return id;
    }public long getIdPedido() {
        return pedidoId;
    }public double getPreco() {
        return preco;
    }public long getProduto() {
        return produtoId;
    }public int getQuantidade() {
        return quantidade;
    }public TipoDesconto getTipoDesconto() {
        return tipoDesconto;
    }
    public ItemPedido(long id, double preco, int quantidade, long produtoId, long pedidoId, TipoDesconto tipoDesconto) {
        this.id = id;
        this.preco = preco;
        this.quantidade = quantidade;
        this.produtoId = produtoId;
        this.pedidoId = pedidoId;
        this.tipoDesconto = tipoDesconto;
        calcDesconto();
    }

    public void precoSdesconto(){
        System.out.println("Preço do pedido sem desconto: "+this.preco * this.quantidade);
    }
    private void calcDesconto(){
        if("PROMOCAO".equalsIgnoreCase(this.tipoDesconto.name())){
            this.desconto =  0.2;
        }
        else if("QUANTIDADE".equalsIgnoreCase(this.tipoDesconto.name()) && this.quantidade > 10){
            this.desconto = 0.1;
        }
        else{
            this.desconto = 0;
        }
    }
    public double totalCdesconto(){
        double total = this.preco * this.quantidade;
        System.out.println("Preço do pedido com desconto: "+ (total - total*this.desconto));
        return total;
    }
    public double calcula(){
        double total = this.getPreco() * this.getQuantidade();
        return total;
    }
    @Override
    public String toString() {
        return "Objeto da classe ItemPedido";
    }
}
