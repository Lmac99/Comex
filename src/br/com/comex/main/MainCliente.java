package br.com.comex.main;

import br.com.comex.modelo.*;
public class MainCliente {
    public static void main(String[] args) {
        String outS = "ID - %s *** NOME - %s *** CPF - %s *** TELEFONE - %s *** RUA - %s *** NUMERO - %s *** COMPLEMENTO - %s *** BAIRRO - %s *** CIDADE - %s *** ESTADO - %s";
        Cliente cli1 = new Cliente(1, "Ana Paula", "000.000.000-00","(00) 0 0000-0000", "Rua ali", "42", "", "bairro paz", "São Paulo", EstadoClienteSigla.SP);

        System.out.println(cli1.toString());

        System.out.println(String.format(outS, 
        cli1.getId(), cli1.getNome(), cli1.getCpf(), cli1.getTelefone(), cli1.getRua(), cli1.getNumero(), cli1.getComplemento(), cli1.getBairro(), cli1.getCidade(), cli1.getEstado()));
    }
}
