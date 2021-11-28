package com.example.trabalhofinal2.controllers;

import com.example.trabalhofinal2.models.Entretenimento;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CadastroClienteController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<String> myChoiceBox;
    @FXML
    private TextField idEmail;
    @FXML
    private TextField idSenha;
    @FXML
    private TextField idNome;
    @FXML
    private TextField idCpf;
    @FXML
    private TextField idCnpj;
    @FXML
    private TextArea textArea;

    //Adicionar um item a mais no choiceBox chamado nenhum

    public String validaCPF(TextField textField){
        if(textField.toString().length()==11 && validaInteiro(textField)!=-1){
            return textField.toString();
        }
        return "";
    }

    public String validaCNPJ(TextField textField){
        if(textField.toString().length()==14 && validaInteiro(textField)!=-1){
            return textField.toString();
        }
        return "";
    }

    public int validaInteiro(TextField textField){

        try{
            int aux = Integer.parseInt(textField.getText());
            textField.setStyle(null);
            return aux;
        }
        catch(NumberFormatException e){
            Text text = new Text();
            text.setText("O campo '" + textField.getId() + "' aceita apenas números.");
            escreveMensagem(text);
            campoInvalido(textField);

            return -1;
        }
    }

    public String validaString(TextField textfield){
        if(textfield.getText().equals("")){
            campoInvalido(textfield);
            return "";
        }

        textfield.setStyle(null);
        return textfield.getText();
    }

    public void campoInvalido(TextField textField){
        textField.setStyle(
                "-fx-control-inner-background: #FFEFEF;" +
                        "-fx-border-color: #FFA3A3");
        textField.clear();
    }

    public void escreveMensagem(Text mensagem){
        textArea.appendText(mensagem.getText() + "\n");
    }
}

