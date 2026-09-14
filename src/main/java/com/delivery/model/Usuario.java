package main.java.com.delivery.model;

public abstract class Usuario {
    protected final String id;
    protected String nome;

    public Usuario(String id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
