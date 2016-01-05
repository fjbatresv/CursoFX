package org.javierbatres.proyecto.chat;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Clientefx extends Application {
   Group root;
   Scene scene;
   TextArea outputTxt;
   TextField inputTxt;

   Socket socket;
   BufferedReader bReader;
   BufferedWriter bWriter;
   PrintWriter out = null;
   List list;

   public Clientefx() {
      try {
         socket = new Socket("127.0.0.1", 4444);

         bReader = new BufferedReader(new InputStreamReader(
               socket.getInputStream()));
         bWriter = new BufferedWriter(new OutputStreamWriter(
               socket.getOutputStream()));
         out = new PrintWriter(socket.getOutputStream(), true);

         Thread th = new Thread();
         th.start();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

   public void start(Stage stage) {
      root = new Group();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.setResizable(false);

      VBox vbox = new VBox();

      outputTxt = new TextArea();
      outputTxt.setMinSize(400, 400);
      outputTxt.setDisable(false);
      outputTxt.setEditable(false);
      outputTxt.setFocusTraversable(false);

      inputTxt = new TextField();
      inputTxt.setFocusTraversable(true);
      inputTxt.setMinSize(400, 30);
      addTxtHandler();

      vbox.getChildren().add(outputTxt);
      vbox.getChildren().add(inputTxt);

      root.getChildren().add(vbox);

      stage.addEventHandler(MouseEvent.MOUSE_MOVED,
            new EventHandler<MouseEvent>() {

               @Override
               public void handle(MouseEvent arg0) {
                  System.out.println(arg0.toString());
                  try {

                     // while (bReader.readLine() != null) {
                     // outputTxt.setText(bReader.readLine());
                     // }
                  } catch (Exception e) {
                     e.printStackTrace();
                  }
               }
            });

      stage.show();
   }

   public void addTxtHandler() {
      inputTxt.addEventHandler(KeyEvent.KEY_PRESSED,
            new EventHandler<KeyEvent>() {

               @Override
               public void handle(KeyEvent e) {
                  if (e.getCode() == KeyCode.ENTER) {
                     out.print(inputTxt.getText());
                  }
               }
            });
   }

   public static void main(String[] args) {
      launch(args);
   }

}