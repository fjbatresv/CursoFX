package org.javierbatres.proyecto.bean;
public class ActividadesRealizables {
	private int id;
	private String actividad;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public ActividadesRealizables(int id, String actividad) {
		super();
		this.id = id;
		this.actividad = actividad;
	}
	public ActividadesRealizables() {
	}
}
