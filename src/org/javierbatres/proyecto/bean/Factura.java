package org.javierbatres.proyecto.bean;

public class Factura {
private int numFac;
private int fecha;
private String nit;
private int idUsaurio;
private int idServicio;
private int tarjeta;
private int efectivo;

public int getNumFac() {
	return numFac;
}

public void setNumFac(int numFac) {
	this.numFac = numFac;
}

public int getFecha() {
	return fecha;
}

public void setFecha(int fecha) {
	this.fecha = fecha;
}

public String getNit() {
	return nit;
}

public void setNit(String nit) {
	this.nit = nit;
}

public int getIdUsaurio() {
	return idUsaurio;
}

public void setIdUsaurio(int idUsaurio) {
	this.idUsaurio = idUsaurio;
}

public int getIdServicio() {
	return idServicio;
}

public void setIdServicio(int idServicio) {
	this.idServicio = idServicio;
}

public int getTarjeta() {
	return tarjeta;
}

public void setTarjeta(int tarjeta) {
	this.tarjeta = tarjeta;
}

public int getEfectivo() {
	return efectivo;
}

public void setEfectivo(int efectivo) {
	this.efectivo = efectivo;
}

public Factura() {
}
public Factura(int numFac , int fecha , String nit , int idUsuario , int idServicio , int tarjeta , int efectivo){
	this.numFac = numFac;
	this.fecha = fecha;
	this.nit = nit;
	this.idUsaurio = idUsuario;
	this.idServicio = idServicio;
	this.tarjeta = tarjeta;
	this.efectivo = efectivo;
}
}
