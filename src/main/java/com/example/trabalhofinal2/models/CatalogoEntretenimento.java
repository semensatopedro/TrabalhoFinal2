package com.example.trabalhofinal2.models;

import java.util.ArrayList;

public class CatalogoEntretenimento {

    private final static ArrayList<Entretenimento> entretenimentos = new ArrayList<>();;

    public ArrayList<Entretenimento> getCatalogo() {
        return entretenimentos;
    }

    public boolean codigoUnico(Entretenimento entretenimento){
        for(int i = 0; i<entretenimentos.size();i++){
            if(entretenimentos.get(i).getCodigo().equals(entretenimento.getCodigo())){
                return false;
            }
        }
        return true;
    }

}
