package com.delivery.model;

public class Endereco {
    private String rua;
    private String numero;
    private String complemento;
    private String cep;

    public Endereco(String rua, String numero, String complemento, String cep){
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }
}
