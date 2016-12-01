package br.com.ufrn.bti.desktop.doinhome.views;

import java.io.IOException;

import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContainerController {
	private BorderPane container;
	private Usuario usuarioLogado;
	
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Container.fxml"));
            container = (BorderPane) loader.load();
            Scene scene = new Scene(container);
            
			stage.setScene(scene);
			stage.setTitle("DoInHome");
			stage.show();
			
			mostrarListaTarefasUsuario();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setUsuarioLogado(Usuario u) {
		usuarioLogado = u;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public void mostrarListaTarefasUsuario() throws IOException{
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContainerController.class.getResource("TarefasUsuarioListagem.fxml"));
        AnchorPane conteudo = (AnchorPane) loader.load();
        container.setCenter(conteudo);
        
        TarefasUsuarioListagemViewController tarefasController = loader.getController();
        tarefasController.setContainerController(this);
	}
	
}
