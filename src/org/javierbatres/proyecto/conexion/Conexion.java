package org.javierbatres.proyecto.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Conexion {
	private Connection conexion;
	private Statement enunciado;
	private static Conexion instancia;
	public static Conexion getInstancia(){
		if(instancia == null){
			instancia = new Conexion();
		}
		return instancia;
	}
	public Conexion(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		}catch(InstantiationException e){
			System.out.println("Conexion irrealisable");
		}catch(IllegalAccessException e){
			System.out.println("Conexion irrealisable");
		}catch(ClassNotFoundException e){
			System.out.println("Conexion irrealisable");
		}
		try{
			conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:0;databaseName=Javier; user=Javier Batres;password=1yoda1");		
			enunciado = conexion.createStatement();
		}catch(SQLException e){
			System.out.println("Conexion irrealisable");
		}
	}
	public ResultSet hacerConsulta(String consulta){
		ResultSet resultado = null;
		try{
			resultado = enunciado.executeQuery(consulta);
		}catch(SQLException e){
			System.out.println("Conexion irrealisable");
		}
		return resultado;
	}
	public void ejecutarSentencia(String sentencia){
		try{
			enunciado.execute(sentencia);
		}catch(SQLException e){
			System.out.println("Conexion irrealisable");
		}
	}
}
