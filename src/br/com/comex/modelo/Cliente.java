package br.com.comex.modelo;

import java.util.regex.Pattern;

public class Cliente {
    private long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private EstadoClienteSigla estado;

    public String getBairro() {
        return bairro;
    }public String getCidade() {
        return cidade;
    }public String getComplemento() {
        return complemento;
    }public String getCpf() {
        return cpf;
    }public EstadoClienteSigla getEstado() {
        return estado;
    }public long getId() {
        return id;
    }public String getNome() {
        return nome;
    }public String getNumero() {
        return numero;
    }public String getRua() {
        return rua;
    }public String getTelefone() {
        return telefone;
    }
    public Cliente(long id, String nome, String cpf, String telefone, String rua, String numero, String complemento, String bairro, String cidade, EstadoClienteSigla estado) {
        setId(id);
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
        setRua(rua);
        setNumero(numero);
        setComplemento(complemento);
        setBairro(bairro);
        setCidade(cidade);
        setEstado(estado);
    }
    public Cliente(long id, String nome, String cpf, String rua, String numero, String complemento, String bairro, String cidade, EstadoClienteSigla estado){
        this(id, nome, cpf, "(00) 0 0000-0000",rua, numero, complemento, bairro, cidade, estado);
    }
    public Cliente(long id, String nome, String cpf, String rua, String numero, String bairro, String cidade, EstadoClienteSigla estado){
        this(id, nome, cpf, "(00) 0 0000-0000",rua, numero, "", bairro, cidade, estado);
    }public Cliente(){}
    
    public void setId(long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        if(nome.length() < 6 || Pattern.matches("\\d.*",nome)){
            throw new IllegalArgumentException("Nome com menos de 6 caracteres");
        }
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        if((cpf.length() < 11 || cpf.length() > 14) || !Pattern.matches("[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}-?[0-9]{2}", cpf)){
            throw new IllegalArgumentException("CPF de tamanho inválido ou com formatação inválida");
        }
        this.cpf = cpf;
    }
    public void setTelefone(String telefone) {
        System.out.println("telefone "+ telefone);
        if(telefone.equals("?")){
            this.telefone = "(00) 0 0000-0000";
        }
        else if(((telefone.length() < 11 || telefone.length() > 16) || !(Pattern.matches("^[(][0-9]{2}[)]?[ X][0-9]{1}[ X][0-9]{4}-[0-9]{4}", telefone))) && !telefone.isEmpty()){
            throw new IllegalArgumentException("Telefone de tamanho inválido");
        }
        else{
            this.telefone = telefone;
        }
    }
    public void setRua(String rua) {
        if(rua.length() < 6){
            throw new IllegalArgumentException("Rua com menos de 6 caracteres");
        }
        this.rua = rua;
    }
    public void setNumero(String numero) {
        if(numero.length() < 2){
            throw new IllegalArgumentException("Número inválido, 1 ou menos caracteres");
        }
        this.numero = numero;
    }
    public void setComplemento(String complemento) {
        
        if(complemento.equals("?")){
            this.complemento = "";
        }
        else{
            this.complemento = complemento;
        }
    }
    public void setBairro(String bairro) {
        if(bairro.length() < 2){
            throw new IllegalArgumentException("Tamanho inválido, 1 ou menos caracteres");
        }
        this.bairro = bairro;
    }
    public void setCidade(String cidade) {
        if(cidade.length() < 2){
            throw new IllegalArgumentException("Número inválido, 1 ou menos caracteres");
        }
        this.cidade = cidade;
    }
    public void setEstado(EstadoClienteSigla estado) {
        if(estado.name().length() != 2){
            throw new IllegalArgumentException("Número inválido, diferente de 2");
        }
        this.estado = estado;
    }
    @Override
    public String toString() {
        String outS = "Objeto da classe Cliente Com as informações: ID: %s -- Nome: %s -- Cpf: %s --\nTelefone: %s -- Rua: %s -- Numero: %s -- Complemento: %s\nBairro: %s -- Cidade: %s -- UF: %s";
        System.out.println(String.format(outS, this.id, this.nome, this.cpf, this.telefone, this.rua, this.numero, this.complemento, this.bairro, this.cidade, this.estado));
        return "";
    }
    
}
