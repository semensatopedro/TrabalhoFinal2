package com.example.trabalhofinal2.controllers;

import com.example.trabalhofinal2.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuClienteController {


    private Stage stage;
    private Scene scene;
    private Parent root;


    public void acessaEntretenimento(ActionEvent event){
        carregaCena("gui/catalogoEntretenimento.fxml",event);
    }

    public void acessaConsultaCobranca(ActionEvent event){
        carregaCena("gui/consultaCobranca.fxml",event);
    }

    public void logout(ActionEvent event){
        carregaCena("gui/login.fxml",event);
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

}
