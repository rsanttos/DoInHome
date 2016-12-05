package br.com.ufrn.bti.desktop.doinhome.views;

import br.com.ufrn.bti.desktop.doinhome.dominio.Tarefa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.servico.TarefaService;
import br.com.ufrn.bti.desktop.doinhome.servico.UsuarioService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RankingDaCasaController {
	private ContainerController containerController;
	private ObservableList<Tarefa> ranking = FXCollections.observableArrayList();
	private TarefaService tarefaService; 
	
	@FXML
	private TableView<Tarefa> tvUsuarioLista;
	@FXML
	private TableColumn<Tarefa, String> tcUsuarioNome;
	@FXML
	private TableColumn<TarefaService, Integer> tcUsuarioPontuacao;
	
	public RankingDaCasaController() {
		tvUsuarioLista = new TableView<Tarefa>();
		tcUsuarioNome = new TableColumn<Tarefa, String>();
		tcUsuarioPontuacao = new TableColumn<TarefaService, Integer>();
		
		containerController = new ContainerController();
		tarefaService = new TarefaService();
	}
	
	@FXML
	private void initialize() {
		tcUsuarioNome.setCellValueFactory(cellData -> cellData.getValue().getUsuario().getLoginProperty());
	}

	public void populaTabela() {
		ranking = FXCollections.observableList(tarefaService.ranking());
	}

	public void setContainerController(ContainerController c) {
		this.containerController = c;
		tvUsuarioLista.setItems(ranking);
	}
}
