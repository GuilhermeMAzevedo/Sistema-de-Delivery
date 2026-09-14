package com.delivery.model;

public class Produto {
    private final String id;
    private String nome;
    private double preco;
    private boolean disponivel;

    public Produto(String id, String nome, double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.disponivel = true;
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

    public void adicionarAoCardapio(){
        this.disponivel = true;
    }

    public void removerDoCardapio(){
        this.disponivel = false;
    }

    public void alterarPreco(double novoPreco){
        if (novoPreco < 0){
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        this.preco = novoPreco;
    }
}
