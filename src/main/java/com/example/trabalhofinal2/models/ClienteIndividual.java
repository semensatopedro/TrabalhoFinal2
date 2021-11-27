package com.example.trabalhofinal2.models;

public class ClienteIndividual extends Cliente{

    private String cpf;

    private int tipo;

    private ClienteEmpresarial empresa;

    public ClienteIndividual(String nome, String email, String senha, String cpf, ClienteEmpresarial empresa) {
        super(email,senha,nome);
        this.cpf = cpf;
        this.empresa = empresa;
        this.tipo = defineTipo();
    }

    public String getCpf() {
        return cpf;
    }

    public ClienteEmpresarial getEmpresa() {
        return empresa;
    }

    public int getTipo() { return tipo; }

    @Override
    public String toString() {
        if(getTipo() == 1){
            return getTipo() +
                ";" + getNome() + ";" +
                getEmail() + ";" +
                getSenha() + ";" +
                getCpf();
        }else{
            return getTipo() +
                    ";" + getNome() + ";" +
                    getEmail() + ";" +
                    getSenha() + ";" +
                    getCpf() +  ";" +
                    getEmpresa().getEmail();
        }

    }

    public int defineTipo(){
        if(this.empresa!=null){
            return 3;
        }
        return 1;
    }
}
