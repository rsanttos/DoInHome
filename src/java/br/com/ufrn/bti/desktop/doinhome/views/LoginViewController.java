package br.com.ufrn.bti.desktop.doinhome.views;

import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.servico.UsuarioService;
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
			System.out.println("aeho");
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("Look, an Information Dialog");
			alert.setContentText("I have a great message for you!");

			alert.showAndWait();
		} else {
			System.out.println("pqp");
		}
		

		System.out.println(autentica);
		
		System.out.println(usuario.toString());
	}
}
