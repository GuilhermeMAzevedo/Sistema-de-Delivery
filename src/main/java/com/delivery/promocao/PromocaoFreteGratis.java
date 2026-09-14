package com.delivery.promocao;

import com.delivery.model.Carrinho;

import java.time.LocalDateTime;

public class PromocaoFreteGratis extends Promocao{
    private static final double VALOR_FRETE_SIMULADO = 10.0;

    public PromocaoFreteGratis(String codigo, LocalDateTime validade){
        super(codigo, validade);
    }

    @Override
    public double aplicar(Carrinho carrinho) {
        double total = carrinho.calcularTotal();
        if (!isValida()){
            return total;
        }
        return Math.max(total - VALOR_FRETE_SIMULADO, 0.0);
    }
}
