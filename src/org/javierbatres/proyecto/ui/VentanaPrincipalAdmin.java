package org.javierbatres.proyecto.ui;
import org.javierbatres.proyecto.manejadores.ManejadorBusquedas;
import org.javierbatres.proyecto.manejadores.ManejadorUsuario;
import org.javierbatres.proyecto.sistema.SistemaCliente;
import org.javierbatres.proyecto.sistema.SistemaServidor;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
public class VentanaPrincipalAdmin{
	final Stage primaryStage = new Stage();
	public VentanaPrincipalAdmin(){
		//menu superior
		MenuBar barra = new MenuBar();
		Menu archivo = new Menu("Archivo");
		MenuItem salir = new MenuItem("Salir");
		Menu usuarios = new Menu("Usuarios");
		MenuItem agregar = new MenuItem("Agregar");
		salir.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				primaryStage.close();
				new Login();
				
			}
		});
		agregar.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				new VentanaAgregarUsuario();
			}
		});
		usuarios.getItems().addAll(agregar);
		archivo.getItems().addAll(salir);
		barra.getMenus().addAll(archivo , usuarios);
		//VBox
		Scene scene = new Scene(new VBox() , 0 , 0);
		//declarando Grid
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(0, 0, 0, 0));
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setVisible(true);
        //botones
        Button btnAgregar = new Button("Agregar");
        Button btnAgrega = new Button("Agregar");
        Button btnEliminar = new Button("Eliminar");
        Button btnModificar = new Button("Modificar");
        Button btnElimina = new Button("Eliminar");
        Button btnSalir = new Button("Salir");
        Button btnBuscar = new Button("Buscar");
        Button btnChat = new Button("Chat!");
        Button btnBuscaradv = new Button("Busqueda Avanazada");
        btnAgregar.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnSalir.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnEliminar.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnChat.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //Tile pane Usuarios(tiene que haver uno por cada plaza del acordeon)
        TilePane tileUsuarios = new TilePane(Orientation.VERTICAL);
        tileUsuarios.setPadding(new Insets(0, 0, 0, 0));
        tileUsuarios.setHgap(0.0);
        tileUsuarios.setVgap(8.0);
        tileUsuarios.getChildren().addAll(btnAgregar , btnEliminar , btnModificar);
        //tilePane cliente
        TilePane tileCliente = new TilePane(Orientation.VERTICAL);
        tileCliente.setPadding(new Insets(0, 0, 0, 0));
        tileCliente.setHgap(0.0);
        tileCliente.setVgap(8.0);
        tileCliente.getChildren().addAll(btnElimina);
        //tilePane Stock
        TilePane tileInventario = new TilePane(Orientation.VERTICAL);
        tileInventario.setPadding(new Insets(0, 0, 0, 0));
        tileInventario.setHgap(0.0);
        tileInventario.setVgap(8.0);
        tileInventario.getChildren().addAll(btnAgrega);
        //Tile Pane Cuenta
        TilePane tileCuenta = new TilePane(Orientation.VERTICAL);
        tileCuenta.setPadding(new Insets(0, 0, 0, 0));
        tileCuenta.setHgap(0.0);
        tileCuenta.setVgap(8.0);
        tileCuenta.getChildren().addAll(btnSalir);
        //acordion
        TitledPane t1 = new TitledPane("Manejar Usuarios", tileUsuarios);
        TitledPane t2 = new TitledPane("Cliente", tileCliente);
        TitledPane t3 = new TitledPane("Inventario", tileInventario);
        TitledPane t5 = new TitledPane("opciones de Cuenta" , tileCuenta);
        Accordion accordion = new Accordion();
        accordion.getPanes().add(t1);
        accordion.getPanes().add(t2);
        accordion.getPanes().add(t3);
        accordion.getPanes().add(t5);
      //combobox busqueda
        final ComboBox opciones = new ComboBox(
				FXCollections.observableArrayList(
						"Usuarios" , "Inventario" , "Facturas" , "Clientes","Vehiculos" ,"Servicio","Venta","Orden de trabajo",
						"Reportes"
				)
		);
        opciones.setPromptText("Lugar de Busqueda");
        opciones.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //Campo de busqueda
        final TextField txtBuscar = new TextField();
        txtBuscar.setPromptText("Ingrese Palabra Clave");
        //Funciones de los botones
        btnAgrega.setOnAction(new EventHandler<ActionEvent>(){
        	public void handle(ActionEvent e){
        		new AgregarStock();
        	}
        });
        btnAgregar.setOnAction(new EventHandler<ActionEvent>(){
        	public void handle(ActionEvent e){
        		new VentanaAgregarUsuario();
        	}
        });
        btnSalir.setOnAction(new EventHandler<ActionEvent>(){
        	public void handle(ActionEvent e){
        		primaryStage.close();
        		new Login();
        	}
        });
        btnBuscaradv.setOnAction(new EventHandler<ActionEvent>(){
        	public void handle(ActionEvent e){
        		new VentanaBusquedaAva();
        	}
        });
        btnBuscar.setOnAction(new EventHandler<ActionEvent>(){
        	public void handle(ActionEvent e){
        		if(opciones.getValue() == "Usuarios"){
        			ManejadorBusquedas.getInstancia().busquedaSimpleUsuarios(txtBuscar.getText());
        		}else if(opciones.getValue() == "Inventario"){
        			ManejadorBusquedas.getInstancia().busquedaSimpleStock(txtBuscar.getText());
        		}else if(opciones.getValue() == "Facturas"){
        			ManejadorBusquedas.getInstancia().busquedaSimpleFactura(txtBuscar.getText());
        		}else if(opciones.getValue() == "Clientes"){
        			ManejadorBusquedas.getInstancia().busquedaSimpleClientes(txtBuscar.getText());
        		}else if(opciones.getValue() == "Vehiculos"){
        			ManejadorBusquedas.getInstancia().busquedaSimpleVehiculos(txtBuscar.getText());
        		}else if(opciones.getValue() == "Servicio"){
        			ManejadorBusquedas.getInstancia().busquedaSimpleServicio(txtBuscar.getText());
        		}else if(opciones.getValue() == "Venta"){
        			ManejadorBusquedas.getInstancia().busquedaSimpleVenta(txtBuscar.getText());
        		}else if(opciones.getValue() == "Ordende Trabajo"){
        			ManejadorBusquedas.getInstancia().busquedaSimpleOrden(txtBuscar.getText());
        		}else if(opciones.getValue() == "Reportes"){
        			ManejadorBusquedas.getInstancia().busquedaSimpleReporte(txtBuscar.getText());
        		}
        	}
        });
        btnElimina.setOnAction(new EventHandler<ActionEvent>(){
        	public void handle(ActionEvent e){
        		new VentanaEliminarCliente();
        	}
        });
        btnEliminar.setOnAction(new EventHandler<ActionEvent>(){
        	public void handle(ActionEvent e){
        		new VentanaEliminarUsuario();
        	}
        });
        btnChat.setOnAction(new EventHandler<ActionEvent>(){
        	public void handle(ActionEvent e){
        		new SistemaServidor().activar();
        	}
        });
		//Labels:
		Label lblBienvenido = new Label("Bienvenid@, "+ManejadorUsuario.getInstancia().getUsuario().getNick());
		lblBienvenido.setStyle("-fx-font-size: 15pt;");
		Label lblBuscar = new Label("Buscar:");
		Image imagen = new Image("org/javierbatres/proyecto/recursos/logologin.png");
		 final ImageView cloud = new ImageView(imagen);
	        GridPane.setConstraints(cloud, 0, 0);
		//añadir a grid
		//grid.add(cloud , 1 ,10);
	    grid.add(accordion , 0, 10);
	    grid.add(lblBuscar ,0 ,11);
	    grid.add(opciones , 0 ,12);
	    grid.add(txtBuscar , 0 ,13);
	    grid.add(btnBuscar , 0 ,14);
	    grid.add(btnBuscaradv ,0 ,15);
	    grid.add(btnChat , 0 , 16);
		grid.add(lblBienvenido , 200 , 5);
		//medidas del stage
		primaryStage.setTitle("Administrador");
		((VBox)scene.getRoot()).setStyle("-fx-background-color: #336690");
		((VBox)scene.getRoot()).getChildren().addAll(barra , grid );
		primaryStage.setScene(scene);
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		primaryStage.setX(bounds.getMinX());
		primaryStage.setY(bounds.getMinY());
		primaryStage.setWidth(bounds.getWidth());
		primaryStage.setHeight(bounds.getHeight());
		primaryStage.show();
	}
}
