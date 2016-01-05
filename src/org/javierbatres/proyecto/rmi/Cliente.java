package org.javierbatres.proyecto.rmi;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import org.javierbatres.proyecto.rmi.Interfaz;
import org.javierbatres.proyecto.rmi.Retorno;
public class Cliente{
	public void Cliente(String charla){
		String ip = "192.168.1.6";
		String recurso = "servidor";
		try{
			InputStreamReader ingreso = new InputStreamReader(System.in);
			BufferedReader lector = new BufferedReader(ingreso);
			Interfaz tasaRemota = null;
			tasaRemota = (Interfaz)Naming.
			lookup("rmi://" + ip + "/" + recurso);
			tasaRemota.setCharla(charla);
		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(RemoteException e){
			e.printStackTrace();
		}catch(NotBoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Mal escrito");
		}
	}
}