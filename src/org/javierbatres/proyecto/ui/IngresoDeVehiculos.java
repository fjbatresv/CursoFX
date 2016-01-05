package org.javierbatres.proyecto.ui;
import org.javierbatres.proyecto.bean.Usuario;
import org.javierbatres.proyecto.bean.Vehiculo;
import org.javierbatres.proyecto.modelos.ModeloUsuario;
import org.javierbatres.proyecto.modelos.ModeloVehiculos;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IngresoDeVehiculos{
	final Stage primaryStage = new Stage();
	public IngresoDeVehiculos(){
		//VBox
		Scene scene = new Scene(new VBox() , 400 , 400);
		//Grid
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(0, 0, 0, 0));
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setVisible(true);
		//Labels
		final Label lblPlaca = new Label("Numero De Placa(*):");
		final Label lblMarca = new Label("Marca(*):");
		final Label lblModelo = new Label("Modelo(*):");
		final Label lblDuenio = new Label("Dueño:(*)");
		//TextFields
		final TextField txtPlaca = new TextField();
		final TextField txtMarca = new TextField();
		final TextField txtModelo = new TextField();
		//PromptText
		txtPlaca.setPromptText("No. de Placa");
		txtMarca.setPromptText("Marca del Vehiculo");
		txtModelo.setPromptText("Modelo del Vehiculo");
		//ComboBox
		 final ComboBox duenio = new ComboBox(
					FXCollections.observableArrayList(
							"1234567890" , "Inventario" , "Facturas" , "Clientes"
					)
			);
	        duenio.setPromptText("Dueño del Vehiculo");
	        duenio.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);  
	    //Buttons
	    final Button btnGuardar = new Button("Guardar");
	    final Button btnCancelar = new Button("Cancelar");
	    final Button btnNuevoCliente = new Button("Nuevo Cliente");
	    //Effects
	    final Reflection reflection = new Reflection();
	    //effects in buttons
	    btnGuardar.setEffect(reflection);
	    btnCancelar.setEffect(reflection);
	    btnNuevoCliente.setEffect(reflection);
	    //Actions
	    btnGuardar.setOnAction(new EventHandler<ActionEvent>(){
	    	public void handle(ActionEvent e){
	    			if(txtMarca.getText() != null && txtModelo.getText() != null &&
	    			txtPlaca.getText() != null){
	    				ModeloVehiculos modelo = new ModeloVehiculos();
						modelo.agregar(new Vehiculo(0 ,txtMarca.getText(), txtModelo.getText() , txtPlaca.getText() , (String) duenio.getValue()));
		    			System.out.println("Guarda!!");
		    			primaryStage.close();
		    		}else{
		    			new ReviseDatos();
		    		}
	    	}
	    });
	    btnCancelar.setOnAction(new EventHandler<ActionEvent>(){
	    	public void handle(ActionEvent e){
	    		primaryStage.close();
	    	}
	    });
	    btnNuevoCliente.setOnAction(new EventHandler<ActionEvent>(){
	    	public void handle(ActionEvent e){
	    		new AgregarCliente();
	    	}
	    });
	    //TilePane
	    TilePane tile = new TilePane(Orientation.HORIZONTAL);
        tile.setPadding(new Insets(0, 0, 0, 0));
        tile.setHgap(0.0);
        tile.setVgap(8.0);
        tile.setAlignment(Pos.CENTER);
        //tab
        BorderPane borderPane = new BorderPane();
        final TabPane tabPane = new TabPane();
        tabPane.setPrefSize(400, 400);
        tabPane.setSide(Side.TOP);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        final Tab tab1 = new Tab();
        tab1.setText("Ingreso De Vehiculos");
        tabPane.getTabs().addAll(tab1);
        borderPane.setCenter(tabPane);
        //adding to the tiles
        tile.getChildren().addAll(lblPlaca , txtPlaca , lblMarca , txtMarca , lblModelo , txtModelo , lblDuenio , duenio  ,btnNuevoCliente , btnGuardar , btnCancelar);
        //adding to the tabs
        tab1.setContent(tile);
        //adding to the grid
        grid.add(borderPane , 0 ,0);
	    //adding to VBox
		((VBox)scene.getRoot()).getChildren().addAll(grid);
		//Controlling the Stage
		primaryStage.setTitle("Ingreso de Vehiculos");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	
}
