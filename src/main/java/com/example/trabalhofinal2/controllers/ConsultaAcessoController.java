package com.example.trabalhofinal2.controllers;

import com.example.trabalhofinal2.Main;
import com.example.trabalhofinal2.models.CatalogoAcesso;
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

import java.io.IOException;

public class ConsultaAcessoController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea textArea;
    @FXML
    private TextField idAno;
    @FXML
    private TextField idMes;

    private final CatalogoAcesso acessos = new CatalogoAcesso();

    public void consultaAcessos(ActionEvent event){
        int ano = validaAno(idAno);
        int mes = validaMes(idMes);

        if(ano!=-1 && mes!=-1){
            if(acessos.getAcessosDaqueleMesGeral(ano,mes)!=null){
                limpaCampos();
                escreveMensagem(new Text(acessos.getRelatório(acessos.getAcessosDaqueleMesGeral(ano,mes))));
            }else{
                //Período vazio, nenhum acesso realizado.
                limpaCampos();
                escreveMensagem(new Text("Nenhum acesso computado neste período"));
            }
        }else{
            escreveMensagem(new Text("O Relatório não foi gerado. Valide os campos preenchidos"));
        }
    }

    public void voltar(ActionEvent event){
        carregaCena("gui/menuAdm.fxml",event);
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

    public int validaAno(TextField textField){
        if(validaInteiro(textField) == -1){
            return -1;
        } else if(validaInteiro(textField)<1900 || validaInteiro(textField)>2021){
            escreveMensagem(new Text("O ano cadastrado é inválido."));
            campoInvalido(textField);
            return -1;
        }

        return validaInteiro(textField);
    }

    public int validaMes(TextField textField){
        if(validaInteiro(textField) == -1){
            return -1;
        } else if(validaInteiro(textField)<1 || validaInteiro(textField)>12){
            escreveMensagem(new Text("O mês cadastrado é inválido."));
            campoInvalido(textField);
            return -1;
        }

        return validaInteiro(textField);
    }

    public void campoInvalido(TextField textField){
        textField.setStyle(
                "-fx-control-inner-background: #FFEFEF;" +
                        "-fx-border-color: #FFA3A3");
        textField.clear();
    }

    public void limpaCampos(){
        idAno.setStyle(null);
        idAno.clear();
        idMes.setStyle(null);
        idMes.clear();
    }

    public void escreveMensagem(Text mensagem){
        textArea.appendText(mensagem.getText() + "\n");
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
