package br.com.ufrn.bti.desktop.doinhome.views;

import java.io.IOException;

import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ContainerController {
	private BorderPane container;
	private Usuario usuarioLogado;
	
	@FXML
	private Pane conteudo;
	@FXML
	private Hyperlink hlTodasTarefas;
	@FXML
	private Hyperlink hlNovaTarefa;
	@FXML
	private Hyperlink hlMinhasTarefas;
	
	public void start(Stage stage, Usuario usuarioLogado) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Container.fxml"));
            container = (BorderPane) loader.load();
            Scene scene = new Scene(container);
            conteudo = new Pane();
            
			stage.setScene(scene);
			stage.setTitle("DoInHome");
			stage.show();
			
			mostrarListaTarefasUsuario(usuarioLogado);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setUsuarioLogado(Usuario u) {
		usuarioLogado = u;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public void mostrarListaTarefasUsuario(Usuario usuarioLogado) throws IOException{
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContainerController.class.getResource("TarefasUsuarioListagem.fxml"));
        this.conteudo.getChildren().clear();
        this.conteudo.getChildren().add((AnchorPane) loader.load());
        
        TarefasUsuarioListagemViewController tarefasController = loader.getController();
        tarefasController.setUsuarioLogado(usuarioLogado);
        tarefasController.populaTabela();
        tarefasController.setContainerController(this);
	}
	
	@FXML
	public void mostrarFormularioDeNovaTarefa() throws IOException{
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContainerController.class.getResource("TarefasCadastroEdicao.fxml"));
        this.conteudo.getChildren().clear();
        this.conteudo.getChildren().add((AnchorPane) loader.load());
	}
	
	@FXML 
	public void mostrarCadastroDeNovoUsuario() throws IOException {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContainerController.class.getResource("UsuarioCadastroEdicao.fxml"));
        this.conteudo.getChildren().clear();
        this.conteudo.getChildren().add((AnchorPane) loader.load());
	}
	
	@FXML
	public void mostrarListaDeUsuarios() throws IOException {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContainerController.class.getResource("UsuarioLista.fxml"));
        this.conteudo.getChildren().clear();
        this.conteudo.getChildren().add((AnchorPane) loader.load());
	}
	
	@FXML 
	public void mostrarListaDeTarefasDoDia() throws IOException {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContainerController.class.getResource("TarefasDoDia.fxml"));
        this.conteudo.getChildren().clear();
        this.conteudo.getChildren().add((AnchorPane) loader.load());
	}
	
	@FXML
	public void mostrarMinhastarefas() throws IOException {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContainerController.class.getResource("TarefasUsuarioListagem.fxml"));
        this.conteudo.getChildren().clear();
        this.conteudo.getChildren().add((AnchorPane) loader.load());
	}
}
