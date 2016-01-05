package org.javierbatres.proyecto.ui;
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
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class VentanaBusquedaAva{
	final Stage primaryStage = new Stage();
	public VentanaBusquedaAva(){
		//VBox
		Scene scene = new Scene(new VBox() , 400 , 400);
		//Tiletab1:
		TilePane tileUsuarios = new TilePane(Orientation.HORIZONTAL);
        tileUsuarios.setPadding(new Insets(0, 0, 0, 0));
        tileUsuarios.setHgap(0.0);
        tileUsuarios.setVgap(8.0);
        tileUsuarios.setAlignment(Pos.CENTER);
      //Tiletab2:
      	TilePane tile2 = new TilePane(Orientation.HORIZONTAL);
        tile2.setPadding(new Insets(0, 0, 0, 0));
        tile2.setHgap(0.0);
        tile2.setVgap(8.0);
        tile2.setAlignment(Pos.CENTER);
      //Tiletab3:
      	TilePane tile3 = new TilePane(Orientation.HORIZONTAL);
        tile3.setPadding(new Insets(0, 0, 0, 0));
        tile3.setHgap(0.0);
        tile3.setVgap(8.0);
        tile3.setAlignment(Pos.CENTER);
      //Tiletab4:
      	TilePane tile4 = new TilePane(Orientation.HORIZONTAL);
        tile4.setPadding(new Insets(0, 0, 0, 0));
        tile4.setHgap(0.0);
        tile4.setVgap(8.0);
        tile4.setAlignment(Pos.CENTER);
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
        tab1.setText("Usuarios");
        final Tab tab2 = new Tab();
        tab2.setText("Inventario");
        final Tab tab3 = new Tab();
        tab3.setText("Facturas");
        final Tab tab4 = new Tab();
        tab4.setText("Clientes");
        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
        borderPane.setCenter(tabPane);
        //Labels:
        final Label lblUsuario = new Label("Usuario:");
        final Label lblTipo = new Label("Tipo De Usuario:");
        final Label lblId = new Label("ID Producto:");
        final Label lblNombre = new Label("Nombre De Producto:");
        final Label lblMarca = new Label("Marca:");
        final Label lblNum = new Label("Numero De Factura:");
        final Label lblNombreCliente = new Label("Nombre Del Cliente\n a quien se emitio");
        final Label lblFecha = new Label("Fecha De Emision:");
        final Label lblNombreC = new Label("Nombre Del Cliente:");
        final Label lblDPI = new Label("DPI Del Cliente:");
        final Label lblNit = new Label("NIT Del Cliente:");
        //textfields
        final TextField txtUsuario = new TextField();
        final TextField txtTipo = new TextField();
        final TextField txtId = new TextField();
        final TextField txtNombre = new TextField();
        final TextField txtMarca = new TextField();
        final TextField txtNum = new TextField();
        final TextField txtNombreCliente = new TextField();
        final TextField txtFecha = new TextField();
        final TextField txtNombreC = new TextField();
        final TextField txtDPI = new TextField();
        final TextField txtNit = new TextField();
        txtUsuario.setPromptText("Usuario");
        txtTipo.setPromptText("Tipo de Usuario");
        txtId.setPromptText("ID de Producto");
        txtNombre.setPromptText("Nombre del Producto");
        txtMarca.setPromptText("Marca del Producto");
        txtNum.setPromptText("Numero de Factura");
        txtNombreCliente.setPromptText("Nombre del Cliente");
        txtFecha.setPromptText("Fecha de Emision");
        txtDPI.setPromptText("DPI del Cliente");
        txtNit.setPromptText("Numero de Nit del  Cliente");
        txtNombreC.setPromptText("Nombre del Cliente");
        //botones
        Reflection reflection = new Reflection();
        final Button btnBuscar1 = new Button("Buscar");
        btnBuscar1.setEffect(reflection);
        final Button btnBuscar2 = new Button("Buscar");
        btnBuscar2.setEffect(reflection);
        final Button btnBuscar3 = new Button("Buscar");
        btnBuscar3.setEffect(reflection);
        final Button btnBuscar4 = new Button("Buscar");
        btnBuscar4.setEffect(reflection);
        //añadiendo a los tile
        tileUsuarios.getChildren().addAll(lblUsuario , txtUsuario , lblTipo , txtTipo , btnBuscar1);
        tile2.getChildren().addAll(lblId , txtId , lblNombre , txtNombre , lblMarca , txtMarca , btnBuscar2);
        tile3.getChildren().addAll(lblNum , txtNum , lblFecha , txtFecha , lblNombreCliente , txtNombreCliente , btnBuscar3);
        tile4.getChildren().addAll(lblNombreC , txtNombreC , lblDPI , txtDPI , lblNit , txtNit , btnBuscar4);
        //añadiendo a los tabs
        tab1.setContent(tileUsuarios);
        tab2.setContent(tile2);
        tab3.setContent(tile3);
        tab4.setContent(tile4);
        //añadiendo a grid
        grid.add(borderPane ,0 ,0);
        grid.setAlignment(Pos.TOP_LEFT);
        primaryStage.setResizable(false);
		primaryStage.setTitle("Busqueda Avanzada");
		((VBox)scene.getRoot()).getChildren().addAll(grid);
		((VBox)scene.getRoot()).setStyle("-fx-background-color: #336690");
		primaryStage.setScene(scene);
        primaryStage.show();
	}

}
