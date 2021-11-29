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
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastroEntretenimentoController implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<String> myChoiceBox;
    @FXML
    private TextField idCodigo;
    @FXML
    private TextField idAnoLancamento;
    @FXML
    private TextField idTitulo;
    @FXML
    private TextField idTituloOriginal;
    @FXML
    private TextField idGenero;
    @FXML
    private TextField idTempoDuracao;
    @FXML
    private TextField idAnoConclusao;
    @FXML
    private TextField idNumeroTemporada;
    @FXML
    private ChoiceBox<String> serieChoiceBox;
    @FXML
    private Button cadastrar;
    @FXML
    private Text serieText;
    @FXML
    private TextArea textArea;

    private CatalogoEntretenimento entretenimentos = new CatalogoEntretenimento();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(
                "Jogo",
                "Filme",
                "Serie",
                "Episodio"
        );
        myChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (v,oldValue,newValue) -> carregaOpcaoEntretenimento(newValue));
        serieChoiceBox.getItems().addAll(entretenimentos.listaNomeSeries());
        serieChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (v,oldValue,newValue) -> carregaEpisodio(entretenimentos.buscaSerie(newValue)));

    }

    public void voltar(ActionEvent event){
        carregaCena("gui/menuAdm.fxml",event);
    }

    public void carregaOpcaoEntretenimento(String newValue){
        if(newValue.equals("Jogo")){
            limpaTela();
            limpaCampos();
            idCodigo.setDisable(false);
            idAnoLancamento.setDisable(false);
            idTitulo.setDisable(false);

            idCodigo.setVisible(true);
            idAnoLancamento.setVisible(true);
            idTitulo.setVisible(true);
            idTituloOriginal.setVisible(true);
            idGenero.setVisible(true);
            cadastrar.setDisable(false);
            cadastrar.setOnAction(actionEvent -> formularioJogo());

        }else if(newValue.equals("Filme")){
            limpaTela();
            limpaCampos();
            idCodigo.setDisable(false);
            idAnoLancamento.setDisable(false);
            idTitulo.setDisable(false);

            idCodigo.setVisible(true);
            idAnoLancamento.setVisible(true);
            idTitulo.setVisible(true);
            idTempoDuracao.setVisible(true);
            cadastrar.setDisable(false);
            cadastrar.setOnAction(actionEvent -> formularioFilme());

        }else if(newValue.equals("Serie")){
            limpaTela();
            limpaCampos();
            idCodigo.setDisable(false);
            idAnoLancamento.setDisable(false);
            idTitulo.setDisable(false);
            idAnoConclusao.setDisable(false);

            idCodigo.setVisible(true);
            idAnoLancamento.setVisible(true);
            idTitulo.setVisible(true);
            idAnoConclusao.setVisible(true);
            cadastrar.setDisable(false);
            cadastrar.setOnAction(actionEvent -> formularioSerie());

        }else if(newValue.equals("Episodio")){
            limpaTela();
            limpaCampos();

            idCodigo.setDisable(true);
            idAnoLancamento.setDisable(true);
            idTitulo.setDisable(true);
            idNumeroTemporada.setDisable(true);

            idCodigo.setVisible(true);
            idAnoLancamento.setVisible(true);
            idTitulo.setVisible(true);
            idNumeroTemporada.setVisible(true);

            serieChoiceBox.setVisible(true);
            serieText.setVisible(true);
            cadastrar.setDisable(true);

        }else{
            limpaTela();
        }
    }

    public void carregaEpisodio(Serie serie){
        if(!serie.getTitulo().equals("")) {
            idCodigo.setDisable(false);
            idAnoLancamento.setDisable(false);
            idTitulo.setDisable(false);
            idNumeroTemporada.setDisable(false);
            cadastrar.setDisable(false);
            cadastrar.setOnAction(actionEvent -> formularioEpisodio(serie));
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
            escreveMensagem(new Text("Cena não encontrada"));
        }
    }

    public void limpaTela(){
        idCodigo.setVisible(false);
        idAnoLancamento.setVisible(false);
        idTitulo.setVisible(false);
        idTituloOriginal.setVisible(false);
        idGenero.setVisible(false);
        idTempoDuracao.setVisible(false);
        idAnoConclusao.setVisible(false);
        idNumeroTemporada.setVisible(false);
        serieChoiceBox.setVisible(false);
        serieText.setVisible(false);
        cadastrar.setDisable(true);
    }

    public void formularioJogo(){
        String codigoUsuario = validaString(idCodigo);
        int anoLancamentoUsuario = validaAno(idAnoLancamento);
        String tituloUsuario = validaString(idTitulo);
        String tituloOriginalUsuario = validaString(idTituloOriginal);
        String generoUsuario = validaString(idGenero);
        Jogo jogo = new Jogo(codigoUsuario,tituloUsuario,anoLancamentoUsuario,tituloOriginalUsuario,generoUsuario);

        if(validaCadastro(jogo) && !tituloOriginalUsuario.equals("") && !generoUsuario.equals("")){
            if(entretenimentos.addEntretenimentoValido(jogo)){
                limpaCampos();
                escreveMensagem(new Text("Jogo cadastrado com sucesso." + "\n" + jogo.toString()));
            }else{
                escreveMensagem(new Text("Código " + jogo.getCodigo() + " já existe. Cadastre outro código."));
                campoInvalido(idCodigo);
                idCodigo.clear();
            }
        }else{
            escreveMensagem(new Text("Jogo não cadastrado. Ao menos um campo inválido"));
        }
    }

    public void formularioFilme(){
        String codigoUsuario = validaString(idCodigo);
        int anoLancamentoUsuario = validaAno(idAnoLancamento);
        String tituloUsuario = validaString(idTitulo);
        int tempoDuracaoUsuario = validaInteiro(idTempoDuracao);
        Filme filme = new Filme(codigoUsuario,tituloUsuario,anoLancamentoUsuario,tempoDuracaoUsuario);

        if(validaCadastro(filme) && tempoDuracaoUsuario!=-1){
            if(entretenimentos.addEntretenimentoValido(filme)){
                limpaCampos();
                escreveMensagem(new Text("Filme cadastrado com sucesso." + "\n" + filme.toString()));
            }else{
                escreveMensagem(new Text("Código " + filme.getCodigo() + " já existe. Cadastre outro código."));
                campoInvalido(idCodigo);
                idCodigo.clear();
            }
        }else{
            escreveMensagem(new Text("Filme não cadastrado. Ao menos um campo inválido"));
        }
    }

    public void formularioSerie(){
        String codigoUsuario = validaString(idCodigo);
        int anoLancamentoUsuario = validaAno(idAnoLancamento);
        String tituloUsuario = validaString(idTitulo);
        int anoConclusaoUsuario = validaAno(idAnoConclusao);

        Serie serie = new Serie(codigoUsuario,tituloUsuario,anoLancamentoUsuario,anoConclusaoUsuario);

        if(validaCadastro(serie) && anoConclusaoUsuario!=-1 &&
                validaIntervaloEntreAnos(anoLancamentoUsuario,anoConclusaoUsuario)){
            if(entretenimentos.addEntretenimentoValido(serie)){
                escreveMensagem(new Text("Serie cadastrado com sucesso." + "\n" + serie.toString()));
            }else{
                escreveMensagem(new Text("Código " + serie.getCodigo() + " já existe. Cadastre outro código."));
                campoInvalido(idCodigo);
                idCodigo.clear();
            }
        }else{
            escreveMensagem(new Text("Serie não cadastrado. Ao menos um campo inválido"));
        }
    }

    public void formularioEpisodio(Serie serie){

        String codigoUsuario = validaString(idCodigo);
        int anoLancamentoUsuario = validaAno(idAnoLancamento);
        String tituloUsuario = validaString(idTitulo);
        int numeroTemporadaUsuario = validaInteiro(idNumeroTemporada);
        int numeroEpisodioUsuario= validaInteiro(idNumeroTemporada);
        Serie serieUsuario = serie;
        EpisodioSerie episodio = new EpisodioSerie(codigoUsuario,tituloUsuario,anoLancamentoUsuario,
                numeroTemporadaUsuario,numeroEpisodioUsuario,serieUsuario);

        if(validaCadastro(episodio) && numeroTemporadaUsuario!=-1
                && numeroEpisodioUsuario!=-1){
            if(entretenimentos.addEntretenimentoValido(episodio)){
                escreveMensagem(new Text("Episódio cadastrado com sucesso." + "\n" + episodio.toString()));
            }else{
                escreveMensagem(new Text("Código " + episodio.getCodigo() + " já existe. Cadastre outro código."));
                campoInvalido(idCodigo);
                idCodigo.clear();
            }
        } else{
            escreveMensagem(new Text("Episódio não cadastrado. Ao menos um campo inválido"));
        }
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
        } else if(validaInteiro(textField)<1500 || validaInteiro(textField)>2021){
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

    public boolean validaCadastro(Entretenimento entretenimento){

        if(entretenimento.getAnoLancamento() == -1 || entretenimento.getCodigo().equals("") ||
                entretenimento.getTitulo().equals("")) {
            return false;
        } else{
            return true;
        }
    }

    public boolean validaIntervaloEntreAnos(int ano1, int ano2){
        if(ano1>ano2){
            escreveMensagem(new Text("O intervalo entre anos é inválido"));
            campoInvalido(idAnoLancamento);
            campoInvalido(idAnoConclusao);
            return false;
        }
        return true;
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

    public void limpaCampos(){
        idCodigo.clear();
        idCodigo.setStyle(null);
        idTitulo.clear();
        idTitulo.setStyle(null);
        idAnoLancamento.clear();
        idAnoLancamento.setStyle(null);
        idTituloOriginal.clear();
        idTituloOriginal.setStyle(null);
        idGenero.clear();
        idGenero.setStyle(null);
    }
}
