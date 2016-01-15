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
			System.out.println("Conexion irrealisable | " + e.getMessage());
		}catch(IllegalAccessException e){
			System.out.println("Conexion irrealisable | " + e.getMessage());
		}catch(ClassNotFoundException e){
			System.out.println("Conexion irrealisable | " + e.getMessage());
		}
		try{
			conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1\\SQLBATRES:0;databaseName=ProyectoFX;user=syuser;password=sypass");		
			enunciado = conexion.createStatement();
		}catch(SQLException e){
			System.out.println("Conexion irrealisable | " + e.getMessage());
		}
	}
	public ResultSet hacerConsulta(String consulta){
		ResultSet resultado = null;
		try{
			resultado = enunciado.executeQuery(consulta);
		}catch(SQLException e){
			System.out.println("Conexion irrealisable | " + e.getMessage());
		}
		return resultado;
	}
	public void ejecutarSentencia(String sentencia){
		try{
			enunciado.execute(sentencia);
		}catch(SQLException e){
			System.out.println("Conexion irrealisable | " + e.getMessage());
		}
	}
}
