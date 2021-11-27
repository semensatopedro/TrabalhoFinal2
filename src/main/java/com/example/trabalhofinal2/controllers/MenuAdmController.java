package com.example.trabalhofinal2.controllers;

import com.example.trabalhofinal2.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuAdmController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void acessaCadastroCliente(ActionEvent event){
        carregaCena("gui/cadastraCliente.fxml",event);
    }

    public void acessaCadastroEntretenimento(ActionEvent event){
        carregaCena("gui/cadastraEntretenimento.fxml",event);
    }

    public void acessaConsultaAcesso(ActionEvent event){
        carregaCena("gui/consultaAcessoMensal.fxml",event);
    }

    public void acessaSimulaCarregamento(ActionEvent event){
        carregaCena("gui/SimulaCargaDeDados.fxml",event);
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
