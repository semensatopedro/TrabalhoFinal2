package com.example.trabalhofinal2.controllers;

import com.example.trabalhofinal2.models.CatalogoUsuarios;
import com.example.trabalhofinal2.models.Cliente;
import com.example.trabalhofinal2.models.ClienteIndividual;
import com.example.trabalhofinal2.models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Login {
    @FXML
    private Button login;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passwordField;

    private CatalogoUsuarios usuarios = new CatalogoUsuarios();

    public void realizarLogin(ActionEvent e){

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
}
