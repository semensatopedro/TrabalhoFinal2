package com.example.trabalhofinal2.models;

import java.util.ArrayList;

public class Serie extends Entretenimento{

    private int anoConclusao;

    private ArrayList<EpisodioSerie> episodios;

    public Serie(String codigo, String titulo, int anoLancamento, int anoConclusao) {
        super(codigo, titulo, anoLancamento);
        this.anoConclusao = anoConclusao;
    }

    public int getAnoConclusao() {
        return anoConclusao;
    }

    public ArrayList<EpisodioSerie> getEpisodios() {
        return episodios;
    }

    @Override
    public String toString() {
        return getTipo() +
                ";" + getCodigo() + ";" +
                getTitulo() + ";" +
                getAnoLancamento() + ";" +
                getAnoConclusao();
    }
}

