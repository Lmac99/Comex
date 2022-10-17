package br.com.comex.modelo;

import java.util.Date;

public class Pedido {
    private long id;
    private Date data;
    private long clienteId;

    public Pedido(long id, Date data, long cliente) {
        this.clienteId = cliente;
        this.data = data;
        this.id = id;
    }
    public Pedido(long id, long cliente) {
        this.clienteId = cliente;
        this.data = new Date();
        this.id = id;
    }
    
    public long getClienteId() {
        return clienteId;
    }public Date getData() {
        return data;
    }public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }public void setData(Date data) {
        this.data = data;
    }public void setClienteId(long cliente) {
        this.clienteId = cliente;
    }

    @Override
    public String toString() {
        return "Objeto da classe Pedido com as informações...id: "+this.id+" Data do pedido: "+this.data+" Id do cliente: "+this.clienteId;
    }
}
