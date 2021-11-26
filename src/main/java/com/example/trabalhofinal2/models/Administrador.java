package com.example.trabalhofinal2.models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario{

    public Administrador(String email, String senha) {
        super(email, senha);
    }

    public void readFile(File strFile){

        try (BufferedReader buffRead = new BufferedReader(new FileReader(strFile))){
            while(buffRead.ready()){
                String line = buffRead.readLine();
                //ArrayList<String> valores = new ArrayList<>(List.of(line.split(";")));
                //String aux = "Texto Auxiliar";
                //writeFile(strFile,line);
                System.out.println(line);
            }

        }catch (IOException e) {
            System.out.println("Deu ruim " + e.getMessage());
        }
    }

    public void writeFile(File strFile, String strData){

        try(BufferedWriter bfwriter = new BufferedWriter(new FileWriter(strFile,true))){
            bfwriter.write(strData);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

