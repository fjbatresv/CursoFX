package org.javierbatres.proyecto.manejadores;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
public class ManejadorArchivos{
	private PrintWriter escritor;
	private BufferedReader lector;
	public ManejadorArchivos(String archivo){
		FileWriter escritorDeArchivo = null;
		try{
			escritorDeArchivo = new FileWriter(archivo,true);
		}catch(IOException e){
			System.out.println("Error al intentar escribir el archivo");
		}
		escritor = new PrintWriter(escritorDeArchivo,true);
	}
	public void escribir(String texto){
		escritor.println(texto+"\n");
	}
	public String leer(String archivo){
		String resultado = "";
		try{
			lector = new BufferedReader(new FileReader(archivo));
		}catch(IOException e){
			System.out.println("Error al intentar leer el archivo");
		}
		StringBuffer sb = new StringBuffer();
		String linea;
		try{
			while((linea = lector.readLine()) != null){
				sb.append(linea+"\n");
			}
		}catch(IOException e){
			System.out.println("Error al leer el archivo");
		}
		resultado = sb.toString();
		return resultado;
	}
}