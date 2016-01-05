package org.javierbatres.proyecto.ui;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class ContraIncorrecta {
	public ContraIncorrecta(){
		final Stage primaryStage = new Stage();
		final Label mensaje = new Label("Contraseña o Usuario Incorrecto");
		final Button btnAceptar = new Button("Aceptar");
		Reflection reflection = new Reflection();
		btnAceptar.setEffect(reflection);
		btnAceptar.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				primaryStage.close();
			}
		});
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(0, 0, 0, 0));
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setVisible(true);
		grid.add(mensaje , 0 , 0);
		grid.add(btnAceptar , 0 , 1);
		grid.setAlignment(Pos.CENTER);
		primaryStage.setScene(new Scene(grid , 180 , 50));
		primaryStage.show();
	}
}
