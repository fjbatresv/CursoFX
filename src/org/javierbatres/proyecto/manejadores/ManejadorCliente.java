package org.javierbatres.proyecto.manejadores;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.jvnet.substance.SubstanceLookAndFeel;
//import org.javierbatres.proyecto.iu.VentanaVistaDeUsuarios;
import org.javierbatres.proyecto.bean.Cliente;
import org.javierbatres.proyecto.bean.Usuario;
import org.javierbatres.proyecto.conexion.Conexion;
import org.javierbatres.proyecto.ui.ContraIncorrecta;
import org.javierbatres.proyecto.ui.VentanaAgregarUsuario;
import org.javierbatres.proyecto.ui.VentanaLogIn;
import org.javierbatres.proyecto.ui.VentanaPrincipalAdmin;
import org.javierbatres.proyecto.ui.VentanaPrincipalEmp;
public class ManejadorCliente {
	private ArrayList<Cliente> lista;
	private static ManejadorCliente instancia;
	public static ManejadorCliente getInstancia(){
		if(instancia == null){
			instancia = new ManejadorCliente();
		}
		return instancia;
	}
	public ManejadorCliente(){
		lista = new ArrayList<Cliente>();
	}
	public void agregar(Cliente cliente){
		Conexion.getInstancia().
			ejecutarSentencia("exec InsertarCliente '" + 
					cliente.getNit() + "', '" +cliente.getNombreCl() + "' , '"+ cliente.getApellidoCl() + "', '" + cliente.getDireccion() + "' , '" +cliente.getDpi()+"'");
	}
	public void eliminar(Cliente cliente){
		Conexion.getInstancia().ejecutarSentencia("exec EliminarCliente '" + cliente.getDpi() + "'");
	}
	public ArrayList<Cliente> consultarCliente(){
		ArrayList<Cliente> resultado = new ArrayList<Cliente>();
		
		try{
			ResultSet datos = Conexion.getInstancia().
				hacerConsulta("SELECT * FROM Usuario");
			while(datos.next()){
				resultado.add(new Cliente(datos.getString("nombreCl") , datos.getString("apellidoCl") , datos.getString("direccion") , 
						datos.getString("nit"),datos.getString("dpi")));
				
			}
		}catch(SQLException e){
			System.out.println("Conexion Imposible");
		}
		return resultado;
	}
	private Cliente usuario = null;
	public Cliente getUsuario(){
		return usuario;
	}
	public boolean autenticarUsuario(String usuario, String apellido , int dpi , String nit){
		final Label message = new Label();
		ResultSet resultado = Conexion.getInstancia().hacerConsulta("SELECT Cliente.nombreCl , Cliente.apellidoCl , Cliente.direccion , Cliente.nit , Cliente.dpi FROM Cliente WHERE 	Cliente.nombreCl = '"+usuario+"' AND Cliente.apellidoCl = '"+apellido+"' AND Cliente.nit = '"+nit+"' AND Cliente.dpi = '"+dpi+"'" );
		try {
			if(resultado != null){
				while(resultado.next()){
					this.usuario = new Cliente(resultado.getString("nombreCl"),  resultado.getString("apellidoCl"), resultado.getString("direccion") , resultado.getString("nit") , resultado.getString("dpi"));
			         return true;
				}
			}else{
				new ContraIncorrecta();
			}
		} catch (SQLException e) {
			System.out.println("Imposible realizar consulta");
		}
		return false;
	}
	public void desautenticarUsuario(){
		this.usuario = null;
	}
}
