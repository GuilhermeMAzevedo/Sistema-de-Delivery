package com.delivery.promocao;

import com.delivery.model.Carrinho;

import java.time.LocalDateTime;

public class PromocaoPercentual extends Promocao {
    private double percentualDesconto;
    public PromocaoPercentual(String codigo, LocalDateTime validade, double percentualDesconto){
        super(codigo, validade);
        if (percentualDesconto <= 0.0 || percentualDesconto > 100.0){
            throw new IllegalArgumentException("Percentual deve estar entre 0 a 100.");
        }
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public double aplicar(Carrinho carrinho) {
        double total = carrinho.calcularTotal();
        if (!isValida()){
            return total;
        }
        double desconto = total * (percentualDesconto / 100.0);
        return total - desconto;
    }
}
