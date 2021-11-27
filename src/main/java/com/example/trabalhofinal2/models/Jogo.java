package com.example.trabalhofinal2.models;

public class Jogo extends Entretenimento{

    private String tituloOriginal;

    private String genero;

    public Jogo(String id, String titulo, int anoLancamento, String tituloOriginal, String genero) {
        super(id, titulo, anoLancamento);
        this.tituloOriginal = tituloOriginal;
        this.genero = genero;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public String getGenero() {
        return genero;
    }
}
