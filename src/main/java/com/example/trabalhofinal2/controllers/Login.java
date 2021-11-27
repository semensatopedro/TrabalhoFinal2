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

    private CatalogoUsuarios usuarios = new CatalogoUsuarios();

    public void realizarLogin(ActionEvent event){

        Usuario tentativaLogin = new Usuario(userField.getText(),passwordField.getText());

        if(usuarios.encontraEmailUsuario(tentativaLogin)){
            System.out.println("Usuário Econtrado");
            if(usuarios.validaSenhaUsuario(tentativaLogin)){
                System.out.println("Senha válida");
                tentativaLogin = usuarios.buscaUsuarioPorEmail(userField.getText());
               if (tentativaLogin.defineTipo()==1){
                   System.out.println("É Cliente Individual sem empresa");
               } else if(tentativaLogin.defineTipo()==2){
                   System.out.println("É Cliente Empresarial");
               } else if(tentativaLogin.defineTipo()==3){
                   System.out.println("É Cliente Individual com empresa");
               } else {
                    System.out.println("É Administrador");
                    carregaCena("gui/menuAdm.fxml",event);
              }
            }else {
                System.out.println("Senha inválida");
                loginInvalido(new Text("Senha inválida"));
            }
        } else {
            //Se o usuário não foi encontrado.
            loginInvalido(new Text("Usuário não encontrado"));
            System.out.println("Usuário não encontrado, tente novamente");
        }

    }

    public void loginInvalido(Text mensagemErro){
        campoInvalido(userField);
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
