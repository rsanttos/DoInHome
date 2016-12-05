package br.com.ufrn.bti.desktop.doinhome.views;

import br.com.ufrn.bti.desktop.doinhome.dominio.Tarefa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.servico.UsuarioService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class UsuarioListaController {
	private ContainerController containerController;
	private ObservableList<Usuario> usuarioList = FXCollections.observableArrayList();
	private UsuarioService usuarioService; 
	
	@FXML
	private TableView<Usuario> tvUsuarioLista;
	@FXML
	private TableColumn<Usuario, String> tcUsuarioNome;
	@FXML
	private TableColumn<Usuario, String> tcUsuarioTipo;
	
	public UsuarioListaController() {
		tvUsuarioLista = new TableView<Usuario>();
		tcUsuarioNome = new TableColumn<Usuario, String>();
		tcUsuarioTipo = new TableColumn<Usuario, String>();
		
		containerController = new ContainerController();
		usuarioService = new UsuarioService();
	}
	
	@FXML
	private void initialize() {
		tcUsuarioNome.setCellValueFactory(cellData -> cellData.getValue().getPessoa().getNomeProperty());
		tcUsuarioTipo.setCellValueFactory(cellData -> cellData.getValue().getPermissaoProperty());
	}

	public void populaTabela() {
		usuarioList = FXCollections.observableList(usuarioService.listar());
	}

	public void setContainerController(ContainerController c) {
		this.containerController = c;
		tvUsuarioLista.setItems(usuarioList);
	}

	
}
