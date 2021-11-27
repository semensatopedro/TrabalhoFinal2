package com.example.trabalhofinal2.models;

import java.util.ArrayList;

public class Cliente extends Usuario {

    private String nome;
    
    protected int tipo;

    private ArrayList<Acesso> acessos;
    
    public Cliente(String email, String senha, String nome) {
        super(email, senha);
        this.nome = nome;
        this.tipo = defineTipo();
        this.acessos = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getTipo() {
        return tipo;
    }

    public ArrayList<Acesso> getAcessos(){
        return acessos;
    }

    public boolean adicionaAcesso(Entretenimento entretenimento){
        Acesso novoAcesso = new Acesso(this, entretenimento);
        acessos.add(novoAcesso);
        return true;
    }

    public ArrayList<Acesso> getAcessosDaqueleMes(int ano, int mes){
        ArrayList<Acesso> resultado = new ArrayList<>();
        for (Acesso acesso : acessos) {
            if(acesso.getDataHora().getYear() == ano && acesso.getDataHora().getMonth().getValue() == mes){
                resultado.add(acesso);
            }
        }
        return resultado;
    }

    public double cobrancaMensal(int ano, int mes){
        double valorFinal = 0;
        for (Acesso acesso : getAcessosDaqueleMes(ano, mes)) {
            int tipo = acesso.getEntretenimento().getTipo();
            // filme
            if(tipo == 1 ) valorFinal += 6; 
            // episodio serie
            else if(tipo == 4 ) valorFinal += 4;
            // jogo
            else if(tipo == 2 ) valorFinal += 8;
        }
        return valorFinal;
    }

    @Override
    public int defineTipo(){
        return 0;
    }
}