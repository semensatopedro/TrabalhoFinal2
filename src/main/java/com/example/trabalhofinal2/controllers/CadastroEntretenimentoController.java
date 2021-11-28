package com.example.trabalhofinal2.controllers;

import com.example.trabalhofinal2.Main;
import com.example.trabalhofinal2.models.Entretenimento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroEntretenimentoController implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<String> myChoiceBox;
    @FXML
    private TextField idCodigo;
    @FXML
    private TextField idAnoLancamento;
    @FXML
    private TextField idTitulo;
    @FXML
    private TextField idTituloOriginal;
    @FXML
    private TextField idGenero;
    @FXML
    private TextField idTempoDuracao;
    @FXML
    private TextField idAnoConclusao;
    @FXML
    private TextField idNumeroTemporada;
    @FXML
    private ChoiceBox<String> serieChoiceBox;
    @FXML
    private Button cadastrar;
    @FXML
    private Text serieText;

    private String[] entretenimento = new String[]{"Jogo","Filme","Serie","Episodio"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(entretenimento);
        myChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (v,oldValue,newValue) -> carregaOpcaoEntretenimento(newValue));
    }

    public void voltar(ActionEvent event){
        carregaCena("gui/menuAdm.fxml",event);
    }

    public void carregaOpcaoEntretenimento(String newValue){
        if(newValue.equals("Jogo")){
            limpaTela();
            idCodigo.setDisable(false);
            idAnoLancamento.setDisable(false);
            idTitulo.setDisable(false);

            idCodigo.setVisible(true);
            idAnoLancamento.setVisible(true);
            idTitulo.setVisible(true);
            idTituloOriginal.setVisible(true);
            idGenero.setVisible(true);
            cadastrar.setDisable(false);
        }else if(newValue.equals("Filme")){
            limpaTela();
            idCodigo.setDisable(false);
            idAnoLancamento.setDisable(false);
            idTitulo.setDisable(false);

            idCodigo.setVisible(true);
            idAnoLancamento.setVisible(true);
            idTitulo.setVisible(true);
            idTempoDuracao.setVisible(true);
            cadastrar.setDisable(false);
        }else if(newValue.equals("Serie")){
            limpaTela();
            idCodigo.setDisable(false);
            idAnoLancamento.setDisable(false);
            idTitulo.setDisable(false);
            idAnoConclusao.setDisable(false);

            idCodigo.setVisible(true);
            idAnoLancamento.setVisible(true);
            idTitulo.setVisible(true);
            idAnoConclusao.setVisible(true);
            cadastrar.setDisable(false);
        }else if(newValue.equals("Episodio")){
            limpaTela();
            idCodigo.setDisable(true);
            idAnoLancamento.setDisable(true);
            idTitulo.setDisable(true);
            idNumeroTemporada.setDisable(true);

            idCodigo.setVisible(true);
            idAnoLancamento.setVisible(true);
            idTitulo.setVisible(true);
            idNumeroTemporada.setVisible(true);

            serieChoiceBox.setVisible(true);
            serieText.setVisible(true);
            cadastrar.setDisable(true);
        }else{
            limpaTela();
        }
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

    public void limpaTela(){
        idCodigo.setVisible(false);
        idAnoLancamento.setVisible(false);
        idTitulo.setVisible(false);
        idTituloOriginal.setVisible(false);
        idGenero.setVisible(false);
        idTempoDuracao.setVisible(false);
        idAnoConclusao.setVisible(false);
        idNumeroTemporada.setVisible(false);
        serieChoiceBox.setVisible(false);
        serieText.setVisible(false);
        cadastrar.setDisable(true);
    }
}
