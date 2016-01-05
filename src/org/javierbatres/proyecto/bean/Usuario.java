package org.javierbatres.proyecto.bean;
public class Usuario {
	private int id;
	private String nombre;
	private String nick;
	private String pass;
	private int idTipoDeUsuario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getIdTipoDeUsuario() {
		return idTipoDeUsuario;
	}
	public void setIdTipoDeUsuario(int idTipoDeUsuario) {
		this.idTipoDeUsuario = idTipoDeUsuario;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public Usuario() {
	}
	public Usuario(int id, String nombre, String nick ,String pass, int idTipoDeUsuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pass = pass;
		this.idTipoDeUsuario = idTipoDeUsuario;
		this.nick = nick;
	}
}
