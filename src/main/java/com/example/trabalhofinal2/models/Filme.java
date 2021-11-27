package com.example.trabalhofinal2.models;

public class Filme extends Entretenimento{

    private int tempoDurcao;

    public Filme(String id, String titulo, int anoLancamento, int tempoDurcao) {
        super(id, titulo, anoLancamento);
        this.tempoDurcao = tempoDurcao;
    }

    public int getTempoDurcao() {
        return tempoDurcao;
    }
}
