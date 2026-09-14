package com.delivery.model;

import com.delivery.datastructure.ListaEncadeadaDupla;

public class RastreamentoPedido {
    private ListaEncadeadaDupla<PosicaoGPS> historico;

    public RastreamentoPedido(){
        this.historico = new ListaEncadeadaDupla<>();
    }

    public void atualizarPosicao(PosicaoGPS posicao){
        historico.inserirFinal(posicao);
    }

    public ListaEncadeadaDupla<PosicaoGPS> getHistorico(){
        return historico;
    }
}
