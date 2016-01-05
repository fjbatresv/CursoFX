package org.javierbatres.proyecto.ui;

import org.javierbatres.proyecto.bean.Cliente;
import org.javierbatres.proyecto.bean.Vehiculo;
import org.javierbatres.proyecto.modelos.ModeloCliente;
import org.javierbatres.proyecto.modelos.ModeloVehiculos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EliminarVehiculos{
	final Stage primaryStage = new Stage();
	public EliminarVehiculos(){
		//VBox
				Scene scene = new Scene(new VBox() , 400 , 400);
				//Tiletab1:
				TilePane tileUsuarios = new TilePane(Orientation.HORIZONTAL);
		        tileUsuarios.setPadding(new Insets(0, 0, 0, 0));
		        tileUsuarios.setHgap(0.0);
		        tileUsuarios.setVgap(8.0);
		        tileUsuarios.setAlignment(Pos.CENTER);
		      //declarando Grid
				GridPane grid = new GridPane();
				grid.setPadding(new Insets(10, 10, 10, 10));
				grid.setVgap(5);
				grid.setHgap(5);
				grid.setVisible(true);
				//Declaracion de los tabs
				BorderPane borderPane = new BorderPane();
		        final TabPane tabPane = new TabPane();
		        tabPane.setPrefSize(400, 400);
		        tabPane.setSide(Side.TOP);
		        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
		        final Tab tab1 = new Tab();
		        tab1.setText("Clientes");
		      //Definiedo Label de Usuario y de Password
		        Label nick = new Label("Numero De Placa");
		      //aqui se le llama los Labels
				grid.add(nick , 0 ,2);
				final TextField nic = new TextField();
				nic.setPromptText("Placa del Vehiculo");
				nic.setPrefColumnCount(10);
				nic.setText(null);
				GridPane.setConstraints(nic, 1, 2);
				grid.getChildren().add(nic);
				//Creando Boton Acceder
				Button submit = new Button("Eliminar");
				submit.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if(nic.getText() != null){
							ModeloVehiculos modelo = new ModeloVehiculos();
							modelo.eliminar(new Vehiculo(0, null , null, nic.getText() , null));
							primaryStage.close();
						}else{
							new ReviseDatos();
						}
					}
				});
				GridPane.setConstraints(submit, 0, 5);
				grid.getChildren().add(submit);
				//Defining the Clear button
				Button clear = new Button("Cancel");
				clear.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event){
						primaryStage.close();
					}
				});
				GridPane.setConstraints(clear, 1, 5);
				grid.getChildren().add(clear);
				primaryStage.setTitle("Eliminar Clientes");
				primaryStage.setScene(new Scene(grid, 250, 120));
				primaryStage.show();
		}

	}