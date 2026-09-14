package com.delivery.pagamento;

public class PagamentoDinheiro implements PagamentoStrategy{
    private static final double LIMITE_DINHEIRO = 200.0;

    @Override
    public boolean processar(double valor) {
        if (valor <= 0){
            return false;
        }

        return valor <= LIMITE_DINHEIRO;
    }
}
