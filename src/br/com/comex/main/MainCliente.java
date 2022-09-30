package br.com.comex.main;

import br.com.comex.modelo.*;
public class MainCliente {
    public static void main(String[] args) {
        String outS = "ID - %s *** NOME - %s *** CPF - %s *** TELEFONE - %s *** RUA - %s *** NUMERO - %s *** COMPLEMENTO - %s *** BAIRRO - %s *** CIDADE - %s *** ESTADO - %s";
        Cliente cli1 = new Cliente(1, "Ana Paula", "000.000.000-00","(00) 0 0000-0000", "Rua ali", "42", "", "bairro paz", "São Paulo", EstadoClienteSigla.SP);
        Cliente cli2 = new Cliente(2,"Eli Maria", "11111111111", "48 9 88888888", "Rua Azul", "N/S", "N/S", "Bairro Cinza", "Florianópolis", EstadoClienteSigla.SC);
        Cliente cli3 = new Cliente(5,"Gabi", "222", "65 9 77777777777", "Rua", "5", "N/S", "Bairro Peixe", "Fort", EstadoClienteSigla.CE);

        System.out.println(cli1.toString());

        System.out.println(String.format(outS, 
        cli1.getId(), cli1.getNome(), cli1.getCpf(), cli1.getTelefone(), cli1.getRua(), cli1.getNumero(), cli1.getComplemento(), cli1.getBairro(), cli1.getCidade(), cli1.getEstado()));

        System.out.println(String.format(outS, cli2.getId(), cli2.getNome(), cli2.getCpf(), cli2.getTelefone(), cli2.getRua(), cli2.getNumero(), cli2.getComplemento(), cli2.getBairro(), cli2.getCidade(), cli2.getEstado()));

        System.out.println(String.format(outS, cli3.getId(), cli3.getNome(), cli3.getCpf(), cli3.getTelefone(), cli3.getRua(), cli3.getNumero(), cli3.getComplemento(), cli3.getBairro(), cli3.getCidade(), cli3.getEstado()));
    }
}
