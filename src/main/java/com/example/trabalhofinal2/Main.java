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

        ClienteEmpresarial cliente1 = new ClienteEmpresarial(
                "Coca Cola","coca@gmail.com","coca123","1234","Coca");
        //ClienteEmpresarial nenhum = new ClienteEmpresarial(
        //        "Nenhum",null,null,null,null);
        Usuario cliente2 = new ClienteIndividual(
                "Paulo Brito","paulo@gmail.com","brito123","111111111",cliente1);
        Usuario cliente3 = new ClienteIndividual(
                "Paulo Brito","Ronaldo@gmail.com","brito123","111111111",null);
        Administrador adm = new Administrador("administracao@mail.com","admin123");



        Entretenimento entretenimento1 = new Filme(
                "1","StarWars",1990,123);
        Entretenimento entretenimento2 = new Jogo(
                "2","Crash",2010,"Crash","Ação");
        Serie entretenimento3 = new Serie(
                "3","TheOffice",2001,2009);
        Entretenimento entretenimento4 = new EpisodioSerie(
                "4","Episodio1",2001,2,1,entretenimento3);


        catalogoUsuarios.addClienteValido(cliente1);
        catalogoUsuarios.addClienteValido(cliente2);
        catalogoUsuarios.addClienteValido(cliente3);
        catalogoUsuarios.addClienteValido(adm);
        //catalogoUsuarios.addClienteValido(nenhum);

        //System.out.println(cliente1.toString());
        //System.out.println(cliente2.toString());
        System.out.println(catalogoUsuarios.listaClientesEmpresariais().toString());
        //System.out.println(cliente3.toString());
        //System.out.println(catalogoUsuarios.getUsuarios().size());

        //Teste de escrita e leitura (arquivo.dat)

        //File acessos = new File("src/main/resources/com/example/trabalhofinal2/arquivos/-acessos.dat");
        //File clientes = new File("src/main/resources/com/example/trabalhofinal2/arquivos/-clientes.dat");
        //File entretenimentos = new File("src/main/resources/com/example/trabalhofinal2/arquivos/-entretenimento.dat");

        //adm.writeFile(acessos, "\n" + cliente1.toString());
        //adm.readFile(acessos);

        //adm.writeFile(clientes,  cliente1.toString() + "\n");
        //adm.readFile(clientes);

        //adm.writeFile(entretenimentos, "Texto de apoio entretenimento"+"\n");
        //adm.readFile(entretenimentos);

        //Valida Catálogo de Série
        Serie serie1 = new Serie(
                "4","Pokemon",2001,2009);
        Serie serie2 = new Serie(
                "5","Round6",2001,2009);
        Serie serie3 = new Serie(
                "6","Suits",2001,2009);

        catalogoEntretenimento.addEntretenimentoValido(serie1);
        catalogoEntretenimento.addEntretenimentoValido(serie2);
        catalogoEntretenimento.addEntretenimentoValido(serie3);
        System.out.println(catalogoEntretenimento.listaNomeSeries().toString());
    }
}