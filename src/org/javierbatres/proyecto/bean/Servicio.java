package org.javierbatres.proyecto.bean;

public class Servicio {
private int id;
private String descipcion;
private int idVenta;
private int numFac;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getDescipcion() {
	return descipcion;
}

public void setDescipcion(String descipcion) {
	this.descipcion = descipcion;
}

public int getIdVenta() {
	return idVenta;
}

public void setIdVenta(int idVenta) {
	this.idVenta = idVenta;
}

public int getNumFac() {
	return numFac;
}

public void setNumFac(int numFac) {
	this.numFac = numFac;
}
public Servicio() {
}
public Servicio(int id , String descripcion , int idVenta , int numFac){
	this.id = id;
	this.descipcion = descripcion;
	this.idVenta = idVenta;
	this.numFac = numFac;
}
}
