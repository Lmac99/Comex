import java.text.SimpleDateFormat;

public class MainPedido {
    public static void main(String[] args) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        Cliente cli1 = new Cliente("Ana", "001", "11 9 99999999", "Rua A", "12", "Apt 2", "Bairro A", "São Paulo", "São Paulo");
        Cliente cli2 = new Cliente("Eli", "002", "48 9 88888888", "Rua Azul", "N/S", "N/S", "Bairro Cinza", "Florianópolis", "Santa Catarina");
        Cliente cli3 = new Cliente("Gabi", "003", "65 9 77777777", "Rua Mar", "56", "N/S", "Bairro Peixe", "Fortaleza", "Ceará");

        String outS = "Na data: [%s] o cliente [%s] fez um pedido do tipo [%s]";
        Pedido p1 = new Pedido(cli1);
        Pedido p2 = new Pedido(cli2);
        Pedido p3 = new Pedido(cli3);

        System.out.println(String.format(outS, formatador.format(p1.getData()), p1.getCliente().getNome(), p1.getId()));
        System.out.println(String.format(outS, formatador.format(p2.getData()), p2.getCliente().getNome(), p2.getId()));
        System.out.println(String.format(outS, formatador.format(p3.getData()), p3.getCliente().getNome(), p3.getId()));
    }
}
