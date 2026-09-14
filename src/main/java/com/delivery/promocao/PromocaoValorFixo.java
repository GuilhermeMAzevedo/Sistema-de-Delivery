package com.delivery.promocao;

import com.delivery.model.Carrinho;
import java.time.LocalDateTime;

public class PromocaoValorFixo extends Promocao{
    private double valorDesconto;

    public PromocaoValorFixo(String codigo, LocalDateTime validade, double valorDesconto){
        super(codigo, validade);
        if (valorDesconto <= 0){
            throw new IllegalArgumentException("O valor do desconto deve ser positivo.");
        }
    }

    @Override
    public double aplicar(Carrinho carrinho) {
        double total = carrinho.calcularTotal();
        if (!isValida()){
            return total;
        }
        return Math.max(total - valorDesconto, 0.0);
    }
}
