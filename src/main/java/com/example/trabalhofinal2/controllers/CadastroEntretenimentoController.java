package com.example.trabalhofinal2.controllers;

import com.example.trabalhofinal2.models.Entretenimento;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroEntretenimentoController implements Initializable{

    @FXML
    private ChoiceBox<String> myChoiceBox;

    private String[] entretenimento = new String[]{"Jogo","Filme","Serie","Episodio"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(entretenimento);
    }
}
