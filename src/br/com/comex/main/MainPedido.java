package br.com.comex.main;
import br.com.comex.modelo.*;
import java.text.SimpleDateFormat;

public class MainPedido {
    public static void main(String[] args) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        Cliente cli1 = new Cliente(1,"Ana Paula", "000.000.000-00", "(11) 9 9999-9999", "Rua Ali", "12", "Apt 2", "Bairro A", "São Paulo", EstadoClienteSigla.SP);

        String outS = "Na data: [%s] o cliente [%s] fez um pedido do tipo [%s]";
        Pedido p1 = new Pedido(cli1);

        System.out.println(p1.toString());

        System.out.println(String.format(outS, formatador.format(p1.getData()), p1.getCliente().getNome(), p1.getId()));
    }
}
