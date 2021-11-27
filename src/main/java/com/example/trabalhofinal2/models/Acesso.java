package com.example.trabalhofinal2.models;

import java.util.Date;

public class Acesso {

    private Cliente cliente;

    private Entretenimento entretenimento;

    private Date dataHora;

    public Acesso(Cliente cliente, Entretenimento entretenimento, Date dataHora) {
        this.cliente = cliente;
        this.entretenimento = entretenimento;
        this.dataHora = dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Entretenimento getEntretenimento() {
        return entretenimento;
    }

    public Date getDataHora() {
        return dataHora;
    }
}
