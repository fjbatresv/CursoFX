package org.javierbatres.proyecto.ui;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.javierbatres.proyecto.manejadores.ManejadorUsuario;
public class VentanaLogIn extends Application{
	public VentanaLogIn(){
	}
	public void start(final Stage primaryStage) throws Exception {
		//Creando Contenedor(Frame)
				GridPane grid = new GridPane();
				grid.setPadding(new Insets(10, 10, 10, 10));
				grid.setVgap(5);
				grid.setHgap(5);
				grid.setVisible(true);
				//Definiedo Label de Usuario y de Password
				Label user = new Label("Usuario:");
				Label passw = new Label("Contraseña:");
				//aqui se le llama los Label�s
				grid.add(user , 0 , 1);
				grid.add(passw , 0 , 2);
				//Definiedo el TextField de Usuario
				final TextField usuario = new TextField();
				usuario.setPromptText("Usuario");
				usuario.setPrefColumnCount(10);
				usuario.getText();
				GridPane.setConstraints(usuario, 1, 1);
				grid.getChildren().add(usuario);
				//Definiedo el TextField de Contrase�a con su Label
				final PasswordField pass = new PasswordField();
				pass.setPromptText("Contraseña");
				GridPane.setConstraints(pass, 1, 2);
				pass.getText();
				grid.getChildren().add(pass);
				//Creando Boton Acceder
				Button submit = new Button("Acceder");
				submit.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event){
						if(ManejadorUsuario.getInstancia().autenticarUsuario(usuario.getText(), pass.getText())){
							primaryStage.close();
						}else{
							pass.setText(null);
							new ContraIncorrecta();
						}
					}
				});
				GridPane.setConstraints(submit, 0, 3);
				grid.getChildren().add(submit);
				//Defining the Clear button
				Button clear = new Button("Cancel");
				clear.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event){
						System.exit(0);
					}
				});
				GridPane.setConstraints(clear, 1, 3);
				grid.getChildren().add(clear);
				grid.setAlignment(Pos.CENTER);
				primaryStage.setTitle("Logeo");
				primaryStage.setScene(new Scene(grid, 250, 130));
				primaryStage.show();
				
	}
}
