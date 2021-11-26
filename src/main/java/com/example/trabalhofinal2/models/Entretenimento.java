package com.example.trabalhofinal2.models;

public class Entretenimento {

    private int id;

    private String titulo;

    private int anoLancamento;

    public Entretenimento(int id, String titulo, int anoLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }
}
