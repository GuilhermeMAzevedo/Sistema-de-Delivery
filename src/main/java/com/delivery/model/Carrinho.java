package com.delivery.model;

import com.delivery.datastructure.ListaEncadeadaDupla;

public class Carrinho {
    private ListaEncadeadaDupla<ItemCarrinho> itens;
    public Carrinho(){
        this.itens = new ListaEncadeadaDupla<>();
    }

    public void adicionarAoCarrinho(Produto produto, int quantidade){
        for (ItemCarrinho item : itens){
            if (item.getProduto().equals(produto)){
                item.incrementarQuantidade(quantidade);
                return;
            }
        }
        itens.inserirFinal(new ItemCarrinho(produto,quantidade));
    }

    public void removerDoCarrinho(Produto produto){
        for (ItemCarrinho item : itens){
            if (item.getProduto().equals(produto)){
                itens.remover(itens.buscar(item));
            }
        }
    }

    public double calcularTotal(){
        double total = 0;
        for (ItemCarrinho item : itens){
            total += item.subtotal();
        }
        return total;
    }

    public ListaEncadeadaDupla<ItemCarrinho> getItens(){
        return itens;
    }
}
