package com.example.trabalhofinal2.models;

public class Cliente extends Usuario{

    private String nome;

    public Cliente(String email, String senha, String nome) {
        super(email,senha);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
