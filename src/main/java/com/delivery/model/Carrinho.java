package com.delivery.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItemCarrinho> itens;

    public Carrinho(){
        this.itens = new ArrayList<>();
    }

    public List<ItemCarrinho> getItens(){
        return List.copyOf(itens);
    }

    public void adicionarAoCarrinho(Produto produto, int quantidade){
        for (ItemCarrinho item : itens){
            if (item.getProduto().equals(produto)){
                item.incrementarQuantidade(quantidade);
                return;
            }
        }
        itens.add(new ItemCarrinho(produto,quantidade));
    }

    public void removerDoCarrinho(Produto produto){
        for (ItemCarrinho item : itens){
            if (item.getProduto().equals(produto)){
                itens.remove(item);
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
}
