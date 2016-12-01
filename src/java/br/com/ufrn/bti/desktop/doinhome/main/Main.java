package br.com.ufrn.bti.desktop.doinhome.main;

import java.io.IOException;

import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.views.LoginViewController;
import br.com.ufrn.bti.desktop.doinhome.views.TarefasUsuarioListagemViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;

	public static void main(String[] args) {
		// TODO Auto-generated method stubargs) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("DoInHome");
		showLogin();
	}

	public void showLogin(){
		try {
			// Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../views/Login.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("DoInHome - Login");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Define a pessoa no controller.
			LoginViewController controller = loader.getController();
			controller.setStage(dialogStage);
			controller.setMain(this);

			// Mostra a janela e espera até o usuário fechar.
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showListagemTarefasUsuario(Usuario usuarioLogado){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../views/TarefasUsuarioListagemNew.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("DoInHome - Veja suas tarefas");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			TarefasUsuarioListagemViewController controller = new TarefasUsuarioListagemViewController(usuarioLogado);
			controller = loader.getController();
			controller.setUsuarioLogado(usuarioLogado);
			controller.setStage(dialogStage);
			controller.setMain(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
