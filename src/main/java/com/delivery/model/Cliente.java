package com.delivery.model;

public class Cliente extends Usuario{
    private String email;
    private String telefone;
    private Endereco endereco;

    public Cliente(String id, String nome, String email, String telefone, Endereco endereco){
        super(id, nome);
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco(){
        return endereco;
    }

    public void atualizarDados(String nome, String email, String telefone){
        if (nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (email == null || !email.contains("@")){
            throw new IllegalArgumentException("Email inválido.");
        }
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public void definirEndereco(Endereco endereco){
        this.endereco = endereco;
    }
}