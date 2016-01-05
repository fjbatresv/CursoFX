package org.javierbatres.proyecto.rmi;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import org.javierbatres.proyecto.rmi.Retorno;
public class SistemaServidor{
	public static void main(String args[]){
		try{
			Naming.rebind("servidor",Retorno.getInstancia());
			System.out.println("Servidor iniciado");
		}catch(RemoteException e){
			e.printStackTrace();
		}catch(MalformedURLException e){
			e.printStackTrace();
		}
	}
}