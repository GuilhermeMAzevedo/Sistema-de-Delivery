package com.delivery.model;

import com.delivery.datastructure.ListaEncadeadaDupla;

public class Restaurante {
    private String id;
    private String nome;
    private String cnpj;
    private ListaEncadeadaDupla<Produto> cardapio;

    public Restaurante(String id, String nome, String cnpj){
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cardapio = new ListaEncadeadaDupla<>();
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

    public void adicionarProduto(Produto produto){
        cardapio.inserirFinal(produto);
    }

    public void removerProduto(Produto produto){
        cardapio.remover(cardapio.buscar(produto));
    }

    public ListaEncadeadaDupla<Produto> getCardapio(){
        return cardapio;
    }
}