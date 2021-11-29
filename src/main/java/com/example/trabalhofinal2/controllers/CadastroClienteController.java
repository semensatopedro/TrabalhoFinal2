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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastroClienteController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<Cliente> myChoiceBox;
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
    private TextField idNomeFantasia;
    @FXML
    private TextArea textArea;
    @FXML
    private ChoiceBox empresaChoiceBox;
    @FXML
    private Button cadastrar;


    private final CatalogoUsuarios clientes = new CatalogoUsuarios();
    private static ClienteEmpresarial clienteEmpresarialPadrao = null;
    private static ClienteEmpresarial clienteEmpresarial = new ClienteEmpresarial(
            "Cliente Empresarial","","","","");
    private static ClienteIndividual clienteIndividual= new ClienteIndividual(
            "Cliente Individual","","","",null);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ClienteEmpresarial nenhum =
                new ClienteEmpresarial("Nenhuma",null,null,null,null);
        myChoiceBox.getItems().addAll(
                clienteIndividual,
                clienteEmpresarial
        );
        myChoiceBox.setConverter(new StringConverter<Cliente>() {
            @Override
            public String toString(Cliente cliente) {
                try {
                    return cliente.getNome();
                } catch (NullPointerException e) {
                    //Classe vazia
                    return "";
                }
            }
            @Override
       // não usado
            public ClienteEmpresarial fromString(String s) {
               return null;
           }
        });
        myChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (v,oldValue,newValue) -> carregaOpcaoCliente((Cliente) myChoiceBox.getSelectionModel().getSelectedItem()));
        empresaChoiceBox.getItems().add(nenhum);
        empresaChoiceBox.getItems().addAll(clientes.listaClientesEmpresariais());

       // try{
       //     empresaChoiceBox.setConverter(new StringConverter<ClienteEmpresarial>() {
       //         @Override
       //         public String toString(ClienteEmpresarial clienteEmpresarial) {
       //             if(clienteEmpresarial==null){
       //                 return null;
       //             }
       //                 return clienteEmpresarial.getNome();
       //        }
       //         @Override
       //         public ClienteEmpresarial fromString(String s) {
       //             return null;
       //         }
       //     });
       // }catch(RuntimeException is){
       //     System.out.println("Peguei a exception");
       // }

        empresaChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (v1,oldValue1,newValue1) -> clienteEmpresarialPadrao = (ClienteEmpresarial) empresaChoiceBox.getSelectionModel().getSelectedItem());
    }

    public void voltar(ActionEvent event){
        carregaCena("gui/menuAdm.fxml",event);
    }

    public void carregaOpcaoCliente(Cliente cliente){
        if(cliente.defineTipo() == 1 || cliente.defineTipo() == 3){
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

            cadastrar.setDisable(false);
            cadastrar.setOnAction(actionEvent ->
                    formularioClienteIndividual(clienteEmpresarialPadrao));

        }else if(cliente.defineTipo()==2) {
            limpaTela();
            limpaCampos();
            idEmail.setVisible(true);
            idSenha.setVisible(true);
            idNome.setVisible(true);
            idNomeFantasia.setVisible(true);
            idCnpj.setVisible(true);

            idEmail.setDisable(false);
            idSenha.setDisable(false);
            idNome.setDisable(false);
            idNomeFantasia.setDisable(false);
            idCnpj.setDisable(false);

            cadastrar.setDisable(false);
            cadastrar.setOnAction(actionEvent -> formularioClienteEmpresarial());
        }
    }

    public void formularioClienteIndividual(ClienteEmpresarial clienteEmpresarial){
        String email = validaString(idEmail);
        String senha = validaString(idSenha);
        String nome = validaString(idNome);
        String cpf = validaCPF(idCpf);
        ClienteEmpresarial empresa = clienteEmpresarial;

        ClienteIndividual clienteIndividual = new ClienteIndividual(email,senha,nome,cpf,empresa);

        if(validaCadastro(clienteIndividual) && !cpf.equals("")){
            if(clientes.emailValido(email) && clientes.cpfValido(cpf)){
                clientes.addClienteValido(clienteIndividual);
                    limpaCampos();
                    escreveMensagem(new Text("Cliente Individual cadastrado com sucesso." +
                            "\n" + clienteIndividual.toString()));
            }
            else{
                escreveMensagem(new Text("Email ou CPF já existente."));
                escreveMensagem(new Text("Cliente não cadastrado."));
                campoInvalido(idEmail);
                campoInvalido(idCpf);
                idEmail.clear();
                idCpf.clear();
            }
        }else{
                escreveMensagem(new Text("Cliente não cadastrado. Ao menos um campo inválido"));
        }

    }

    public void formularioClienteEmpresarial(){
        String email = validaString(idEmail);
        String senha = validaString(idSenha);
        String nome = validaString(idNome);
        String cnpj = validaCNPJ(idCnpj);
        String nomeFantasia = validaString(idNomeFantasia);
        ClienteEmpresarial clienteEmpresarial = new ClienteEmpresarial(email,senha,nome,cnpj,nomeFantasia);

        if(validaCadastro(clienteEmpresarial) && !cnpj.equals("")){
            if(clientes.emailValido(email) && clientes.cnpjInvalido(cnpj)){
                clientes.addClienteValido(clienteEmpresarial);
                limpaCampos();
                escreveMensagem(new Text("Cliente Empresarial cadastrado com sucesso." +
                        "\n" + clienteEmpresarial.toString()));
            }
            else{
                escreveMensagem(new Text("Email ou CNPJ já existente."));
                escreveMensagem(new Text("Cliente Empresarial não cadastrado."));
                campoInvalido(idEmail);
                campoInvalido(idCnpj);
                idEmail.clear();
                idCnpj.clear();
            }
        }else{
            escreveMensagem(new Text("Cliente Empresarial não cadastrado. Ao menos um campo inválido"));
        }
    }

    public boolean validaCadastro(Cliente cliente){

        if(cliente.getEmail().equals("") || cliente.getSenha().equals("") ||
                cliente.getNome().equals("")) {
            return false;
        } else{
            return true;
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
        if(textField.getText().length()==11 && validaLong(textField)!=-1){
            return textField.getText();
        }else {
            campoInvalido(textField);
            return "";
        }
    }

    public String validaCNPJ(TextField textField){
        if(textField.getText().length()==14 && validaLong(textField)!=-1){
            return textField.toString();
        }else{
            campoInvalido(textField);
            return "";
        }

    }

    public long validaLong(TextField textField){

        try{
            System.out.println(textField.getText());
            long aux = Long.parseLong(textField.getText());
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
        idCnpj.setVisible(false);
        idNomeFantasia.setVisible(false);
        empresaChoiceBox.setVisible(false);
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
        idCnpj.clear();
        idCnpj.setStyle(null);
        idNomeFantasia.clear();
        idNomeFantasia.setStyle(null);
    }

    public void escreveMensagem(Text mensagem){
        textArea.appendText(mensagem.getText() + "\n");
    }

}

