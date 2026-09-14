package com.delivery.model;

public class ItemCarrinho {
    private Produto produto;
    private int quantidade;

    public ItemCarrinho(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto(){
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double subtotal(){
        return quantidade * produto.getPreco();
    }

    public void incrementarQuantidade(int quantidadeAdicional){
        if (quantidadeAdicional <= 0){
            throw new IllegalArgumentException("Quantidade deve ser positiva.");
        }
        this.quantidade += quantidadeAdicional;
    }
}
