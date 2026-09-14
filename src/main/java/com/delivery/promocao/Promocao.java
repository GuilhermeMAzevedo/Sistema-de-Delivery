package com.delivery.promocao;

import com.delivery.model.Carrinho;
import java.time.LocalDateTime;

public abstract class Promocao {
    protected String codigo;
    protected LocalDateTime validade;
    public Promocao(String codigo, LocalDateTime validade){
        this.codigo = codigo;
        this.validade = validade;
    }

    public boolean isValida(){
        return LocalDateTime.now().isBefore(validade);
    }

    public abstract double aplicar(Carrinho carrinho);

    public String getCodigo() {
        return codigo;
    }

    public LocalDateTime getValidade() {
        return validade;
    }
}
