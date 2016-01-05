package org.javierbatres.proyecto.chat;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.javierbatres.proyecto.manejadores.ManejadorUsuario;
public class Servidor extends JFrame{
private JTextField campoEscritura;
private JTextArea areaCharla;
private ObjectOutputStream salida;
private ObjectInputStream entrada;
private ServerSocket servicio;
private Socket conexion;
private int contador;
//Configuracion de GUI
public Servidor(){
super("Servidor");
campoEscritura = new JTextField();
campoEscritura.setEditable(false);
campoEscritura.addActionListener(
new ActionListener(){
public void actionPerformed(ActionEvent e){
enviarDatos(e.getActionCommand());
campoEscritura.setText("");
}
}
);
add(campoEscritura, BorderLayout.SOUTH);
areaCharla = new JTextArea();
add(new JScrollPane(areaCharla), BorderLayout.CENTER);
setSize(300,150);
setVisible(true);
}
public void iniciarServidor(){
try{
servicio = new ServerSocket(12346, 100);
while(true){
try{
esperarConexion();
getFlujos();
procesarConexion();
}catch(EOFException eof){
mostrarMensaje("Servidor termino la conexion");
}finally{
cerrarConexion();
contador++;
}
}
}catch(IOException io){
mostrarMensaje("");
}
}

private void esperarConexion() throws IOException{
mostrarMensaje("Esperando Conexiones");
conexion = servicio.accept();
mostrarMensaje("Coneccion "+contador+" recibida de: "+ ManejadorUsuario.getInstancia().getUsuario().getNombre());
}

private void getFlujos() throws IOException{
salida = new ObjectOutputStream(conexion.getOutputStream());
salida.flush();
entrada = new ObjectInputStream(conexion.getInputStream());
mostrarMensaje("\n Corren los Flujos de E/S \n");
}

private void procesarConexion() throws IOException{
String mensaje = "Conexion Establecida";

enviarDatos(mensaje);

setTextFieldEditable(true);

do{
try{
mensaje = (String) entrada.readObject();
mostrarMensaje("\n"+mensaje);
}catch(ClassNotFoundException cnfe){
mostrarMensaje("\n Tipo de Objeto desconocido fue recibido");
}
} while(!mensaje.equals(conexion.getInetAddress().getHostName() + ">>> FINITO" ));
}

private void cerrarConexion(){
mostrarMensaje( "\nConversacion Finalizada" );
setTextFieldEditable(false);
try{
salida.close();
entrada.close();
conexion.close();
} catch(IOException io){
mostrarMensaje("");
}
}

private void enviarDatos(String mensaje){
try{
salida.writeObject("\n"+conexion.getLocalAddress().getHostName() +">>> "+mensaje);
salida.flush();
mostrarMensaje("\n" + conexion.getLocalAddress().getHostName() + ">>> "+ mensaje);
}
catch(IOException io){
areaCharla.append("\nError al escribir el objeto");
}
}

private void mostrarMensaje(final String mensajeAmostrar){
SwingUtilities.invokeLater(new Runnable(){
public void run(){
areaCharla.append(mensajeAmostrar);
}
}
);
}

private void setTextFieldEditable(final boolean editable){
SwingUtilities.invokeLater(
new Runnable(){
public void run(){
campoEscritura.setEditable(editable);
}
}
);
}
}