package br.com.ufrn.bti.desktop.doinhome.views;

import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.main.Main;
import br.com.ufrn.bti.desktop.doinhome.servico.UsuarioService;
import br.com.ufrn.bti.desktop.doinhome.util.Alerta;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController extends GenericController {
	@FXML
	private TextField tfUserName;
	@FXML
	private PasswordField pfPassword;
	@FXML
	private Button btLogin;

	private Stage stage;
	
	private Main main;
	
	private UsuarioService usuarioService;
	
	public LoginViewController(){
		main = new Main();
		usuarioService = new UsuarioService();
	}	
	
	public void login() {
		this.usuarioService = new UsuarioService();
		
		System.out.println("Tentativa de login...");
		
		Usuario usuario = new Usuario(this.tfUserName.getText(), this.pfPassword.getText());
		
		boolean autentica = usuarioService.autenticaUsuario(usuario);
		
		if(autentica == true){
			ContainerController c = new ContainerController();
			c.setUsuarioLogado(usuario);
			c.start(new Stage());
			MainApp.primaryStage.close();
		} else {
			Alerta.mostrarAlertaSimples("Login", "Usuário e/ou senha incorretos!");
		}
	}

	public TextField getTfUserName() {
		return tfUserName;
	}

	public void setTfUserName(TextField tfUserName) {
		this.tfUserName = tfUserName;
	}

	public PasswordField getPfPassword() {
		return pfPassword;
	}

	public void setPfPassword(PasswordField pfPassword) {
		this.pfPassword = pfPassword;
	}

	public Button getBtLogin() {
		return btLogin;
	}

	public void setBtLogin(Button btLogin) {
		this.btLogin = btLogin;
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

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
}
