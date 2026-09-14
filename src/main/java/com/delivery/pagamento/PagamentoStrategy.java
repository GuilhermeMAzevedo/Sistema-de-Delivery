package com.delivery.pagamento;

public interface PagamentoStrategy {
    boolean processar(double valor);
}
