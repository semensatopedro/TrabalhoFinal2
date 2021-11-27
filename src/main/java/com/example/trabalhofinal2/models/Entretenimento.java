package com.example.trabalhofinal2.models;

public class Entretenimento {

    private String codigo;

    private String titulo;

    private int tipo;

    private int anoLancamento;

    public Entretenimento(String id, String titulo, int anoLancamento) {
        this.codigo = id;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.tipo = defineTipo();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTipo() { return tipo;}

    public int getAnoLancamento() {
        return anoLancamento;
    }

    //Não dá para fazer desta forma. Precisamos identificar o tipo da forma correta.

    public int defineTipo(){
        if(this.getClass().getSimpleName().equals("Filme")){
            return 1;
        }else if(this.getClass().getSimpleName().equals("Jogo")){
            return 2;
        }else if(this.getClass().getSimpleName().equals("Serie")){
            return 3;
        }else{
            return 4;
        }
    }
}
