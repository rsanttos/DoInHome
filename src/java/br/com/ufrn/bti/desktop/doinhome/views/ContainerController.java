package br.com.ufrn.bti.desktop.doinhome.views;

import java.io.IOException;

import br.com.ufrn.bti.desktop.doinhome.dominio.Tarefa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.servico.UsuarioService;
import javafx.beans.property.SimpleBooleanProperty;
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
	private UsuarioService usuarioService = new UsuarioService();
	
	@FXML
	private Pane conteudo;
	@FXML
	private Hyperlink hlTodasTarefas;
	@FXML
	private Hyperlink hlNovaTarefa;
	@FXML
	private Hyperlink hlMinhasTarefas;
	@FXML
	private Hyperlink hlTodosUsuarios;
	@FXML
	private Hyperlink hlNovoUsuario;
	@FXML
	private Hyperlink hlRanking;
	
	public ContainerController() {
		hlNovaTarefa = new Hyperlink();
		hlNovoUsuario = new Hyperlink();
		usuarioLogado = usuarioService.buscarUsuarioLogado();	
	}
	
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
	
	public void mostrarTelaDeEdicaoDeTarefa(Tarefa t) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ContainerController.class.getResource("TarefasCadastroEdicao.fxml"));
		this.conteudo.getChildren().clear();
		this.conteudo.getChildren().add((AnchorPane) loader.load());
		
		TarefasCadastroEdicaoViewController tController = loader.getController();
		tController.setTarefa(t);
		tController.preencherFormulario();		
	}
	
	@FXML
	public void mostrarFormularioDeNovaTarefa() throws IOException{
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContainerController.class.getResource("TarefasCadastroEdicao.fxml"));
        this.conteudo.getChildren().clear();
        this.conteudo.getChildren().add((AnchorPane) loader.load());
	}
	
	@FXML
	public void mostrarRankingDaCasa() throws IOException{
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContainerController.class.getResource("RankingDaCasa.fxml"));
        this.conteudo.getChildren().clear();
        this.conteudo.getChildren().add((AnchorPane) loader.load());
        
        RankingDaCasaController rankingController = loader.getController();
        rankingController.populaTabela();
        rankingController.setContainerController(this);
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
        
        UsuarioListaController usuarioListaController = loader.getController();
        usuarioListaController.populaTabela();
        usuarioListaController.setContainerController(this);
	}
	
	@FXML 
	public void mostrarTodasTarefasDoUsuario() throws IOException {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContainerController.class.getResource("TarefasGeralDoUsuario.fxml"));
        this.conteudo.getChildren().clear();
        this.conteudo.getChildren().add((AnchorPane) loader.load());
        
        TarefasGeralDoUsuarioController tarefasGeralController = loader.getController();
        tarefasGeralController.populaTabela();
        tarefasGeralController.setContainerController(this);
	}
	
	@FXML
	public void mostrarTarefasAbertasDoUsuario() throws IOException {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContainerController.class.getResource("TarefasUsuarioListagem.fxml"));
        this.conteudo.getChildren().clear();
        this.conteudo.getChildren().add((AnchorPane) loader.load());
        
        TarefasUsuarioListagemViewController tarefasController = loader.getController();
		tarefasController.setUsuarioLogado(usuarioService.buscarUsuarioLogado());
		tarefasController.populaTabela();
		tarefasController.setContainerController(this);
	}
}
