package org.javierbatres.proyecto.ui;

import org.javierbatres.proyecto.bean.Cliente;
import org.javierbatres.proyecto.manejadores.ManejadorCliente;
import org.javierbatres.proyecto.manejadores.ManejadorVerificador;
import org.javierbatres.proyecto.modelos.ModeloCliente;

import javafx.application.Application;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
	
public class AgregarCliente{
	final Stage primaryStage = new Stage();
	public AgregarCliente(){
		//VBox
		Scene scene = new Scene(new VBox() , 400 , 400);
		//Grid
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(0, 0, 0, 0));
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setVisible(true);
		//Labels
		final Label lblNombre = new Label("Nombre:");
		final Label lblNumero = new Label("Apellido:");
		final Label lblNit = new Label("Numero de Nit:");
		final Label lblDir = new Label("Direccion:");
		final Label lblDPI = new Label("Num. de DPI:");
        //TextFields
        final TextField txtNombre = new TextField();
        final TextField txtNumero = new TextField();
        final TextField txtNit = new TextField();
        final TextField txtDir = new TextField();
        final TextField txtDpi = new TextField();
        //setText
        txtNombre.setText(null);
        txtNumero.setText(null);
        txtNit.setText(null);
        txtDir.setText(null);
        txtDpi.setText(null);
        //setPromptText
        txtNombre.setPromptText("Nombre del Cliente");
        txtNumero.setPromptText("Apellido del Cliente");
        txtNit.setPromptText("Numero de Nit del Cliente");
        txtDir.setPromptText("Direccion");
        txtDpi.setPromptText("Numero de DPI");
        //Buttons
        final Button btnGuardar = new Button("Guardar");
	    final Button btnCancelar = new Button("Cancelar");
	    //Actions
	    btnGuardar.setOnAction(new EventHandler<ActionEvent>(){
	    	public void handle(ActionEvent e){
	    		String cedula = null;
	    		int num = -1;
		    		if(txtNombre.getText() != null && txtNumero.getText() != null && txtDpi.getText() != null){
		    			ModeloCliente modelo = new ModeloCliente();
		    				modelo.agregar(new Cliente(txtNit.getText() , txtNombre.getText() , txtNumero.getText() , txtDir.getText() , txtDpi.getText()));
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
        tab1.setText("Nuevo Cliente");
        tabPane.getTabs().addAll(tab1);
        borderPane.setCenter(tabPane);
        //adding to the tiles
        tile.getChildren().addAll(lblNombre , txtNombre , lblNumero , txtNumero , lblNit , txtNit ,
         lblDir , txtDir ,  lblDPI  , txtDpi ,
         btnGuardar , btnCancelar);
        //adding to the tabs
        tab1.setContent(tile);
        //adding to the grid
        grid.add(borderPane , 0 ,0);
	    //adding to VBox
	    ((VBox)scene.getRoot()).setStyle("-fx-background-color: #336690");
		((VBox)scene.getRoot()).getChildren().addAll(grid);
		//Controlling the Stage
		primaryStage.setTitle("Nuevo Cliente");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
        primaryStage.show();
	}
}
