package org.javierbatres.proyecto.bean;

public class Venta {
private int id;
private int numFac;
private int cantidad;
private int idArticulo;
private int idUsuario;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getNumFac() {
	return numFac;
}

public void setNumFac(int numFac) {
	this.numFac = numFac;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public int getIdArticulo() {
	return idArticulo;
}

public void setIdArticulo(int idArticulo) {
	this.idArticulo = idArticulo;
}

public int getIdUsuario() {
	return idUsuario;
}

public void setIdUsuario(int idUsuario) {
	this.idUsuario = idUsuario;
}

public Venta() {
}
public Venta(int id , int numFac , int cantidad , int idArticulo , int idUsuario){
	this.id = id;
	this.numFac = numFac;
	this.cantidad = cantidad;
	this.idArticulo = idArticulo;
	this.idUsuario = idUsuario;
}
}
