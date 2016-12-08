package br.com.ufrn.bti.desktop.doinhome.views;

import java.io.IOException;

import br.com.ufrn.bti.desktop.doinhome.dominio.Tarefa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.servico.TarefaService;
import br.com.ufrn.bti.desktop.doinhome.servico.UsuarioService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TarefasGeralDoUsuarioController {
	private ObservableList<Tarefa> tarefasList = FXCollections.observableArrayList();
	private UsuarioService usuarioService;
	private TarefaService tarefaService;
	private Usuario usuarioLogado;
	private ContainerController containerController;
	private ContainerUsuarioController containerUsuarioController;
	
	@FXML
	private TableView<Tarefa> tvTodasTarefas;
	@FXML
	private TableColumn<Tarefa, String> tcTarefaDescricao;
	@FXML
	private TableColumn<Tarefa, String> tcTarefaSituacao;
	
	public TarefasGeralDoUsuarioController() {
		tvTodasTarefas = new TableView<Tarefa>();
		tcTarefaDescricao = new TableColumn<Tarefa, String>();	
		tcTarefaSituacao = new TableColumn<Tarefa, String>();
		
		usuarioService = new UsuarioService();
		usuarioLogado = usuarioService.buscarUsuarioLogado();
		tarefaService = new TarefaService();
		containerController = new ContainerController();
	}
	
	@FXML
	private void initialize() {
		tcTarefaDescricao.setCellValueFactory(cellData -> cellData.getValue().getDescricaoProperty());
		tcTarefaSituacao.setCellValueFactory(cellData -> cellData.getValue().getStatus());
	}
	
	public void setContainerController(ContainerController c) {
		this.containerController = c;
		tvTodasTarefas.setItems(tarefasList);
	}
	
	public void setContainerUsuarioController(ContainerUsuarioController c) {
		this.containerUsuarioController = c;
		tvTodasTarefas.setItems(tarefasList);
	}
	
	public void populaTabela() {
		tarefasList = FXCollections
				.observableList(tarefaService.listarTarefasUsuario(usuarioLogado));
	}
}
