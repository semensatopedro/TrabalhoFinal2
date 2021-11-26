package com.example.trabalhofinal2.models;

import java.util.ArrayList;

public class CatalogoEntretenimento {

    private ArrayList<Entretenimento> catalogo;

    public CatalogoEntretenimento() {
        catalogo = new ArrayList<>();
    }

    public CatalogoEntretenimento(ArrayList<Entretenimento> catalogo) {
        this.catalogo = catalogo;
    }

    public ArrayList<Entretenimento> getCatalogo() {
        return catalogo;
    }
}
