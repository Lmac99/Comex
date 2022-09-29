package br.com.comex.main;
import br.com.comex.modelo.*;
public class MainCliente {
    public static void main(String[] args) {
        String outS = "ID - %s *** NOME - %s *** CPF - %s *** TELEFONE - %s *** RUA - %s *** NUMERO - %s *** COMPLEMENTO - %s *** BAIRRO - %s *** CIDADE - %s *** ESTADO - %s";
        Cliente cli1 = new Cliente("Ana", "001", "11 9 99999999", "Rua A", "12", "Apt 2", "Bairro A", "São Paulo", "São Paulo");
        Cliente cli2 = new Cliente("Eli", "002", "48 9 88888888", "Rua Azul", "N/S", "N/S", "Bairro Cinza", "Florianópolis", "Santa Catarina");
        Cliente cli3 = new Cliente("Gabi", "003", "65 9 77777777", "Rua Mar", "56", "N/S", "Bairro Peixe", "Fortaleza", "Ceará");

        System.out.println(String.format(outS, 
        cli1.getId(), cli1.getNome(), cli1.getCpf(), cli1.getTelefone(), cli1.getRua(), cli1.getNumero(), cli1.getComplemento(), cli1.getBairro(), cli1.getCidade(), cli1.getEstado()));

        System.out.println(String.format(outS, 
        cli2.getId(), cli2.getNome(), cli2.getCpf(), cli2.getTelefone(), cli2.getRua(), cli2.getNumero(), cli2.getComplemento(), cli2.getBairro(), cli2.getCidade(), cli2.getEstado()));

        System.out.println(String.format(outS, 
        cli3.getId(), cli3.getNome(), cli3.getCpf(), cli3.getTelefone(), cli3.getRua(), cli3.getNumero(), cli3.getComplemento(), cli3.getBairro(), cli3.getCidade(), cli3.getEstado()));
    }
}
