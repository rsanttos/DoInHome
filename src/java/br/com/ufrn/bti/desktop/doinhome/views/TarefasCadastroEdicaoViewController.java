package br.com.ufrn.bti.desktop.doinhome.views;

import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class TarefasCadastroEdicaoViewController {
	@FXML
	private TextField tfTarefaTitulo;
	@FXML
	private ComboBox<Usuario> cbTarefaResponsavel;
	@FXML
	private ComboBox<String> cbTarefaDificuldade;
	@FXML
	private DatePicker dpTarefaPrazoFinal;
	@FXML 
	private Button btTarefaSalvar;
	@FXML
	private Button btTarefaCancelar; 
}
