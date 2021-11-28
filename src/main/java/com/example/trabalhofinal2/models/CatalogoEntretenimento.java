package com.example.trabalhofinal2.models;

import java.util.ArrayList;

public class CatalogoEntretenimento {

    private final static ArrayList<Entretenimento> entretenimentos = new ArrayList<>();

    public ArrayList<Entretenimento> getCatalogo() { return entretenimentos; }

    public boolean codigoUnico(Entretenimento entretenimento){
        for (Entretenimento value : entretenimentos) {
            if (value.getCodigo().equals(entretenimento.getCodigo())) {
                return false;
            }
        }
        return true;
    }

    public boolean addEntretenimentoValido(Entretenimento entretenimento){
        if(codigoUnico(entretenimento)){
            entretenimentos.add(entretenimento);
            return true;
        }
        return false;
    }

    public Serie buscaSerie(String nome){
        ArrayList<Serie> aux = new ArrayList<>();
        for (Entretenimento value : entretenimentos) {
            if (value.getTipo()==3) {
                if(value.getTitulo().equals(nome))
                    return (Serie) value;
            }
        }
        return null;
    }

    public ArrayList<String> listaNomeSeries(){
        ArrayList<String> aux = new ArrayList<>();
        for (Entretenimento value : entretenimentos) {
            if (value.getTipo()==3) {
                aux.add(value.getTitulo());
            }
        }
        return aux;
    }


}
