package org.javierbatres.proyecto.rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import org.javierbatres.proyecto.manejadores.ManejadorArchivos;
import org.javierbatres.proyecto.rmi.Interfaz;
public class Retorno extends UnicastRemoteObject implements Interfaz{
	String charla;
	private static Retorno instancia;
	public static Retorno getInstancia(){
		if(instancia == null){
			try{
				instancia = new Retorno();
			}catch(RemoteException e){
				e.printStackTrace();
			}
		}
		return instancia;
	}
	public String getCharla() {
		return charla;
	}
	public void setCharla(String charla) {
		this.charla = charla;
		String platica = (charla +", a las: "+ new Date());
		System.out.println(platica);
		ManejadorArchivos manejador = new ManejadorArchivos("historial");
		manejador.escribir(platica);
	}
	public Retorno() throws RemoteException{
	}
	public Retorno(String charla) throws RemoteException{
		this.charla = charla;
	}
}