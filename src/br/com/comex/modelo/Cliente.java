package br.com.comex.modelo;

import java.util.regex.Pattern;

public class Cliente {
    private static int count = 0;
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
        this.complemento = complemento;
        setBairro(bairro);
        setCidade(cidade);
        setEstado(estado);
    }
    public Cliente(long id, String nome, String cpf, String rua, String numero, String complemento, String bairro, String cidade, EstadoClienteSigla estado){
        this(id, nome, cpf, "",rua, numero, complemento, bairro, cidade, estado);
    }
    public Cliente(long id, String nome, String cpf, String rua, String numero, String bairro, String cidade, EstadoClienteSigla estado){
        this(id, nome, cpf, "",rua, numero, "", bairro, cidade, estado);
    }
    
    public void setId(long id) {
        if((id != ++count || id == 0)){
            throw new ComexException("Id diferente do próximo ou igual a zero");
        }
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
        if(((telefone.length() < 11 || telefone.length() > 16) || !(Pattern.matches("^[(][0-9]{2}[)]?[ X][0-9]{1}[ X][0-9]{4}-[0-9]{4}", telefone))) && !telefone.isEmpty()){
            throw new IllegalArgumentException("Telefone de tamanho inválido");
        }
        this.telefone = telefone;
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
        this.complemento = complemento;
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
        System.out.println(estado.name().length());
        if(estado.name().length() != 2){
            throw new IllegalArgumentException("Número inválido, diferente de 2");
        }
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "Objeto da classe Cliente";
    }
    
}
