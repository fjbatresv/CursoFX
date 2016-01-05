package org.javierbatres.proyecto.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ElimiminarUsuaurio extends Application{
	public static void main(String args[]){
		launch();
	}
	public void start(final Stage primaryStage){
		//VBox
		Scene scene = new Scene(new VBox() , 400 , 400);
		//Grid
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(0, 0, 0, 0));
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setVisible(true);
		//Grid
		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(25, 25, 25, 25));
		grid2.setVgap(5);
		grid2.setHgap(5);
		grid2.setVisible(true);
		//Buttons
		final Button btnEliminar = new Button("Eliminar");
		final Button btnCancelar = new Button("Cancelar");
		//Effects
		Reflection reflection = new Reflection();
		//setEffects
		btnEliminar.setEffect(reflection);
		btnCancelar.setEffect(reflection);
		//setOnAction
		btnEliminar.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				System.out.println("Eliminado");
			}
		});
		btnCancelar.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				primaryStage.close();
			}
		});
		//Table
		final ObservableList<String> data = FXCollections.observableArrayList(
	            "Jacob",     "Smith",    "jacob.smith@example.com"
	        );
	        TableColumn firstNameCol = new TableColumn();
	        firstNameCol.setText("First");
	        firstNameCol.setMinWidth(50);
	        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
	        TableColumn lastNameCol = new TableColumn();
	        lastNameCol.setText("Last");
	        lastNameCol.setMinWidth(50);
	        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
	        TableColumn emailCol = new TableColumn();
	        emailCol.setText("Email");
	        emailCol.setMinWidth(50);
	        emailCol.setCellValueFactory(new PropertyValueFactory("email"));
	        TableView tableView = new TableView();
	        tableView.setItems(data);
	        tableView.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
	        
		//TilePane
	    TilePane tile = new TilePane(Orientation.HORIZONTAL);
        tile.setPadding(new Insets(0, 0, 0, 0));
        tile.setHgap(0.0);
        tile.setVgap(8.0);
        tile.setAlignment(Pos.CENTER);
        //tab
        BorderPane borderPane = new BorderPane();
        final TabPane tabPane = new TabPane();
        tabPane.setPrefSize(700, 700);
        tabPane.setSide(Side.TOP);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        final Tab tab1 = new Tab();
        tab1.setText("Eliminar Cliente");
        tabPane.getTabs().addAll(tab1);
        borderPane.setCenter(tabPane);
        //adding to the tiles
        tile.getChildren().addAll(grid2 );
        //adding to grid2
        grid2.add(btnEliminar , 0 ,1);
        grid2.add(btnCancelar , 1 ,1);
        grid2.add(tableView , 0 , 0);
        //adding to the tabs
        tab1.setContent(tile);
        //adding to the grid
        grid.add(borderPane , 0 ,0);
	    //adding to VBox
	    ((VBox)scene.getRoot()).setStyle("-fx-background-color: #336690");
		((VBox)scene.getRoot()).getChildren().addAll(grid);
		//Controlling the Stage
		primaryStage.setTitle("Elimnar Cliente");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
        primaryStage.show();
	}
}
