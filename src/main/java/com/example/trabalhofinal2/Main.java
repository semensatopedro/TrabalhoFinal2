package com.example.trabalhofinal2;

import java.io.File;
import java.io.IOException;

import com.example.trabalhofinal2.models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("gui/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("imagens/stonks-628x353.jpg")));
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        inicializaPorArquivo();
        launch();

    }

    public static void inicializaPorArquivo(){
        CatalogoUsuarios catalogoUsuarios = new CatalogoUsuarios();
        CatalogoEntretenimento catalogoEntretenimento = new CatalogoEntretenimento();
        CatalogoAcesso catalogoAcesso = new CatalogoAcesso();
        Administrador adm = new Administrador("administracao@mail.com","admin123");
        catalogoUsuarios.addClienteValido(adm);
    }

}