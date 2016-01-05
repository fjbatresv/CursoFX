package org.javierbatres.proyecto.manejadores;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.jvnet.substance.SubstanceLookAndFeel;
//import org.javierbatres.proyecto.iu.VentanaVistaDeUsuarios;
import org.javierbatres.proyecto.bean.Stock;
import org.javierbatres.proyecto.bean.Usuario;
import org.javierbatres.proyecto.conexion.Conexion;
public class ManejadorStock {
	private ArrayList<Stock> lista;
	private static ManejadorStock instancia;
	public static ManejadorStock getInstancia(){
		if(instancia == null){
			instancia = new ManejadorStock();
		}
		return instancia;
	}
	public ManejadorStock(){
		lista = new ArrayList<Stock>();
	}
	public void agregar(Stock stock){
		Conexion.getInstancia().
			ejecutarSentencia("exec InsertarStock '" + 
					stock.getTipo() + "', '"+stock.getMarca()+"', '" + stock.getDatos() + "', '"+stock.getExistencia() + "' , '"+ stock.getPrecio() + "', '" + stock.getIdUsuario() + "'");
	}
	public ArrayList<Stock> consultarStock(){
		ArrayList<Stock> resultado = new ArrayList<Stock>();
		
		try{
			ResultSet datos = Conexion.getInstancia().
				hacerConsulta("SELECT * FROM Usuario");
			while(datos.next()){
				resultado.add(new Stock(datos.getInt("id"),
						datos.getString("tipo") ,datos.getString("marca"),datos.getString("datos"), datos.getInt("existencia") , datos.getInt("precio") , 
						datos.getInt("idUsuario")));
				
			}
		}catch(SQLException e){
			System.out.println("Conexion Imposible");
		}
		return resultado;
	}
}
