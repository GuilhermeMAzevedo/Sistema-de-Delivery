package com.delivery.model;

import com.delivery.enums.StatusPedido;
import com.delivery.pagamento.Pagamento;

public class Pedido {
    private final String id;
    private StatusPedido status;
    private double valorTotal;
    private Cliente cliente;
    private Pagamento pagamento;
    private Entrega entrega;

    public Pedido(String id, Cliente cliente, double valorTotal){
        this.id = id;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.status = StatusPedido.PENDENTE;
    }

    public String getId() {
        return id;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void confirmar(){
        this.status = StatusPedido.CONFIRMADO;
    }

    public void cancelar(){
        this.status = StatusPedido.CANCELADO;
    }

    public void definirPagamento(Pagamento pagamento){
        this.pagamento = pagamento;
    }

    public void definirEntrega(Entrega entrega){
        this.entrega = entrega;
    }


}
