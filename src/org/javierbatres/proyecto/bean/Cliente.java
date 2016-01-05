package org.javierbatres.proyecto.bean;
public class Cliente {
private String nit;
private String nombreCl;
private String apellidoCl;
private String direccion;
private String dpi;
	public String getNit() {
	return nit;
}
public void setNit(String nit) {
	this.nit = nit;
}
public String getNombreCl() {
	return nombreCl;
}
public void setNombreCl(String nombreCl) {
	this.nombreCl = nombreCl;
}
public String getApellidoCl() {
	return apellidoCl;
}
public void setApellidoCl(String apellidoCl) {
	this.apellidoCl = apellidoCl;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getDpi() {
	return dpi;
}
public void setDpi(String dpi) {
	this.dpi = dpi;
}
public Cliente() {
}
public Cliente(String nit , String nombreCl , String apellidoCl , String direccion , String dpi){
	this.nit = nit;
	this.nombreCl = nombreCl;
	this.apellidoCl = apellidoCl;
	this.direccion = direccion;
	this.dpi = dpi;
}
}
