package com.example.trabalhofinal2.models;

public class Cliente extends Usuario {

    private String nome;
    private int tipo;

    public Cliente(String email, String senha, String nome) {
        super(email, senha);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int defineTipo(){
        return 1;
    }
}