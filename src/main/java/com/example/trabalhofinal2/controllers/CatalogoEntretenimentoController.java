package com.example.trabalhofinal2.controllers;

import com.example.trabalhofinal2.Main;
import com.example.trabalhofinal2.models.CatalogoEntretenimento;
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
import java.util.*;

public class CatalogoEntretenimentoController implements Initializable {
    //Aqui terei de marcar a data e hora que determinado indivíduo clicou
    //Metodo: confirmaAcesso(ActionEvent e){
    //  Se houve entretenimento encontrado,
    //      Registra data e horário do acesso
    //      Imprime na tela
    //  Se não houve imprime erro
    //}

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<String> tipoChoiceBox;
    @FXML
    private ChoiceBox<String> ordenaChoiceBox;
    @FXML
    private TextField idAnoLancamentoInicio;
    @FXML
    private TextField idAnoLancamentoFinal;
    @FXML
    private TextField idTitulo;
    @FXML
    private TextField idTituloIncompleto;
    @FXML
    private TextField idCodigo;
    @FXML
    private TextArea textArea;
    @FXML
    private Button consultar;

    private final static CatalogoEntretenimento entretenimentos = new CatalogoEntretenimento();
    private static String opcaoUsuario = null;
    private static String ordenacaoUsuario = null;

    private static ArrayList<Entretenimento> ultimaBuscaRealizada = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipoChoiceBox.getItems().addAll(
                "Codigo",
                "Ano de Lançamento",
                "Titulo",
                "Titulo Incompleto"
        );
        tipoChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (v,oldValue,newValue) -> {
                    limpaCampos();
                    System.out.println(newValue);
                    armazenaOpcao(newValue);
                    ordenaChoiceBox.setDisable(false);
                });
        ordenaChoiceBox.getItems().addAll(
                "Titulo (Crescente)",
                "Ano (Decrescente)"
        );
        ordenaChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (v,oldValue,newValue) -> {
                    limpaCampos();
                    consultar.setDisable(false);
                    armazenaOrdenacao(newValue);
                    carregaFormulario(newValue);
                    //System.out.println(newValue);
                    //System.out.println(opcaoUsuario);
                });
    }

    public void carregaFormulario(String ordenacao){

        if(opcaoUsuario.equals("Codigo")){
            limpaCampos();
            idCodigo.setDisable(false);
            consultar.setOnAction(actionEvent -> formularioCodigo());
        }else if(opcaoUsuario.equals("Ano de Lançamento")){
            limpaCampos();
            idAnoLancamentoInicio.setDisable(false);
            idAnoLancamentoFinal.setDisable(false);
            consultar.setOnAction(actionEvent -> formularioAnoLancamento());
        }else if(opcaoUsuario.equals("Titulo")){
            limpaCampos();
            idTitulo.setDisable(false);
            consultar.setOnAction(actionEvent -> formularioTitulo());
        }else if(opcaoUsuario.equals("Titulo Incompleto")){
            limpaCampos();
            idTituloIncompleto.setDisable(false);
            consultar.setOnAction(actionEvent -> formularioTituloIncompleto());
        }
    }

    public void formularioCodigo(){
        String codigo = validaString(idCodigo);
        if(!codigo.equals("")){
            if (entretenimentos.buscaPorCodigo(codigo)!=null){
                System.out.println("Chegou aqui");
                ultimaBuscaRealizada.clear();
                ultimaBuscaRealizada.add(entretenimentos.buscaPorCodigo(codigo));
                consultar.setOnAction(actionEvent -> carregaCena("gui/acessaEntretenimento.fxml",actionEvent));
            }else{
                escreveMensagem(new Text("Não encontramos nenhum entretenimento com este código"));
            }
        }else{
            escreveMensagem(new Text("Busca não realizada, campo inválido"));
        }
    }

    public void formularioAnoLancamento(){
        int anoInicio = validaAno(idAnoLancamentoInicio);
        int anoFinal = validaAno(idAnoLancamentoFinal);

        if(validaIntervaloEntreAnos(anoInicio,anoFinal) && validaAno(idAnoLancamentoInicio)!=-1
        && validaAno(idAnoLancamentoFinal)!=-1){

            if (entretenimentos.buscaPorAnoLancamento(anoInicio,anoFinal)!=null){
                System.out.println("Chegou aqui");
                atualizaBusca(entretenimentos.buscaPorAnoLancamento(anoInicio,anoFinal));
                consultar.setOnAction(actionEvent -> carregaCena("gui/acessaEntretenimento.fxml",actionEvent));
            }else{
                escreveMensagem(new Text("Não encontramos nenhum entretenimento neste intervalo"));
            }
        }else{
            escreveMensagem(new Text("Busca não realizada, o intervalo dos Anos é inválido"));
        }
    }
    public void formularioTitulo(){
        String titulo = validaString(idTitulo);
        if(!validaString(idTitulo).equals("")){
            if (entretenimentos.buscaPorTituloCompleto(titulo)!=null){
                System.out.println("Chegou aqui");
                atualizaBusca(entretenimentos.buscaPorTituloCompleto(titulo));
                consultar.setOnAction(actionEvent -> carregaCena("gui/acessaEntretenimento.fxml",actionEvent));
            }else{
                escreveMensagem(new Text("Não encontramos nenhum entretenimento com este título"));
            }
        }else{
            escreveMensagem(new Text("Campo título inválido"));
        }
    }
    public void formularioTituloIncompleto(){
        String tituloIncompleto = validaString(idTituloIncompleto);
        if(!validaString(idTituloIncompleto).equals("")){
            if (entretenimentos.buscaPorTituloIncompleto(tituloIncompleto)!=null){
                System.out.println("Chegou aqui");
                atualizaBusca(entretenimentos.buscaPorTituloIncompleto(tituloIncompleto));
                consultar.setOnAction(actionEvent -> carregaCena("gui/acessaEntretenimento.fxml",actionEvent));
            }else{
                escreveMensagem(new Text("Não encontramos nenhum entretenimento com este título"));
            }
        }else{
            escreveMensagem(new Text("Campo título incompleto inválido"));
        }
    }

    public boolean validaIntervaloEntreAnos(int ano1, int ano2){
        if(ano1>ano2){
            return false;
        }
        return true;
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

    public int validaAno(TextField textField){
        if(validaInteiro(textField) == -1){
            return -1;
        } else if(validaInteiro(textField)<1800 || validaInteiro(textField)>2021){
            escreveMensagem(new Text("O ano cadastrado é inválido."));
            campoInvalido(textField);
            return -1;
        }

        return validaInteiro(textField);
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

    public void escreveMensagem(Text mensagem){
        textArea.appendText(mensagem.getText() + "\n");
    }

    public void voltar(ActionEvent event){
        carregaCena("gui/menuCliente.fxml",event);
    }

    public void carregaCena(String endereco, ActionEvent event){
        try{
            root = FXMLLoader.load(Main.class.getResource(endereco));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            escreveMensagem(new Text("Cena não encontrada"));
        }
    }

    public static void armazenaOpcao(String newValue){
        opcaoUsuario = newValue;
    }

    public static void armazenaOrdenacao(String newValue){
        ordenacaoUsuario = newValue;
    }

    public static void atualizaBusca(ArrayList<Entretenimento> buscaAtualizada){
        ultimaBuscaRealizada.clear();
        ultimaBuscaRealizada = buscaAtualizada;
    }

    public ArrayList<Entretenimento> getUltimaBuscaRealizada(){
        return ultimaBuscaRealizada;
    }

    public void ordenaBuscaRealizadaTitulo(){
        Collections.sort(ultimaBuscaRealizada,
                Comparator.comparing(Entretenimento::getTitulo));
    }
    public static String getOpcaoUsuario() {
        return opcaoUsuario;
    }

    public void limpaCampos(){
        idCodigo.clear();
        idCodigo.setStyle(null);
        idTitulo.clear();
        idTitulo.setStyle(null);
        idAnoLancamentoInicio.clear();
        idAnoLancamentoInicio.setStyle(null);
        idAnoLancamentoFinal.clear();
        idAnoLancamentoFinal.setStyle(null);
        idTituloIncompleto.clear();
        idTituloIncompleto.setStyle(null);

        idCodigo.setDisable(true);
        idTitulo.setDisable(true);
        idTituloIncompleto.setDisable(true);
        idAnoLancamentoInicio.setDisable(true);
        idAnoLancamentoFinal.setDisable(true);
    }

}
