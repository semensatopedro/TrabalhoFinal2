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

        //Teste de escrita e leitura (arquivo.dat)

        Administrador adm = new Administrador("administracao@mail.com","admin123");
        File acessos = new File("src/main/resources/com/example/trabalhofinal2/arquivos/-acessos.dat");
        File clientes = new File("src/main/resources/com/example/trabalhofinal2/arquivos/-clientes.dat");
        File entretenimentos = new File("src/main/resources/com/example/trabalhofinal2/arquivos/-entretenimento.dat");

        //adm.writeFile(acessos, "\n" + "Texto de apoio acesso");
        //adm.readFile(acessos);

        //adm.writeFile(clientes,  "Texto de apoio cliente" + "\n");
        //adm.readFile(clientes);

        //adm.writeFile(entretenimentos, "Texto de apoio entretenimento"+"\n");
        //adm.readFile(entretenimentos);

    }

    public static void main(String[] args) {
        inicializaCadastro();
        launch();
    }

    public static void inicializaCadastro(){
        CatalogoUsuarios catalogoUsuarios = new CatalogoUsuarios();

        ClienteEmpresarial cliente1 = new ClienteEmpresarial(
                "Coca Cola","coca@gmail.com","coca123","1234","Coca");
        Cliente cliente2 = new ClienteIndividual(
                "Paulo Brito","paulo@gmail.com","brito123","111111111",cliente1);
        Cliente cliente3 = new ClienteIndividual(
                "Paulo Brito","Ronaldo@gmail.com","brito123","111111111",null);
        Administrador adm = new Administrador("administracao@mail.com","admin123");

        catalogoUsuarios.addUsuarioValido(cliente1);
        catalogoUsuarios.addUsuarioValido(cliente2);
        catalogoUsuarios.addUsuarioValido(cliente3);
        catalogoUsuarios.addUsuarioValido(adm);

        System.out.println(cliente1.toString());
        System.out.println(cliente2.toString());
        System.out.println(cliente3.toString());
        System.out.println(catalogoUsuarios.getUsuarios().size());
    }
}