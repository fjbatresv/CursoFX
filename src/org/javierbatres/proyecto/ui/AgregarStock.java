package org.javierbatres.proyecto.ui;
import org.javierbatres.proyecto.bean.Stock;
import org.javierbatres.proyecto.manejadores.ManejadorUsuario;
import org.javierbatres.proyecto.modelos.ModeloStock;
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
public class AgregarStock{
	final Stage primaryStage = new Stage();
	public AgregarStock(){
		//VBox
				Scene scene = new Scene(new VBox() , 400 , 400);
				//Grid
				GridPane grid = new GridPane();
				grid.setPadding(new Insets(0, 0, 0, 0));
				grid.setVgap(5);
				grid.setHgap(5);
				grid.setVisible(true);
				//Labels
				final Label message = new Label();
				final Label lblNombre = new Label("Categoria:");
				final Label lblMarca = new Label("Marca:");
				final Label lblDatos = new Label("Datos:");
				final Label lblNumero = new Label("Existencia:");
				final Label lblNit = new Label("Precio:");
		        //TextFields
		        final TextField txtNombre = new TextField();
		        final TextField txtDatos = new TextField();
		        final TextField txtNumero = new TextField();
		        final TextField txtNit = new TextField();
		        //setText
		        txtNombre.setText(null);
		        txtDatos.setText(null);
		        txtNumero.setText(null);
		        txtNit.setText(null);
		        //setPromptText
		        txtNombre.setPromptText("Marca del Producto");
		        txtDatos.setPromptText("Datos del producto");
		        txtNumero.setPromptText("Existencia del mismo");
		        txtNit.setPromptText("Precio de venta");
		        //comboBox
		        final ComboBox categorias = new ComboBox(
						FXCollections.observableArrayList(
								"Llantas" , "Lubricantes" , "Focos" , "Filtros"
						)
				);
		        categorias.setPromptText("Categorias");
		        categorias.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);  
		        //Buttons
		        final Button btnGuardar = new Button("Guardar");
			    final Button btnCancelar = new Button("Salir");
			    //Actions
			    btnGuardar.setOnAction(new EventHandler<ActionEvent>(){
			    	public void handle(ActionEvent e){
				    		if(txtNombre.getText() != null && txtNumero.getText() != null && txtNit.getText() != null){
				    			ModeloStock modelo = new ModeloStock();
				    				modelo.agregar(new Stock(0,(String)(categorias.getValue()) , txtNombre.getText() , txtDatos.getText() ,Integer.parseInt(txtNumero.getText()) , Integer.parseInt(txtNit.getText()) , ManejadorUsuario.getInstancia().getUsuario().getId()));
				    				message.setText("Guardado");
				    				txtNombre.setText(null);
				    				txtDatos.setText(null);
				    				txtNumero.setText(null);
				    				txtNit.setText(null);
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
		        tab1.setText("Ingreso al Inventario");
		        tabPane.getTabs().addAll(tab1);
		        borderPane.setCenter(tabPane);
		        //adding to the tiles
		        tile.getChildren().addAll(lblNombre , categorias,lblMarca,txtNombre,lblDatos,txtDatos , lblNumero , txtNumero , lblNit , txtNit ,
		         btnGuardar , btnCancelar,message);
		        //adding to the tabs
		        tab1.setContent(tile);
		        //adding to the grid
		        grid.add(borderPane , 0 ,0);
			    //adding to VBox
			    ((VBox)scene.getRoot()).setStyle("-fx-background-color: #336690");
				((VBox)scene.getRoot()).getChildren().addAll(grid);
				//Controlling the Stage
				primaryStage.setTitle("Inventario");
				primaryStage.setResizable(false);
				primaryStage.setScene(scene);
		        primaryStage.show();
	}

}
