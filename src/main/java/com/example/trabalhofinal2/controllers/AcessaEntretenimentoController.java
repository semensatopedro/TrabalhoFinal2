package com.example.trabalhofinal2.controllers;

import com.example.trabalhofinal2.Main;
import com.example.trabalhofinal2.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AcessaEntretenimentoController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ListView<Entretenimento> listView;
    @FXML
    private Text textAcerto;
    @FXML
    private Button confirmarAcesso;

    private static final CatalogoEntretenimentoController catalogoSelecionado = new CatalogoEntretenimentoController();
    private static final CatalogoAcesso acessos = new CatalogoAcesso();
    private static Login login = new Login();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listView.getItems().addAll(catalogoSelecionado.getUltimaBuscaRealizada());
        listView.setCellFactory(new Callback<ListView<Entretenimento>, ListCell<Entretenimento>>() {
            @Override
            public ListCell<Entretenimento> call(ListView<Entretenimento> param) {
                ListCell<Entretenimento> cell = new ListCell<Entretenimento>() {
                    @Override
                    protected void updateItem(Entretenimento item, boolean empty) {
                        super.updateItem(item, empty);
                        if(item != null) {
                            setText(item.getTitulo());
                        } else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        });
        listView.getSelectionModel().selectedItemProperty().addListener(
                (v,oldValue,newValue) -> {
                    ativaAcesso(newValue);
                });
    }

    public void ativaAcesso(Entretenimento entretenimento){
        System.out.println("Opção Selecionada");
        confirmarAcesso.setDisable(false);
        confirmarAcesso.setOnAction(actionEvent -> {
            Acesso novoAcesso = new Acesso((Cliente)login.getUsuarioLogado(),entretenimento);
            acessos.addAcesso(novoAcesso);
            textAcerto.setVisible(false);
            textAcerto.setVisible(true);
            System.out.println("Acesso realizado: " + novoAcesso.toString());
        });

    }
    public void voltar(ActionEvent event){
        carregaCena("gui/catalogoEntretenimento.fxml",event);
    }

    public void carregaCena(String endereco, ActionEvent event){
        try{
            root = FXMLLoader.load(Main.class.getResource(endereco));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            System.out.println("Cena não encontrada");
        }
    }


}
