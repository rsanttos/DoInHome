package br.com.ufrn.bti.desktop.doinhome.views;

import java.io.IOException;

import br.com.ufrn.bti.desktop.doinhome.dominio.Tarefa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.servico.UsuarioService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ContainerUsuarioController {
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
	
	public ContainerUsuarioController() {
		hlNovaTarefa = new Hyperlink();
		hlNovoUsuario = new Hyperlink();
		usuarioLogado = usuarioService.buscarUsuarioLogado();	
	}
	
	public void start(Stage stage, Usuario usuarioLogado) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("ContainerUsuario.fxml"));
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
	
	@FXML
	public void mostrarRankingDaCasa() throws IOException{
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContainerUsuarioController.class.getResource("RankingDaCasa.fxml"));
        this.conteudo.getChildren().clear();
        this.conteudo.getChildren().add((AnchorPane) loader.load());
        
        RankingDaCasaController rankingController = loader.getController();
        rankingController.populaTabela();
        rankingController.setContainerUsuarioController(this);
	}
	
	@FXML 
	public void mostrarTodasTarefasDoUsuario() throws IOException {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContainerUsuarioController.class.getResource("TarefasGeralDoUsuario.fxml"));
        this.conteudo.getChildren().clear();
        this.conteudo.getChildren().add((AnchorPane) loader.load());
        
        TarefasGeralDoUsuarioController tarefasGeralController = loader.getController();
        tarefasGeralController.populaTabela();
        tarefasGeralController.setContainerUsuarioController(this);
	}
	
	@FXML
	public void mostrarTarefasAbertasDoUsuario() throws IOException {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContainerUsuarioController.class.getResource("TarefasUsuarioListagem.fxml"));
        this.conteudo.getChildren().clear();
        this.conteudo.getChildren().add((AnchorPane) loader.load());
        
        TarefasUsuarioListagemViewController tarefasController = loader.getController();
		tarefasController.setUsuarioLogado(usuarioService.buscarUsuarioLogado());
		tarefasController.populaTabela();
		tarefasController.setContainerUsuarioController(this);
	}
}
