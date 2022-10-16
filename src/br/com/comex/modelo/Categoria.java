package br.com.comex.modelo;

import java.util.Objects;

public class Categoria {
    private static long count = 0;
    private long id;
    private String nome;
    private StatusCategoria status = StatusCategoria.ATIVA;

    public Categoria(long id, String nome, StatusCategoria status){
        setStatus(status);
        setNome(nome);
        setId(id);
        
    }
    public Categoria(String nome, StatusCategoria status){
        setStatus(status);
        setNome(nome);
        this.id = ++count;
    }
    public Categoria(String nome){
        setNome(nome);
        this.id = ++count;
    }
    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public StatusCategoria getStatus() {
        return status;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        if((nome.length() < 4) || (Character.isDigit(nome.charAt(0)))){
            throw new ComexException("Nome com menos de 4 caracteres ou começando com número");
        }
        this.nome = nome;
    }
    public void setStatus(StatusCategoria status) {
        if(Objects.isNull(status)){
            throw new ComexException("Valor nulo");
        }
        switch (status){
            case ATIVA: case INATIVA:
                this.status = status;
        }
    }
    @Override
    public String toString() {
        return "Objeto da classe Categoria com as informações...id: "+this.id+" nome: "+this.nome+" status: "+this.status;
    }
}
