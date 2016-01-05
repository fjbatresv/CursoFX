package org.javierbatres.proyecto.rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Interfaz extends Remote{
	public void setCharla(String charla) throws RemoteException;
	public String getCharla() throws RemoteException;
}