package org.javierbatres.proyecto.sistema;
import javax.swing.JFrame;
import org.javierbatres.proyecto.chat.Servidor;
public class SistemaServidor{
public void activar(){
Servidor servidor = new Servidor(); // create server
//servidor.dispose();
servidor.iniciarServidor(); // run server application
} // end main
}