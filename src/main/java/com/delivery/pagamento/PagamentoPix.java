package com.delivery.pagamento;

public class PagamentoPix implements PagamentoStrategy{

    @Override
    public boolean processar(double valor) {
        return valor > 0;
    }
}
