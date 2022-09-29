package br.com.comex.modelo;

import java.util.Objects;

public class Categoria {
    private static long count = 0;
    private long id;
    private String nome;
    private String status;

    public Categoria(long id, String nome, String status){
        setStatus(status);
        if((id != ++count || id == 0)){
            throw new IllegalArgumentException("Id diferente do próximo ou igual a zero");
        }
        else if(nome.length() < 4){
            throw new IllegalArgumentException("Nome com menos de 4 caracteres");
        }
        this.nome = nome;
        this.id = count;
    }

    /*public Categoria(String nome, String status){
        this.nome = nome;
        setStatus(status);
        this.id = ++count;
    }
    public Categoria(String nome){
        this(nome, "ativa");
    }*/
    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getStatus() {
        return status;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setStatus(String status) {
        if(Objects.equals(status, "ativa") || Objects.equals(status, "inativa")){
            this.status =  status;
        }
        else{
            throw new IllegalArgumentException("Status inválido, são aceitos apenas valores: ativa/inativa");
        }
    }
}
