package com.example.trabalhofinal2.models;

public class EpisodioSerie extends Entretenimento{

    private int numTemporada;

    private int numEpisodio;

    private Serie serie;

    public EpisodioSerie(int id, String titulo, int anoLancamento, int numTemporada, int numEpisodio, Serie serie) {
        super(id, titulo, anoLancamento);
        this.numTemporada = numTemporada;
        this.numEpisodio = numEpisodio;
        this.serie = serie;
    }

    public int getNumTemporada() {
        return numTemporada;
    }

    public int getNumEpisodio() {
        return numEpisodio;
    }

    public Serie getSerie() {
        return serie;
    }
}
