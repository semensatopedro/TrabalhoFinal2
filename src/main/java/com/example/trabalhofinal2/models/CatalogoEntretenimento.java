package com.example.trabalhofinal2.models;

import java.util.ArrayList;

public class CatalogoEntretenimento {

    private final static ArrayList<Entretenimento> entretenimentos = new ArrayList<>();;

    public ArrayList<Entretenimento> getCatalogo() {
        return entretenimentos;
    }

}
