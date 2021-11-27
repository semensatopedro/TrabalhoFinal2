package com.example.trabalhofinal2.models;

import java.time.LocalDate;

public class Acesso {

    private Cliente cliente;

    private Entretenimento entretenimento;

    private LocalDate dataHora;

    public Acesso(Cliente cliente, Entretenimento entretenimento) {
        this.cliente = cliente;
        this.entretenimento = entretenimento;
        this.dataHora = LocalDate.now();
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
