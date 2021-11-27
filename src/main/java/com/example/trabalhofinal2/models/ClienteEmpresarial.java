package com.example.trabalhofinal2.models;

import java.util.ArrayList;

public class ClienteEmpresarial extends Cliente{

    private String cnpj;

    private String nomeFantasia;

    private ArrayList<Cliente> colaboradores;

    public ClienteEmpresarial(String nome, String email, String senha, String cnpj, String nomeFantasia) {
        super(email,senha,nome);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public ArrayList<Cliente> getColaboradores() {
        return colaboradores;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    @Override
    public String toString() {
        return "2" +
                ";" + getNome() + ";" +
                getEmail() + ";" +
                getSenha() + ";" +
                getCnpj() +  ";" +
                getNomeFantasia();
    }

    public int defineTipo(){
        return 2;
    }
}
