package com.example.trabalhofinal2.models;

import java.time.LocalDate;

public class Acesso {

    private Cliente cliente;

    private Entretenimento entretenimento;

    private LocalDate dataHora;

    private int cobranca;

    public Acesso(Cliente cliente, Entretenimento entretenimento) {
        this.cliente = cliente;
        this.entretenimento = entretenimento;
        this.dataHora = LocalDate.now();
        this.cobranca = 0;
        if(entretenimento.defineTipo() == 1 ) this.cobranca = 6;
        else if(entretenimento.defineTipo() == 4 ) this.cobranca = 4;
        else this.cobranca = 8;
    }

   /* public void setCobranca() {
        int tipo = this.entretenimento.getTipo();
        // filme
        if(tipo == 1 ) cobranca = 6;
            // episodio serie
        else if(tipo == 4 ) cobranca = 4;
            // jogo
        else cobranca = 8;
    }
*/
    public void setCobranca(int cobranca) {
        this.cobranca = cobranca;
    }

    public int getCobranca() {
        return cobranca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Entretenimento getEntretenimento() {
        return entretenimento;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }
}
