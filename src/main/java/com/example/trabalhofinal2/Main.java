package com.example.trabalhofinal2;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("stonks-628x353.jpg")));
        stage.setScene(scene);
        stage.show();

        //Comentário teste Git
    }

    public static void main(String[] args) {
        launch();
    }
}