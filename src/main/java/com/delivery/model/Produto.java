package com.delivery.model;

public class Produto {
    private String id;
    private String nome;
    private double preco;
    private boolean disponivel;

    public Produto(String id, String nome, double preco, boolean disponivel){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void adicionarAoCardapio(){

    }

    public void removerDoCardapio(){

    }
}
