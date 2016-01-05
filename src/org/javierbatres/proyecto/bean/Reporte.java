package org.javierbatres.proyecto.bean;

public class Reporte {
private int id;
private int idUsuario;
private String dpi;
private int idVenta;
private int idServicio;
private int idOrden;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getIdUsuario() {
	return idUsuario;
}

public void setIdUsuario(int idUsuario) {
	this.idUsuario = idUsuario;
}

public String getDpi() {
	return dpi;
}

public void setDpi(String dpi) {
	this.dpi = dpi;
}

public int getIdVenta() {
	return idVenta;
}

public void setIdVenta(int idVenta) {
	this.idVenta = idVenta;
}

public int getIdServicio() {
	return idServicio;
}

public void setIdServicio(int idServicio) {
	this.idServicio = idServicio;
}

public int getIdOrden() {
	return idOrden;
}

public void setIdOrden(int idOrden) {
	this.idOrden = idOrden;
}

public Reporte() {
}
public Reporte(int id , int idUsuario , String dpi , int idVenta , int idServicio , int idOrden){
	this.id = id;
	this.idUsuario = idUsuario;
	this.dpi = dpi;
	this.idVenta = idVenta;
	this.idServicio = idServicio;
	this.idOrden = idOrden;
}
}
