package com.example.trabalhofinal2.models;

public class Entretenimento {

    private String codigo;

    private String titulo;

    private int anoLancamento;

    public Entretenimento(String id, String titulo, int anoLancamento) {
        this.codigo = id;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

}
