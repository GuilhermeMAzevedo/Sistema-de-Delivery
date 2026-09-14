package com.delivery.pagamento;

import com.delivery.enums.StatusPagamento;

public class Pagamento {
    private double valor;
    private StatusPagamento status;
    private PagamentoStrategy strategy;

    public Pagamento(double valor, PagamentoStrategy strategy){
        this.valor = valor;
        this.strategy = strategy;
        this.status = StatusPagamento.PENDENTE;
    }

    public double getValor() {
        return valor;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public boolean executar(){
        boolean sucesso = strategy.processar(valor);
        this.status = sucesso ? StatusPagamento.APROVADO : StatusPagamento.RECUSADO;
        return sucesso;
    }
}
