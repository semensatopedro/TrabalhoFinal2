package com.example.trabalhofinal2.models;

public class ClienteIndividual extends Cliente{

    private String cpf;

    private ClienteEmpresarial empresa;

    public ClienteIndividual(String nome, String email, String senha, String cpf, ClienteEmpresarial empresa) {
        super(email,senha,nome);
        this.cpf = cpf;
        this.empresa = empresa;
    }

    public String getCpf() {
        return cpf;
    }

    public ClienteEmpresarial getEmpresa() {
        return empresa;
    }
}
