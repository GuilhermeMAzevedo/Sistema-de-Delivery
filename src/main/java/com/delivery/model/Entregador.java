package com.delivery.model;

public class Entregador {
    private final String id;
    private String nome;
    private String veiculo;
    private boolean disponivel;

    public Entregador(String id, String nome, String veiculo){
        this.id = id;
        this.nome = nome;
        this.veiculo = veiculo;
        this.disponivel = true;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
