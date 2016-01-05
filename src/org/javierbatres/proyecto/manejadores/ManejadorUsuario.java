package org.javierbatres.proyecto.manejadores;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.jvnet.substance.SubstanceLookAndFeel;
//import org.javierbatres.proyecto.iu.VentanaVistaDeUsuarios;
import org.javierbatres.proyecto.bean.Usuario;
import org.javierbatres.proyecto.conexion.Conexion;
import org.javierbatres.proyecto.ui.ContraIncorrecta;
import org.javierbatres.proyecto.ui.VentanaAgregarUsuario;
import org.javierbatres.proyecto.ui.VentanaLogIn;
import org.javierbatres.proyecto.ui.VentanaPrincipalAdmin;
import org.javierbatres.proyecto.ui.VentanaPrincipalEmp;
public class ManejadorUsuario {
	private ArrayList<Usuario> lista;
	private static ManejadorUsuario instancia;
	public static ManejadorUsuario getInstancia(){
		if(instancia == null){
			instancia = new ManejadorUsuario();
		}
		return instancia;
	}
	public ManejadorUsuario(){
		lista = new ArrayList<Usuario>();
	}
	public void agregar(Usuario usuario){
		Conexion.getInstancia().
			ejecutarSentencia("exec InsertarUsuario '" + 
					usuario.getNombre() + "', '" +usuario.getNick() + "' , '"+ usuario.getPass() + "', '" + usuario.getIdTipoDeUsuario () + "'");
	}
	public void eliminar(Usuario usuario){
		Conexion.getInstancia().ejecutarSentencia("exec EliminarUsuario '"+usuario.getNick()+"'");
	}
	public Usuario buscar(String nombre, String pass){
		Usuario resultado = null;
		for(Usuario elemento : lista){
			if(elemento.getNombre() == nombre && elemento.getPass() == pass){
				resultado = elemento;
				break;
			}
		}
		return resultado;
	}
	public void logeo(Usuario usuario){
		for(Usuario elemento : lista){
			if(elemento.getNombre() == usuario.getNombre() && elemento.getPass() == usuario.getPass()
				 && elemento.getIdTipoDeUsuario() == 1){
				SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
				//new VentanaVistaDeUsuarios();
				break;
			}
		}
	}
	public void buscar(Usuario usuario){
		Conexion.getInstancia().
		ejecutarSentencia("SELECT " + usuario.getNombre() + ", " + usuario.getPass() + "FROM Usuario");
		if(usuario.getNombre() != null && usuario.getPass() != null){
			
		}	
	}
	public ArrayList<Usuario> consultarUsuarios(){
		ArrayList<Usuario> resultado = new ArrayList<Usuario>();
		
		try{
			ResultSet datos = Conexion.getInstancia().
				hacerConsulta("SELECT * FROM Usuario");
			while(datos.next()){
				resultado.add(new Usuario(datos.getInt("id"),
						datos.getString("nombreU") , datos.getString("nickName") , datos.getString("pass") , 
						datos.getInt("idTipoUsuario")));
				
			}
		}catch(SQLException e){
			System.out.println("Conexion Imposible");
		}
		return resultado;
	}
	private Usuario usuario = null;
	public Usuario getUsuario(){
		return usuario;
	}
	public boolean autenticarUsuario(String usuario, String pass){
		final Label message = new Label();
		ResultSet resultado = Conexion.getInstancia().hacerConsulta("SELECT Usuario.nombreU , Usuario.nickName , Usuario.pass , Usuario.idUsuario , Usuario.idTipoUsuario FROM Usuario WHERE 	Usuario.nombreU = '"+usuario+"' AND Usuario.pass = '"+pass+"'");
		try {
			if(resultado != null){
				while(resultado.next()){
					this.usuario = new Usuario(resultado.getInt("idUsuario"),resultado.getString("nombreU"),  resultado.getString("nickName") , resultado.getString("pass") , resultado.getInt("idTipoUsuario"));
			         if(getInstancia().getUsuario().getIdTipoDeUsuario() == 1){
			        	 new VentanaPrincipalAdmin();
			         }else if(getInstancia().getUsuario().getIdTipoDeUsuario() == 2){
			        	 new VentanaPrincipalEmp();
			         }
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