package org.javierbatres.proyecto.ui;
import java.net.Socket;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.javierbatres.proyecto.bean.Usuario;
import org.javierbatres.proyecto.manejadores.ManejadorUsuario;
import org.javierbatres.proyecto.modelos.ModeloUsuario;
import org.javierbatres.proyecto.rmi.Cliente;
public class VentanaAgregarUsuario{
		private Stage primaryStage = new Stage();
		public VentanaAgregarUsuario(){
				//Creando Contenedor(Frame)
				GridPane grid = new GridPane();
				grid.setPadding(new Insets(10, 10, 10, 10));
				grid.setVgap(5);
				grid.setHgap(5);
				grid.setVisible(true);
				//Definiedo Label de Usuario y de Password
				Label user = new Label("Usuario:");
				Label nick = new Label("Nick Name:");
				Label passw = new Label("Contraseña:");
				Label tipo = new Label("Tipo de Usuario:");
				//aqui se le llama los Labels
				grid.add(user , 0 , 1);
				grid.add(nick , 0 ,2);
				grid.add(passw , 0 , 3);
				grid.add(tipo , 0 , 4);
				//Definiedo el TextField de Usuario
				final TextField usuario = new TextField();
				usuario.setPromptText("Usuario");
				usuario.setPrefColumnCount(10);
				usuario.setText(null);
				GridPane.setConstraints(usuario, 1, 1);
				grid.getChildren().add(usuario);
				final TextField nic = new TextField();
				nic.setPromptText("NickName");
				nic.setPrefColumnCount(10);
				nic.setText(null);
				GridPane.setConstraints(nic, 1, 2);
				grid.getChildren().add(nic);
				//Definiedo el PasswordField de Contrasea con su Label
				final PasswordField pass = new PasswordField();
				pass.setPromptText("Contraseña");
				GridPane.setConstraints(pass, 1, 3);
				pass.setText(null);
				grid.getChildren().add(pass);
				//Definiedo el ComboBox de tipo de Usuario
				final ComboBox opciones = new ComboBox(
						FXCollections.observableArrayList(
								"Administrador" , "Empleado"
						)
				);
				opciones.setPromptText("Administrador");
				grid.add(opciones , 1 , 4);
				//Creando Boton Acceder
				Button submit = new Button("Guardar");
				submit.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if(opciones.getValue() == "Administrador" && pass.getText() != null && usuario.getText() != null){
							ModeloUsuario modelo = new ModeloUsuario();
							modelo.agregar(new Usuario(0 ,usuario.getText(), nic.getText() , pass.getText() , 1));
							String charla = ("El usuario: "+ManejadorUsuario.getInstancia().getUsuario().getNick()+" Ingreso al nuevo usuario con nombre:"+
									usuario.getText()+", NickName: "+nic.getText()+", con el titulo de: Administrador");
							Cliente cliente = new Cliente();
							cliente.Cliente(charla);
							primaryStage.close();
						}else if(opciones.getValue() == "Empleado" && pass.getText() != null && usuario.getText() != null){
							ModeloUsuario modelo = new ModeloUsuario();
							modelo.agregar(new Usuario(0 , usuario.getText(), nic.getText() , pass.getText() , 2));
							Socket cliente;
							cliente=new Socket();
							String charla = ("El usuario: "+ManejadorUsuario.getInstancia().getUsuario().getNick()+" Ingreso al nuevo usuario con nombre:"+
									usuario.getText()+", NickName: "+nic.getText()+", con el titulo de: Empleado. Desde ka direcion:" +cliente.getLocalAddress().getHostName() );
							Cliente client = new Cliente();
							client.Cliente(charla);
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
				primaryStage.setTitle("Agregar Usuarios");
				primaryStage.setScene(new Scene(grid, 300, 160));
				primaryStage.show();

	}
}