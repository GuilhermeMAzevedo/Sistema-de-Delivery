package com.delivery.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private final String id;
    private String nome;
    private String cnpj;
    private List<Produto> cardapio;

    public Restaurante(String id, String nome, String cnpj){
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cardapio = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<Produto> getCardapio(){
        return List.copyOf(cardapio);
    }

    public void adicionarProduto(Produto produto){
        cardapio.add(produto);
    }

    public void removerProduto(Produto produto){
        cardapio.remove(produto);
    }
}