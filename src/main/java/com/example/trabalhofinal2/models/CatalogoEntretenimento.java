package com.example.trabalhofinal2.models;

import java.util.ArrayList;

public class CatalogoEntretenimento {

    private final static ArrayList<Entretenimento> entretenimentos = new ArrayList<>();;

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
            if(entretenimento.defineTipo()==1){
                if(validaFilme()){
                    entretenimentos.add(entretenimento);
                    return true;
                }
            }else if(entretenimento.defineTipo()==2){
                if(validaJogo()){
                    entretenimentos.add(entretenimento);
                    return true;
                }
            }else if(entretenimento.defineTipo()==3){
                if(validaSerie()){
                    entretenimentos.add(entretenimento);
                    return true;
                }
            }else if(entretenimento.defineTipo()==4){
                if(validaEpisodioSerie()){
                    entretenimentos.add(entretenimento);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean validaFilme(){
        return true;
    }

    public boolean validaJogo(){
        return true;
    }

    public boolean validaSerie(){
        return true;
    }

    public boolean validaEpisodioSerie(){
        return true;
    }

}
