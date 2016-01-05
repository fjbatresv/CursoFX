package org.javierbatres.proyecto.bean;

public class Stock {
private int id;
private String tipo;
private String marca;
private String datos;
private int existencia;
private int precio;
private int idUsuario;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getDatos() {
	return datos;
}
public void setDatos(String datos) {
	this.datos = datos;
}
public int getExistencia() {
	return existencia;
}
public void setExistencia(int existencia) {
	this.existencia = existencia;
}
public int getPrecio() {
	return precio;
}
public void setPrecio(int precio) {
	this.precio = precio;
}
public int getIdUsuario() {
	return idUsuario;
}
public void setIdUsuario(int idUsuario) {
	this.idUsuario = idUsuario;
}
public Stock(){
}
public Stock(int id , String tipo , String marca , String datos , int existencia , int precio , int idUsuario){
	this.id = id;
	this.tipo = tipo;
	this.marca = marca;
	this.datos = datos;
	this.precio = precio;
	this.existencia = existencia;
	this.idUsuario = idUsuario;
}
}
