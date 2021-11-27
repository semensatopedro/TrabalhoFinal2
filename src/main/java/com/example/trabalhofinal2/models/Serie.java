package com.example.trabalhofinal2.models;

import java.util.ArrayList;

public class Serie extends Entretenimento{

    private int anoConclusao;

    private ArrayList<EpisodioSerie> episodios;

    public Serie(int id, String titulo, int anoLancamento, int anoConclusao) {
        super(id, titulo, anoLancamento);
        this.anoConclusao = anoConclusao;
    }

    public int getAnoConclusao() {
        return anoConclusao;
    }

    public ArrayList<EpisodioSerie> getEpisodios() {
        return episodios;
    }
}
