package br.com.comex.modelo;

import java.util.Date;

public class Pedido {
    private static int count = 0;
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
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.id = ++count;
    }
    @Override
    public String toString() {
        return "Objeto da classe Pedido";
    }
}
