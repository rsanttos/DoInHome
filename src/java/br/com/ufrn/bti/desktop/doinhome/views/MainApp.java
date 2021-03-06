package br.com.ufrn.bti.desktop.doinhome.views;

import br.com.ufrn.bti.desktop.doinhome.servico.UsuarioService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private AnchorPane container;
	public static Stage primaryStage;
	private UsuarioService usuarioService = new UsuarioService();

	@Override
	public void start(Stage s) {
		primaryStage = s;
		primaryStage.setTitle("DoInHome");
		
		initRootLayout();
	}
	
	@Override
	public void stop() {
		usuarioService.fazerLogoff();
	}
	
	public void initRootLayout(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("Login.fxml"));
			container = (AnchorPane) loader.load();
			
			Scene scene = new Scene(container);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
