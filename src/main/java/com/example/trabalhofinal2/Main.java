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
        inicializaCadastro();
        launch();
    }

    public static void inicializaCadastro(){
        CatalogoUsuarios catalogoUsuarios = new CatalogoUsuarios();
        CatalogoEntretenimento catalogoEntretenimento = new CatalogoEntretenimento();
        CatalogoAcesso catalogoAcesso = new CatalogoAcesso();

        Administrador adm = new Administrador("administracao@mail.com","admin123");

        ClienteEmpresarial cliente1 = new ClienteEmpresarial(
                "Coca Cola","coca@gmail.com","coca123","1234","Coca");
        Usuario cliente2 = new ClienteIndividual(
                "Paulo Brito","paulo@gmail.com","brito123","111111111",cliente1);
        Usuario cliente3 = new ClienteIndividual(
                "Ronaldo","ronaldo@gmail.com","ron123","111111111",null);




        Entretenimento entretenimento1 = new Filme(
                "1","StarWars",1990,123);
        Entretenimento entretenimento2 = new Jogo(
                "2","Crash",2010,"Crash Biru","Ação");
        Serie entretenimento3 = new Serie(
                "3","TheOffice",2001,2009);
        Entretenimento entretenimento4 = new EpisodioSerie(
                "4","Episodio1",2001,2,1,entretenimento3);
        Entretenimento entretenimento5 = new Filme(
                "5","StarWars2",1991,123);
        Entretenimento entretenimento6 = new Jogo(
                "6","Crash2",2011,"Crash Bandicoot","Ação");
        Entretenimento entretenimento7 = new Jogo(
                "7","Avatar",2011,"Avatar","Ação");
        Serie serie1 = new Serie(
                "7","Pokemon",2001,2009);
        Serie serie2 = new Serie(
                "8","Round6",2001,2009);
        Serie serie3 = new Serie(
                "9","Suits",2001,2009);

        catalogoUsuarios.addClienteValido(cliente1);
        catalogoUsuarios.addClienteValido(cliente2);
        catalogoUsuarios.addClienteValido(cliente3);
        catalogoUsuarios.addClienteValido(adm);

        catalogoEntretenimento.addEntretenimentoValido(serie1);
        catalogoEntretenimento.addEntretenimentoValido(serie2);
        catalogoEntretenimento.addEntretenimentoValido(serie3);
        catalogoEntretenimento.addEntretenimentoValido(entretenimento1);
        catalogoEntretenimento.addEntretenimentoValido(entretenimento2);
        catalogoEntretenimento.addEntretenimentoValido(entretenimento3);
        catalogoEntretenimento.addEntretenimentoValido(entretenimento4);
        catalogoEntretenimento.addEntretenimentoValido(entretenimento5);
        catalogoEntretenimento.addEntretenimentoValido(entretenimento6);
        catalogoEntretenimento.addEntretenimentoValido(entretenimento7);

        Acesso acesso1 = new Acesso((Cliente)cliente2,entretenimento2);
        Acesso acesso2 = new Acesso((Cliente)cliente2,entretenimento4);
        Acesso acesso3 = new Acesso((Cliente)cliente3,entretenimento2);
        Acesso acesso4 = new Acesso((Cliente)cliente3,entretenimento2);

        catalogoAcesso.addAcesso(acesso1);
        catalogoAcesso.addAcesso(acesso2);
        catalogoAcesso.addAcesso(acesso3);
        catalogoAcesso.addAcesso(acesso4);

    }
}