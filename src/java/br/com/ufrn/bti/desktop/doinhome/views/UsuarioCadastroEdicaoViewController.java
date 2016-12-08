package br.com.ufrn.bti.desktop.doinhome.views;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;

import br.com.ufrn.bti.desktop.doinhome.dominio.Pessoa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.main.Main;
import br.com.ufrn.bti.desktop.doinhome.servico.PessoaService;
import br.com.ufrn.bti.desktop.doinhome.servico.UsuarioService;
import br.com.ufrn.bti.desktop.doinhome.util.Alerta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UsuarioCadastroEdicaoViewController {
	private ContainerController containerController = new ContainerController();

		@FXML
		private TextField nomeField;
		@FXML
		private TextField cpfField;
		@FXML
		private TextField sexoField;
		@FXML
		private TextField emailField;
		@FXML
		private TextField loginField;
		@FXML
		private PasswordField senhaField;
		@FXML
		private TextField permissaoField;
		@FXML
		private DatePicker dpNascimento;

		private ObservableList<String> opcoesSexoComboBox = FXCollections.observableArrayList("M", "F");
		private ObservableList<String> opcoesPermissaoComboBox = FXCollections.observableArrayList("ADMIN", "USER");
		
		@FXML
		private ComboBox<String> sexoComboBox = new ComboBox<String>();
		@FXML
		private ComboBox<String> permissaoComboBox = new ComboBox<String>();
		
		private PessoaService pessoaService;
		private UsuarioService usuarioService;
		
		

		private Stage stage;
		private boolean entrarClicked = false;
		private Main main;
		private Usuario usuario;
		
		public UsuarioCadastroEdicaoViewController() {
			usuario = new Usuario();
			pessoaService = new PessoaService();
			usuarioService = new UsuarioService();
		}
		
		@FXML
		public void cancelar() throws IOException {
			this.mostrarListagemDeUsuarios();
		}
		
		public void mostrarListagemDeUsuarios() throws IOException {
			this.containerController.mostrarListaDeUsuarios();
		}

		@FXML
		private void initialize() {
			sexoComboBox.getItems().addAll(opcoesSexoComboBox);
			permissaoComboBox.getItems().addAll(opcoesPermissaoComboBox);
		}

		public TextField getNomeField() {
			return nomeField;
		}

		public void setNomeField(TextField nomeField) {
			this.nomeField = nomeField;
		}

		public TextField getCpfField() {
			return cpfField;
		}

		public void setCpfField(TextField cpfField) {
			this.cpfField = cpfField;
		}

		public TextField getSexoField() {
			return sexoField;
		}

		public void setSexoField(TextField sexoField) {
			this.sexoField = sexoField;
		}

		public TextField getLoginField() {
			return loginField;
		}

		public void setLoginField(TextField loginField) {
			this.loginField = loginField;
		}
		
		public PasswordField getSenhaField() {
			return senhaField;
		}

		public void setSenhaField(PasswordField senhaField) {
			this.senhaField = senhaField;
		}

		public Stage getStage() {
			return stage;
		}

		public void setStage(Stage stage) {
			this.stage = stage;
		}

		public boolean isEntrarClicked() {
			return entrarClicked;
		}

		public void setEntrarClicked(boolean entrarClicked) {
			this.entrarClicked = entrarClicked;
		}

		public Main getMain() {
			return main;
		}

		public void setMain(Main main) {
			this.main = main;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public TextField getPermissaoField() {
			return permissaoField;
		}

		public void setPermissaoField(TextField permissaoField) {
			this.permissaoField = permissaoField;
		}

		public UsuarioService getUsuarioService() {
			return usuarioService;
		}

		public void setUsuarioService(UsuarioService usuarioService) {
			this.usuarioService = usuarioService;
		}

		@FXML
		public void handleCadastrar() throws ParseException {
			if(validaCampos()){
				Pessoa pessoa = new Pessoa();
				Usuario usuario = new Usuario();
				Date dataNascimento = Date.from(dpNascimento.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
				pessoa.setCpf(cpfField.getText());
				pessoa.setNome(nomeField.getText());
				pessoa.setSexo(sexoComboBox.getValue().charAt(0));
				pessoa.setDataNascimento(dataNascimento);
				pessoa.setEmail(emailField.getText());
				usuario.setLogin(loginField.getText());
				usuario.setSenha(senhaField.getText());
				usuario.setPermissao(permissaoComboBox.getValue());			
				usuario.setPessoa(pessoa);
				pessoaService.salvarOuAtualizar(pessoa);
				usuarioService.salvarOuAtualizar(usuario);
				
				Alerta.mostrarAlertaSimples("Tudo certo!", "Usuário cadastrado com sucesso.");
				
				usuario = new Usuario();
				
				stage.close();
			}
		}
		
		@FXML
	    private void handleCancelar() {
	        stage.close();
	    }
		
		public boolean validaCampos() {
			if (cpfField.getText() == null || nomeField.getText() == null || dpNascimento.getValue() == null
					|| sexoComboBox.getValue() == null || loginField.getText() == null || senhaField.getText() == null 
					|| permissaoComboBox.getValue() == null || emailField.getText() == null){
				Alerta.mostrarAlertaSimples("Campos em branco.", "Preencha todos os campos obrigatórios");
				return false;
			}
				return true;
		}
		
		public void limparCampos() {
			cpfField.clear();
			nomeField.clear();
			senhaField.clear();
			emailField.clear();
		}

		public ObservableList<String> getOpcoesSexoComboBox() {
			return opcoesSexoComboBox;
		}

		public void setOpcoesSexoComboBox(ObservableList<String> opcoesSexoComboBox) {
			this.opcoesSexoComboBox = opcoesSexoComboBox;
		}

		public ObservableList<String> getOpcoesPermissaoComboBox() {
			return opcoesPermissaoComboBox;
		}

		public void setOpcoesPermissaoComboBox(ObservableList<String> opcoesPermissaoComboBox) {
			this.opcoesPermissaoComboBox = opcoesPermissaoComboBox;
		}

		public ComboBox<String> getSexoComboBox() {
			return sexoComboBox;
		}
		
		public void setSexoComboBox(ComboBox<String> sexoComboBox) {
			this.sexoComboBox = sexoComboBox;
		}

		public ComboBox<String> getPermissaoComboBox() {
			return permissaoComboBox;
		}

		public void setPermissaoComboBox(ComboBox<String> permissaoComboBox) {
			this.permissaoComboBox = permissaoComboBox;
		}

		public DatePicker getDpNascimento() {
			return dpNascimento;
		}

		public void setDpNascimento(DatePicker dpNascimento) {
			this.dpNascimento = dpNascimento;
		}
		
}
