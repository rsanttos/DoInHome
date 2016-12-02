package br.com.ufrn.bti.desktop.doinhome.views;

import java.time.ZoneId;
import java.util.Date;

import br.com.ufrn.bti.desktop.doinhome.dominio.Tarefa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.servico.TarefaService;
import br.com.ufrn.bti.desktop.doinhome.servico.UsuarioService;
import br.com.ufrn.bti.desktop.doinhome.thread.ThreadEmail;
import br.com.ufrn.bti.desktop.doinhome.util.Alerta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TarefasCadastroEdicaoViewController {

	private Tarefa tarefa;
	private TarefaService tarefaService = new TarefaService();
	private UsuarioService usuarioService = new UsuarioService();

	private Stage stage;

	@FXML
	private TextField tfTarefaTitulo;
	@FXML
	private ComboBox<Usuario> cbTarefaResponsavel = new ComboBox<Usuario>();
	@FXML
	private ComboBox<String> cbTarefaDificuldade = new ComboBox<String>();
	@FXML
	private DatePicker dpTarefaPrazoFinal;
	@FXML
	private Button btTarefaSalvar;
	@FXML
	private Button btTarefaCancelar;

	public ObservableList<String> opcoesDificuldadeComboBox = FXCollections.observableArrayList("Fácil", "Média",
			"Difícil");
	public ObservableList<Usuario> opcoesUsuarioComboBox = FXCollections.observableArrayList(usuarioService.listar());

	public TarefasCadastroEdicaoViewController() {
		initialize();
	}

	@FXML
	private void initialize() {
		tarefa = new Tarefa();
		btTarefaCancelar = new Button();
		btTarefaSalvar = new Button();
		cbTarefaDificuldade.getItems().addAll(opcoesDificuldadeComboBox);
		cbTarefaResponsavel.getItems().addAll(opcoesUsuarioComboBox);
	}

	@FXML
	public void salvarTarefa() {
		if (validaCampos()) {
			tarefa.setAtiva(true);
			tarefa.setDataCriacao(new Date());
			tarefa.setDataFinalizacao(null);
			Date dataLimite = Date.from(dpTarefaPrazoFinal.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			tarefa.setDataLimite(dataLimite);
			tarefa.setDescricao(tfTarefaTitulo.getText());
			tarefa.setUsuario(cbTarefaResponsavel.getValue());
			tarefa.setValor(determinaDificuldade());
			tarefaService.salvarOuAtualizar(tarefa);
			
			ThreadEmail email = new ThreadEmail(tarefa.getUsuario().getPessoa().getEmail(),
					tarefa.getUsuario().getPessoa().getNome(), tarefa.getDescricao(), tarefa.getValor(), tarefa.getDataLimite());
			email.start();

			tarefa = new Tarefa();
			Alerta.mostrarAlertaSimples("Cadastro de tarefas", "A tarefa foi cadastrada com sucesso.");
		} else {
			Alerta.mostrarAlertaSimples("Cadastro de tarefas", "Você precisa informar todos os campos.");
		}
	}

	@FXML
	public void cancelar() {
		stage.close();
	}

	public int determinaDificuldade() {
		switch (cbTarefaDificuldade.getValue()) {
		case "Fácil":
			return 50;
		case "Média":
			return 75;
		case "Difícil":
			return 100;
		default:
			return 50;
		}
	}

	public boolean validaCampos() {
		if (tfTarefaTitulo.getText().equals("") || cbTarefaResponsavel.getValue() == null
				|| cbTarefaDificuldade.getValue() == null || dpTarefaPrazoFinal.getValue() == null) {
			System.out.println(tfTarefaTitulo.getText());
			System.out.println(cbTarefaResponsavel.getValue());
			System.out.println(cbTarefaDificuldade.getValue());
			System.out.println(dpTarefaPrazoFinal.getValue());
			return false;
		}
		return true;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public TarefaService getTarefaService() {
		return tarefaService;
	}

	public void setTarefaService(TarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public TextField getTfTarefaTitulo() {
		return tfTarefaTitulo;
	}

	public void setTfTarefaTitulo(TextField tfTarefaTitulo) {
		this.tfTarefaTitulo = tfTarefaTitulo;
	}

	public ComboBox<Usuario> getCbTarefaResponsavel() {
		return cbTarefaResponsavel;
	}

	public void setCbTarefaResponsavel(ComboBox<Usuario> cbTarefaResponsavel) {
		this.cbTarefaResponsavel = cbTarefaResponsavel;
	}

	public ComboBox<String> getCbTarefaDificuldade() {
		return cbTarefaDificuldade;
	}

	public void setCbTarefaDificuldade(ComboBox<String> cbTarefaDificuldade) {
		this.cbTarefaDificuldade = cbTarefaDificuldade;
	}

	public DatePicker getDpTarefaPrazoFinal() {
		return dpTarefaPrazoFinal;
	}

	public void setDpTarefaPrazoFinal(DatePicker dpTarefaPrazoFinal) {
		this.dpTarefaPrazoFinal = dpTarefaPrazoFinal;
	}

	public Button getBtTarefaSalvar() {
		return btTarefaSalvar;
	}

	public void setBtTarefaSalvar(Button btTarefaSalvar) {
		this.btTarefaSalvar = btTarefaSalvar;
	}

	public Button getBtTarefaCancelar() {
		return btTarefaCancelar;
	}

	public void setBtTarefaCancelar(Button btTarefaCancelar) {
		this.btTarefaCancelar = btTarefaCancelar;
	}

	public ObservableList<Usuario> getOpcoesUsuarioComboBox() {
		return opcoesUsuarioComboBox;
	}

	public void setOpcoesUsuarioComboBox(ObservableList<Usuario> opcoesUsuarioComboBox) {
		this.opcoesUsuarioComboBox = opcoesUsuarioComboBox;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public ObservableList<String> getOpcoesDificuldadeComboBox() {
		return opcoesDificuldadeComboBox;
	}

	public void setOpcoesDificuldadeComboBox(ObservableList<String> opcoesDificuldadeComboBox) {
		this.opcoesDificuldadeComboBox = opcoesDificuldadeComboBox;
	}

}
