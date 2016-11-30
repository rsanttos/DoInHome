package br.com.ufrn.bti.desktop.doinhome.views;

import java.util.Date;

import br.com.ufrn.bti.desktop.doinhome.dominio.Tarefa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TarefasDoDiaViewController {
	@FXML
	private Button btTarefaNovaTarefa;
	@FXML
	private TableView<Tarefa> tvTarefasDoDia;
	@FXML
	private TableColumn<Tarefa, String> tcTarefaDescricao;
	@FXML
	private TableColumn<Usuario, String> tcTarefaUsuario;
	@FXML
	private TableColumn<Tarefa, Date> tcTarefaDataFim;
}
