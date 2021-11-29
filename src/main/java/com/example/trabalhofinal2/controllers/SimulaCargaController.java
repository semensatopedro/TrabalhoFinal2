package com.example.trabalhofinal2.controllers;

import com.example.trabalhofinal2.Main;
import com.example.trabalhofinal2.models.CatalogoAcesso;
import com.example.trabalhofinal2.models.CatalogoEntretenimento;
import com.example.trabalhofinal2.models.CatalogoUsuarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;

public class SimulaCargaController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea textArea;
    @FXML
    private TextField idNomeArquivo;

    private final static CatalogoAcesso acessos = new CatalogoAcesso();
    private final static CatalogoEntretenimento entretenimentos = new CatalogoEntretenimento();
    private final static CatalogoUsuarios clientes = new CatalogoUsuarios();

    public void registra(ActionEvent event){

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

    public void voltar(ActionEvent event){
        carregaCena("gui/menuAdm.fxml",event);
    }

    public void carregaCena(String endereco, ActionEvent event){
        try{
            root = FXMLLoader.load(Main.class.getResource(endereco));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
        }
    }
    public void escreveMensagem(Text mensagem){
        textArea.appendText(mensagem.getText() + "\n");
    }

}
