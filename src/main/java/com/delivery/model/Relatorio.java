package com.delivery.model;

import java.time.LocalDateTime;
import java.util.Map;

public class Relatorio {
    private LocalDateTime periodo;
    private Map<String, Object> dados;

    public Relatorio(LocalDateTime periodo, Map<String, Object> dados){
        this.periodo = periodo;
        this.dados = dados;
    }

    public LocalDateTime getPeriodo() {
        return periodo;
    }

    public Map<String, Object> getDados() {
        return dados;
    }
}
