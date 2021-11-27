package com.example.trabalhofinal2.models;

import java.util.ArrayList;

public class ClienteEmpresarial extends Cliente{

    private String cnpj;

    private ArrayList<Cliente> colaboradores;

    public ClienteEmpresarial(String nome, String email, String senha, String cnpj) {
        super(email,senha,nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public ArrayList<Cliente> getColaboradores() {
        return colaboradores;
    }
}
