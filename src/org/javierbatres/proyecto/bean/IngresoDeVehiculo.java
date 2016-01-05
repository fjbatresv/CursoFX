package org.javierbatres.proyecto.bean;
public class IngresoDeVehiculo {
	private int id;
	private int duenio;
	private String marca;
	private String modelo;
	private int anio;
	private int actividadARealizar;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDuenio() {
		return duenio;
	}
	public void setDuenio(int duenio) {
		this.duenio = duenio;
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
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getActividadARealizar() {
		return actividadARealizar;
	}
	public void setActividadARealizar(int actividadARealizar) {
		this.actividadARealizar = actividadARealizar;
	}
	public IngresoDeVehiculo() {
	}
	public IngresoDeVehiculo(int id, int duenio, String marca, String modelo,
			int anio, int actividadARealizar) {
		super();
		this.id = id;
		this.duenio = duenio;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.actividadARealizar = actividadARealizar;
	}
}
