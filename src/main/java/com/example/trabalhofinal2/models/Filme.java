package com.example.trabalhofinal2.models;

public class Filme extends Entretenimento{

    private int tempoDurcao;

    public Filme(String codigo, String titulo, int anoLancamento, int tempoDurcao) {
        super(codigo, titulo, anoLancamento);
        this.tempoDurcao = tempoDurcao;
    }

    public int getTempoDurcao() {
        return tempoDurcao;
    }

    @Override
    public String toString() {
        return getTipo() +
                ";" + getCodigo() + ";" +
                getTitulo() + ";" +
                getAnoLancamento() + ";" +
                getTempoDurcao();
    }
}

