package com.delivery.model;

import com.delivery.enums.StatusEntrega;

public class Entrega {
    private final String id;
    private Endereco enderecoDestino;
    private StatusEntrega status;
    private Entregador entregador;
    private RastreamentoPedido rastreamento;

    public Entrega(String id, Endereco enderecoDestino){
        this.id = id;
        this.enderecoDestino = enderecoDestino;
        this.status = StatusEntrega.AGUARDANDO_COLETA;
        this.rastreamento = new RastreamentoPedido();
    }

    public String getId() {
        return id;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public RastreamentoPedido getRastreamento() {
        return rastreamento;
    }

    public void iniciar(){
        this.status = StatusEntrega.EM_TRANSITO;
    }

    public void finalizar(){
        this.status = StatusEntrega.ENTREGUE;
    }

    public void atribuirEntregador(Entregador entregador){
        this.entregador = entregador;
    }
}
