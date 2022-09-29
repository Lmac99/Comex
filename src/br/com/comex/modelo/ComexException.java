package br.com.comex.modelo;

public class ComexException extends RuntimeException{
    public ComexException() {
    }
    
    public ComexException(String message) {
        super(message);
    }
    
}
