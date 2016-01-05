package org.javierbatres.proyecto.bean;

public class Orden {
private String dpi;
private String descipcion;
private int idVehiculo;
private int id;
private int fechaEntrada;
private int fechaSalida;

public String getDpi() {
	return dpi;
}

public void setDpi(String dpi) {
	this.dpi = dpi;
}

public String getDescipcion() {
	return descipcion;
}

public void setDescipcion(String descipcion) {
	this.descipcion = descipcion;
}

public int getIdVehiculo() {
	return idVehiculo;
}

public void setIdVehiculo(int idVehiculo) {
	this.idVehiculo = idVehiculo;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getFechaEntrada() {
	return fechaEntrada;
}

public void setFechaEntrada(int fechaEntrada) {
	this.fechaEntrada = fechaEntrada;
}

public int getFechaSalida() {
	return fechaSalida;
}

public void setFechaSalida(int fechaSalida) {
	this.fechaSalida = fechaSalida;
}

public Orden() {
}
public Orden(String dpi , String descipcion , int idVehiculo , int id , int fechaEntrada , int fechaSalida){
	this.dpi = dpi;
	this.descipcion = descipcion;
	this.idVehiculo = idVehiculo;
	this.id = id;
	this.fechaEntrada = fechaEntrada;
	this.fechaSalida = fechaSalida;
}
}
