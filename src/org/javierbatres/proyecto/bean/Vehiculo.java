package org.javierbatres.proyecto.bean;

public class Vehiculo {
private int id;
private String marca;
private String modelo;
private String placa;
private String dpi;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

public String getPlaca() {
	return placa;
}

public void setPlaca(String placa) {
	this.placa = placa;
}

public String getDpi() {
	return dpi;
}

public void setDpi(String dpi) {
	this.dpi = dpi;
}

public Vehiculo() {
}
public Vehiculo(int id , String marca , String modelo, String placa , String dpi){
	this.id = id;
	this.marca = marca;
	this.modelo = modelo;
	this.placa = placa;
	this.dpi = dpi;
}
}
