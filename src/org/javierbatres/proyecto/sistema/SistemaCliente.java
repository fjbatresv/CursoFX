package org.javierbatres.proyecto.sistema;
import javax.swing.JFrame;
import org.javierbatres.proyecto.chat.Cliente;
public class SistemaCliente {
public void activar () {
Cliente cliente;
cliente = new Cliente( "127.0.0.1" );
//cliente.dispose();
cliente.correrCliente();
}
}