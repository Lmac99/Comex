import java.util.Date;

public class Pedido {
    private int id;
    private Date data = new Date();
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }public Date getData() {
        return data;
    }public int getId() {
        return id;
    }
    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }
}
