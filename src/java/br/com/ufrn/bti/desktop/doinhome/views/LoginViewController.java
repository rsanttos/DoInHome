package br.com.ufrn.bti.desktop.doinhome.views;

import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.servico.UsuarioService;
import br.com.ufrn.bti.desktop.doinhome.util.Alerta;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginViewController {
	@FXML
	private TextField tfUserName;
	@FXML
	private PasswordField pfPassword;
	@FXML
	private Button btLogin;
	
	private UsuarioService usuarioService;
	
	public void login() {
		this.usuarioService = new UsuarioService();
		
		System.out.println("Tentativa de login...");
		
		Usuario usuario = new Usuario(this.tfUserName.getText(), this.pfPassword.getText());
		boolean autentica = usuarioService.autenticaUsuario(usuario);
		
		if(autentica == true){	
			Alerta.mostrarAlertaSimples("Login", "Usuário logado com sucesso!");
		} else {
			Alerta.mostrarAlertaSimples("Login", "Usuário e/ou senha incorretos!");
		}
	}
}
