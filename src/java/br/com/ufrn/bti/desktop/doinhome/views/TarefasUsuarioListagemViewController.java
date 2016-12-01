package br.com.ufrn.bti.desktop.doinhome.views;

import java.util.Date;

import br.com.ufrn.bti.desktop.doinhome.dominio.Pessoa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Tarefa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.main.Main;
import br.com.ufrn.bti.desktop.doinhome.servico.TarefaService;
import br.com.ufrn.bti.desktop.doinhome.servico.UsuarioService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TarefasUsuarioListagemViewController extends GenericController{
	private ObservableList<Tarefa> tarefasList = FXCollections.observableArrayList();
	private UsuarioService usuarioService = new UsuarioService();
	private TarefaService tarefaService =  new TarefaService();
	private ContainerController containerController = new ContainerController();
	private Stage stage;	
	private Main main;
	@FXML
	private TableView<Tarefa> tvTarefasUsuario;
	@FXML
	private TableColumn<Tarefa, String> tcDescricaoTarefa;
	@FXML 
	private TableColumn<Tarefa, Date> tcDataFimTarefa;
	@FXML
	private TableColumn<Tarefa, String> tcAcoesTarefa;
	

	public TarefasUsuarioListagemViewController(Usuario usuarioLogado) {

		tarefasList = FXCollections.observableList(tarefaService.listarTarefasPendentesUsuario(usuarioLogado));		
		
		tvTarefasUsuario = new TableView<Tarefa>();
		tcDescricaoTarefa = new TableColumn<>();
		tcDataFimTarefa = new TableColumn<>();
		main = new Main();
	}
	
	@FXML
    private void initialize() {
		tcDescricaoTarefa.setCellValueFactory(cellData -> cellData.getValue().getDescricaoProperty());
		tcDataFimTarefa.setCellValueFactory(cellData -> cellData.getValue().getDataLimiteProperty());
	}
	
	public void setContainerController(ContainerController c) {
		this.containerController = c;
		tvTarefasUsuario.setItems(tarefasList);
	}

	public ObservableList<Tarefa> getTarefasList() {
		return tarefasList;
	}

	public void setTarefasList(ObservableList<Tarefa> tarefasList) {
		this.tarefasList = tarefasList;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public TarefaService getTarefaService() {
		return tarefaService;
	}

	public void setTarefaService(TarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public TableView<Tarefa> getTvTarefasUsuario() {
		return tvTarefasUsuario;
	}

	public void setTvTarefasUsuario(TableView<Tarefa> tvTarefasUsuario) {
		this.tvTarefasUsuario = tvTarefasUsuario;
	}

	public TableColumn<Tarefa, String> getTcDescricaoTarefa() {
		return tcDescricaoTarefa;
	}

	public void setTcDescricaoTarefa(TableColumn<Tarefa, String> tcDescricaoTarefa) {
		this.tcDescricaoTarefa = tcDescricaoTarefa;
	}

	public TableColumn<Tarefa, Date> getTcDataFimTarefa() {
		return tcDataFimTarefa;
	}

	public void setTcDataFimTarefa(TableColumn<Tarefa, Date> tcDataFimTarefa) {
		this.tcDataFimTarefa = tcDataFimTarefa;
	}

	public TableColumn<Tarefa, String> getTcAcoesTarefa() {
		return tcAcoesTarefa;
	}

	public void setTcAcoesTarefa(TableColumn<Tarefa, String> tcAcoesTarefa) {
		this.tcAcoesTarefa = tcAcoesTarefa;
	}

	public ContainerController getContainerController() {
		return containerController;
	}
	
}
