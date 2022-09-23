public class CalculadoraValorTotal {
    public double calcula(Produto prod){
        double total = prod.getPreco() * prod.getQuantidade();
        return total;
    }
    public double calcula(ItemPedido iPedido){
        double total = iPedido.getPreco() * iPedido.getQuantidade();
        return total;
    }
}
