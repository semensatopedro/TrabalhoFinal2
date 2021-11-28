package com.example.trabalhofinal2.controllers;

import com.example.trabalhofinal2.Main;
import com.example.trabalhofinal2.models.CatalogoUsuarios;
import com.example.trabalhofinal2.models.Entretenimento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastroClienteController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<String> myChoiceBox;
    @FXML
    private TextField idEmail;
    @FXML
    private TextField idSenha;
    @FXML
    private TextField idNome;
    @FXML
    private TextField idCpf;
    @FXML
    private TextField idCnpj;
    @FXML
    private TextArea textArea;
    @FXML
    private ChoiceBox empresaChoiceBox;
    @FXML
    private Button cadastrar;

    private String[] cliente = new String[]{"Cliente Individual", "Cliente Empresarial"};
    private CatalogoUsuarios clientes = new CatalogoUsuarios();

    //Adicionar um item a mais no choiceBox chamado nenhum

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(cliente);
        //empresaChoiceBox.getItems().addAll(clientes.listaNome(clientes.listaClientesEmpresariais()));
        myChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (v,oldValue,newValue) -> carregaOpcaoCliente(newValue));
        //empresaChoiceBox.getSelectionModel().selectedItemProperty().addListener(
        //        (v,oldValue,newValue) -> System.out.println(newValue));

    }

    public void voltar(ActionEvent event){
        carregaCena("gui/menuAdm.fxml",event);
    }

    public void carregaOpcaoCliente(String newValue){
        if(newValue.equals("Cliente Individual")){
            limpaTela();
            limpaCampos();
            idEmail.setVisible(true);
            idSenha.setVisible(true);
            idNome.setVisible(true);
            idCpf.setVisible(true);
            empresaChoiceBox.setVisible(true);

            idEmail.setDisable(false);
            idSenha.setDisable(false);
            idNome.setDisable(false);
            idCpf.setDisable(false);

            cadastrar.setVisible(true);
            cadastrar.setDisable(false);
            cadastrar.setOnAction(actionEvent -> System.out.println("Foi caralho"));

        }else if(newValue.equals("Cliente Empresarial")) {
            limpaTela();
            limpaCampos();
           // idCodigo.setDisable(false);
           // idAnoLancamento.setDisable(false);
           // idTitulo.setDisable(false);

           // idCodigo.setVisible(true);
           // idAnoLancamento.setVisible(true);
           // idTitulo.setVisible(true);
           // idTempoDuracao.setVisible(true);
            cadastrar.setDisable(false);
            cadastrar.setOnAction(actionEvent -> System.out.println("Cliente Empresarial"));
        }
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

    public String validaCPF(TextField textField){
        if(textField.toString().length()==11 && validaInteiro(textField)!=-1){
            return textField.toString();
        }
        return "";
    }

    public String validaCNPJ(TextField textField){
        if(textField.toString().length()==14 && validaInteiro(textField)!=-1){
            return textField.toString();
        }
        return "";
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

    public String validaString(TextField textfield){
        if(textfield.getText().equals("")){
            campoInvalido(textfield);
            return "";
        }

        textfield.setStyle(null);
        return textfield.getText();
    }

    public void campoInvalido(TextField textField){
        textField.setStyle(
                "-fx-control-inner-background: #FFEFEF;" +
                        "-fx-border-color: #FFA3A3");
        textField.clear();
    }

    public void limpaTela(){
        idEmail.setVisible(false);
        idSenha.setVisible(false);
        idNome.setVisible(false);
        idCpf.setVisible(false);
        cadastrar.setDisable(true);
    }

    public void limpaCampos(){
        idEmail.clear();
        idEmail.setStyle(null);
        idSenha.clear();
        idSenha.setStyle(null);
        idNome.clear();
        idNome.setStyle(null);
        idCpf.clear();
        idCpf.setStyle(null);
    }

    public void escreveMensagem(Text mensagem){
        textArea.appendText(mensagem.getText() + "\n");
    }
}

