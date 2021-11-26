package com.example.trabalhofinal2.models;

public class Cliente extends Usuario{

    private String nome;
    private String email;
    private String senha;


    public Cliente(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
