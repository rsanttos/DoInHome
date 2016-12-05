package br.com.ufrn.bti.desktop.doinhome.views;

import java.io.IOException;
import java.util.Comparator;
import java.util.Date;

import br.com.ufrn.bti.desktop.doinhome.dominio.Tarefa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.main.GestureEvents.Person;
import br.com.ufrn.bti.desktop.doinhome.servico.TarefaService;
import br.com.ufrn.bti.desktop.doinhome.servico.UsuarioService;
import br.com.ufrn.bti.desktop.doinhome.util.Alerta;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.util.Callback;

public class TarefasUsuarioListagemViewController {
	private ObservableList<Tarefa> tarefasList = FXCollections.observableArrayList();
	private TarefaService tarefaService = new TarefaService();
	private Usuario usuarioLogado;
	private ContainerController containerController = new ContainerController();

	@FXML
	private TableView<Tarefa> tvTarefasUsuario;
	@FXML
	private TableColumn<Tarefa, String> tcDescricaoTarefa;
	@FXML
	private TableColumn<Tarefa, Date> tcDataFimTarefa;
	@FXML
	private TableColumn<Tarefa, Tarefa> tcAcoesTarefa;

	public TarefasUsuarioListagemViewController() {
		tvTarefasUsuario = new TableView<Tarefa>();
		tcDescricaoTarefa = new TableColumn<>();
		tcDataFimTarefa = new TableColumn<>();
		tcAcoesTarefa = new TableColumn<>();
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario u) {
		this.usuarioLogado = u;
	}

	@SuppressWarnings("unchecked")
	@FXML
	private void initialize() {
		tcDescricaoTarefa.setCellValueFactory(cellData -> cellData.getValue().getDescricaoProperty());
		tcDataFimTarefa.setCellValueFactory(cellData -> cellData.getValue().getDataLimiteProperty());

		tcAcoesTarefa.setMinWidth(150);
		tcAcoesTarefa.setCellValueFactory(new Callback<CellDataFeatures<Tarefa, Tarefa>, ObservableValue<Tarefa>>() {
			@Override
			public ObservableValue<Tarefa> call(CellDataFeatures<Tarefa, Tarefa> features) {
				return new ReadOnlyObjectWrapper(features.getValue());
			}
		});
		tcAcoesTarefa.setCellFactory(new Callback<TableColumn<Tarefa, Tarefa>, TableCell<Tarefa, Tarefa>>() {
			@Override
			public TableCell<Tarefa, Tarefa> call(TableColumn<Tarefa, Tarefa> tcAcoesTarefa) {
				return new TableCell<Tarefa, Tarefa>() {
					final ImageView buttonGraphic = new ImageView();
					final Button button = new Button();
					{
						button.setGraphic(buttonGraphic);
						button.setMinWidth(130);
					}

					@Override
					public void updateItem(final Tarefa tarefa, boolean empty) {
						super.updateItem(tarefa, empty);
						if (tarefa != null) {
							button.setText("Finalizar");

							setGraphic(button);
							button.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									tarefa.setAtiva(false);
									tarefa.setDataFinalizacao(new Date());
									tarefaService.salvarOuAtualizar(tarefa);
									Alerta.mostrarAlertaSimples("Pronto!",
											"Você finalizou a tarefa, seus pontos foram guardados.");
									try {
										containerController.mostrarTarefasAbertasDoUsuario();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							});
						} else {
							setGraphic(null);
						}
					}
				};
			}
		});
		tvTarefasUsuario.setRowFactory(tv -> {
		    TableRow<Tarefa> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (! row.isEmpty() && event.getButton()==MouseButton.PRIMARY 
		             && event.getClickCount() == 2) {

		            Tarefa tarefaSelecionada = row.getItem();
		            try {
						containerController.mostrarTelaDeEdicaoDeTarefa(tarefaSelecionada);;
					} catch (IOException e) {
						e.printStackTrace();
					}		            
		        }
		    });
		    return row ;
		});
	}

	public void setContainerController(ContainerController c) {
		this.containerController = c;
		tvTarefasUsuario.setItems(tarefasList);
	}

	public void populaTabela() {
		tarefasList = FXCollections
				.observableList(tarefaService.listarTarefasPendentesUsuario(this.getUsuarioLogado()));
	}
}
