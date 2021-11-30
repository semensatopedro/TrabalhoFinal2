package com.example.trabalhofinal2.controllers;

import com.example.trabalhofinal2.Main;
import com.example.trabalhofinal2.models.Arquivo;
import com.example.trabalhofinal2.models.CatalogoAcesso;
import com.example.trabalhofinal2.models.CatalogoEntretenimento;
import com.example.trabalhofinal2.models.CatalogoUsuarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;

public class SimulaCargaController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea textArea;
    @FXML
    private TextField idNomeArquivo;
    @FXML
    private Button registra;

    private final static CatalogoAcesso acessos = new CatalogoAcesso();
    private final static CatalogoEntretenimento entretenimentos = new CatalogoEntretenimento();
    private final static CatalogoUsuarios clientes = new CatalogoUsuarios();
    private final static Arquivo arquivoConsulta = new Arquivo();

    public void carregamento(Text text){
        escreveMensagem(text);
        aguardaCarregamento(500);
    }

    public void registra(ActionEvent event){
        File arquivoAcessos = new File(
                "src/main/resources/com/example/trabalhofinal2/arquivos/"
                        + idNomeArquivo.getText() + "-acessos.dat" );
        File arquivoEntretenimentos = new File("src/main/resources/com/example/trabalhofinal2/arquivos/"
                + idNomeArquivo.getText() + "-entretenimento.dat" );
        File arquivoClientes = new File("src/main/resources/com/example/trabalhofinal2/arquivos/"
                + idNomeArquivo.getText() + "-clientes.dat" );


        arquivoConsulta.readFileCliente(arquivoClientes);
        arquivoConsulta.readFileEntretenimento(arquivoEntretenimentos);
        arquivoConsulta.readFileAcessos(arquivoAcessos);

        String conteudoAcessos = arquivoConsulta.readFileRelatorio(arquivoAcessos);
        String conteudoEntretenimentos = arquivoConsulta.readFileRelatorio(arquivoEntretenimentos);
        String conteudoClientes = arquivoConsulta.readFileRelatorio(arquivoClientes);

        carregamento(new Text("Carregando registros de Acesso"));
        escreveMensagem(new Text("Carregando registros de Entretenimento"));
        escreveMensagem(new Text("Carregando registros de Clientes"));
        escreveMensagem(new Text("\n" + "Os arquivos de consulta estão disponíveis na pasta do projeto"));
        escreveMensagem(new Text("Acessos Cadastrados: "));
        escreveMensagem(new Text(conteudoAcessos));
        escreveMensagem(new Text("Entretenimentos Cadastrados: "));
        escreveMensagem(new Text(conteudoEntretenimentos));
        escreveMensagem(new Text("Clientes Cadastrados: "));
        escreveMensagem(new Text(conteudoClientes));
    }

    public void voltar(ActionEvent event){
        carregaCena("gui/menuAdm.fxml",event);
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
    public void escreveMensagem(Text mensagem){
        textArea.appendText(mensagem.getText() + "\n");
    }

    public void aguardaCarregamento(int milisegundo){
        try{
            Thread.sleep(milisegundo);
        }catch (InterruptedException e) {
            escreveMensagem(new Text(e.getMessage()));
        }
    }


}
