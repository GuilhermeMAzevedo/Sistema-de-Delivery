package com.delivery.pagamento;

public class PagamentoCartao implements PagamentoStrategy{
    @Override
    public boolean processar(double valor) {
        return valor > 0;
    }
}
