package com.example.trabalhofinal2.controllers;

import com.example.trabalhofinal2.Main;
import com.example.trabalhofinal2.models.CatalogoUsuarios;
import com.example.trabalhofinal2.models.Cliente;
import com.example.trabalhofinal2.models.ClienteIndividual;
import com.example.trabalhofinal2.models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button login;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text idUsuarioErro;
    @FXML
    private Text idSenhaInvalida;

    private CatalogoUsuarios usuarios = new CatalogoUsuarios();

    public void realizarLogin(ActionEvent event){

        Usuario tentativaLogin = new Usuario(userField.getText(),passwordField.getText());

        if(usuarios.encontraEmailUsuario(tentativaLogin)){
            //Usuário encontrado
            if(usuarios.validaSenhaUsuario(tentativaLogin)){
                //Senha Válida
                tentativaLogin = usuarios.buscaUsuarioPorEmail(userField.getText());
               if (tentativaLogin.defineTipo()==1 || tentativaLogin.defineTipo()==2 ||
                       tentativaLogin.defineTipo()==3){
                   //É Cliente
                   idSenhaInvalida.setVisible(false);
                   idUsuarioErro.setVisible(false);
                   passwordField.setStyle(null);
                   carregaCena("gui/menuCliente.fxml",event);
               } else {
                    //É administrador
                   idSenhaInvalida.setVisible(false);
                   idUsuarioErro.setVisible(false);
                   passwordField.setStyle(null);
                   carregaCena("gui/menuAdm.fxml",event);
              }
            }else {
                System.out.println("Senha inválida");
                senhaInvalida(new Text("Senha inválida"));
            }
        } else {
            loginInvalido(new Text("Usuário não encontrado"));
            System.out.println("Usuário não encontrado, tente novamente");
        }

    }

    public void loginInvalido(Text mensagemErro){
        idSenhaInvalida.setVisible(false);
        idUsuarioErro.setVisible(true);
        userField.clear();
        passwordField.clear();
    }

    public void senhaInvalida(Text mensagemErro){
        idUsuarioErro.setVisible(false);
        idSenhaInvalida.setVisible(true);
        campoInvalido(passwordField);
    }

    public void campoInvalido(TextField textField){
        textField.setStyle(
                "-fx-control-inner-background: #FFEFEF;" +
                        "-fx-border-color: #FFA3A3");
        textField.clear();
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
