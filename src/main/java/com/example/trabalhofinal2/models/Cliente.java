package com.example.trabalhofinal2.models;

import java.util.ArrayList;

public class Cliente extends Usuario {

    private String nome;
    
    protected int tipo;
    
    public Cliente(String email, String senha, String nome) {
        super(email, senha);
        this.nome = nome;
        this.tipo = defineTipo();
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getTipo() {
        return tipo;
    }

    @Override
    public int defineTipo(){
        return 0;
    }
}