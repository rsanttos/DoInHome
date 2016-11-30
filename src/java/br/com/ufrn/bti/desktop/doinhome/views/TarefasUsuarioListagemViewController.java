package br.com.ufrn.bti.desktop.doinhome.views;

import java.util.Date;

import br.com.ufrn.bti.desktop.doinhome.dominio.Pessoa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Tarefa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.servico.TarefaService;
import br.com.ufrn.bti.desktop.doinhome.servico.UsuarioService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TarefasUsuarioListagemViewController {
	private ObservableList<Tarefa> tarefasList = FXCollections.observableArrayList();
	private UsuarioService usuarioService = new UsuarioService();
	private TarefaService tarefaService =  new TarefaService();
	private Usuario usuarioLogado;
	private ContainerController containerController = new ContainerController();
	
	@FXML
	private TableView<Tarefa> tvTarefasUsuario;
	@FXML
	private TableColumn<Tarefa, String> tcDescricaoTarefa;
	@FXML 
	private TableColumn<Tarefa, Date> tcDataFimTarefa;
	@FXML
	private TableColumn<Tarefa, String> tcAcoesTarefa;
	

	public TarefasUsuarioListagemViewController() {
//		tarefasList = FXCollections.observableList(tarefaService.listarTarefasPendentesUsuario(this.containerController.getUsuarioLogado()));
		Pessoa p = new Pessoa();
		Usuario u = new Usuario();
		Tarefa t = new Tarefa();
		
		p.setNome("Ramon");
		p.setSexo('M');
		p.setCpf("10904368408");
		p.setDataNascimento(new Date());
		
		u.setId(2);
		u.setLogin("ramon");
		u.setPessoa(p);
		
		tarefasList = FXCollections.observableList(tarefaService.listarTarefasPendentesUsuario(u));		
		
		tvTarefasUsuario = new TableView<Tarefa>();
		tcDescricaoTarefa = new TableColumn<>();
		tcDataFimTarefa = new TableColumn<>();
	}
	
	public void setUsuarioLogado(Usuario u) {
		this.usuarioLogado = u;
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
}
