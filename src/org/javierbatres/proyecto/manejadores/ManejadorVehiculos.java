package org.javierbatres.proyecto.manejadores;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.javierbatres.proyecto.bean.Usuario;
import org.javierbatres.proyecto.bean.Vehiculo;
import org.javierbatres.proyecto.conexion.Conexion;
import org.javierbatres.proyecto.ui.ContraIncorrecta;
import org.javierbatres.proyecto.ui.VentanaPrincipalAdmin;
import org.javierbatres.proyecto.ui.VentanaPrincipalEmp;
public class ManejadorVehiculos {
	private ArrayList<Vehiculo> lista;
	private static ManejadorVehiculos instancia;
	public static ManejadorVehiculos getInstancia(){
		if(instancia == null){
			instancia = new ManejadorVehiculos();
		}
		return instancia;
	}
	public ManejadorVehiculos(){
		lista = new ArrayList<Vehiculo>();
	}
	public void agregar(Vehiculo vehiculo){
		Conexion.getInstancia().
			ejecutarSentencia("exec InsertarVehiculo '" + 
					vehiculo.getMarca() + "', '" + vehiculo.getModelo() + "' , '"+ vehiculo.getPlaca() + "', '" + vehiculo.getDpi() + "'");
	}
	public void eliminar(Vehiculo vehiculo){
		Conexion.getInstancia().ejecutarSentencia("exec EliminarVehiculo '"+vehiculo.getPlaca() +"'");
	}
	public Vehiculo buscar(String nombre, String pass , String placa){
		Vehiculo resultado = null;
		for(Vehiculo elemento : lista){
			if(elemento.getMarca() == nombre && elemento.getModelo() == pass && elemento.getPlaca() == placa){
				resultado = elemento;
				break;
			}
		}
		return resultado;
	}
	public ArrayList<Vehiculo> consultarVehiculos(){
		ArrayList<Vehiculo> resultado = new ArrayList<Vehiculo>();
		
		try{
			ResultSet datos = Conexion.getInstancia().
				hacerConsulta("SELECT * FROM Vehiculo");
			while(datos.next()){
				resultado.add(new Vehiculo(datos.getInt("id"),
						datos.getString("marca") , datos.getString("modelo") , datos.getString("placa") , 
						datos.getString("dpi")));
				
			}
		}catch(SQLException e){
			System.out.println("Conexion Imposible");
		}
		return resultado;
	}
	private Vehiculo usuario = null;
	public Vehiculo getUsuario(){
		return usuario;
	}
	public boolean autenticarUsuario(String usuario, String pass , String placa){
		ResultSet resultado = Conexion.getInstancia().hacerConsulta("SELECT Vehiculo.marca , Vehiculo.modelo , Vehiculo.placa , Vehiculo.dpi , vehiculo.idVehiculo FROM Vehiculo WHERE 	Vehiculo.marca = '"+usuario+"' AND Vehiculo.modelo = '"+pass+"' AND Vehiculo.placa = '" +placa+"'"  );
		try {
			if(resultado != null){
				while(resultado.next()){
					this.usuario = new Vehiculo(resultado.getInt("idVehiculo") , resultado.getString("marca"),resultado.getString("modelo"),  resultado.getString("placa") , resultado.getString("dpi"));
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
