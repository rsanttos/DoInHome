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
	private ContainerUsuarioController containerUsuarioController;
	private ObservableList<Usuario> ranking = FXCollections.observableArrayList();
	private TarefaService tarefaService; 
	private UsuarioService usuarioService;
	@FXML
	private TableView<Usuario> tvUsuarioLista;
	@FXML
	private TableColumn<Usuario, String> tcUsuarioNome;
	@FXML
	private TableColumn<Usuario, Integer> tcUsuarioPontuacao;
	
	public RankingDaCasaController() {
		tvUsuarioLista = new TableView<Usuario>();
		tcUsuarioNome = new TableColumn<Usuario, String>();
		tcUsuarioPontuacao = new TableColumn<Usuario, Integer>();
		
		containerController = new ContainerController();
		tarefaService = new TarefaService();
		usuarioService = new UsuarioService();
	}
	
	@FXML
	private void initialize() {
		tcUsuarioNome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		tcUsuarioPontuacao.setCellValueFactory(cellData -> cellData.getValue().getPontuacaoProperty());
	}

	public void populaTabela() {
		ranking = FXCollections.observableList(usuarioService.ranking());
	}

	public void setContainerController(ContainerController c) {
		this.containerController = c;
		tvUsuarioLista.setItems(ranking);
	}
	
	public void setContainerUsuarioController(ContainerUsuarioController c) {
		this.containerUsuarioController = c;
		tvUsuarioLista.setItems(ranking);
	}
}
