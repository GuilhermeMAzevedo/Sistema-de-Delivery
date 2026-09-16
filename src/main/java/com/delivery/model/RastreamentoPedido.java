package com.delivery.model;

import java.util.List;
import java.util.ArrayList;

public class RastreamentoPedido {
    private List<PosicaoGPS> historico;

    public RastreamentoPedido(){
        this.historico = new ArrayList<>();
    }

    public void atualizarPosicao(PosicaoGPS posicao){
        historico.add(posicao);
    }

    public List<PosicaoGPS> getHistorico(){
        return List.copyOf(historico);
    }
}
