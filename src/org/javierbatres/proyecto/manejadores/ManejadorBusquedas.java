package org.javierbatres.proyecto.manejadores;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.javierbatres.proyecto.bean.Cliente;
import org.javierbatres.proyecto.bean.Factura;
import org.javierbatres.proyecto.bean.Orden;
import org.javierbatres.proyecto.bean.Reporte;
import org.javierbatres.proyecto.bean.Servicio;
import org.javierbatres.proyecto.bean.Stock;
import org.javierbatres.proyecto.bean.Usuario;
import org.javierbatres.proyecto.bean.Vehiculo;
import org.javierbatres.proyecto.bean.Venta;
import org.javierbatres.proyecto.conexion.Conexion;

public class ManejadorBusquedas {
	private static ManejadorBusquedas instancia;
	public static ManejadorBusquedas getInstancia(){
		if(instancia == null){
			instancia = new ManejadorBusquedas();
		}
		return instancia;
	}
	private Usuario usuario = null;
	public Usuario getUsuario(){
		return usuario;
	}
	public void busquedaSimpleUsuarios(String palabra){
		ResultSet resultado = Conexion.getInstancia().hacerConsulta("SELECT Usuario.nombreU , Usuario.nickName ," +
		" Usuario.idUsuario , Usuario.idTipoUsuario FROM Usuario WHERE 	Usuario.nombreU = '"+palabra+
		"' OR Usuario.nickName = '"+palabra+"'");
		try {
			if(resultado != null){
				while(resultado.next()){
					if(resultado.getInt("idTipoUsuario")==1){
						this.usuario = new Usuario(resultado.getInt("idUsuario"),resultado.getString("nombreU"),  resultado.getString("nickName") , "Administrador" , 0);
						System.out.println(usuario.getNombre() +" "+ usuario.getNick() +" "+ "Administrador");
					}else if(resultado.getInt("idTipoUsuario")==2){
						this.usuario = new Usuario(resultado.getInt("idUsuario"),resultado.getString("nombreU"),  resultado.getString("nickName") , "Empleado" , 0);
						System.out.println(usuario.getNombre() +" "+ usuario.getNick() +" "+ "Empleado");
					}
				}
			}
		}catch(SQLException e){
			System.out.println("Imposible realizar busqueda");
		}
	}
	private Cliente cliente = null;
	public Cliente getCliente(){
		return cliente;
	}
	public void busquedaSimpleClientes(String palabra){
		ResultSet resultado = Conexion.getInstancia().hacerConsulta("SELECT Cliente.apellidoCl , Cliente.nombreCl ," +
		" Cliente.nit , Cliente.direccion ,Cliente.dpi FROM Cliente WHERE 	Cliente.nombreCl = '"+palabra+
		"' OR Cliente.apellidoCl = '"+palabra+"' OR Cliente.nit = '"+palabra+"' OR Cliente.dpi = '"+palabra+"' OR Cliente.direccion = '"+palabra+"'");
		try {
			if(resultado != null){
				while(resultado.next()){
					this.cliente = new Cliente(resultado.getString("nombreCl"),  resultado.getString("apellidoCl") , resultado.getString("direccion"), resultado.getString("nit") , resultado.getString("dpi"));
					System.out.println(cliente.getNombreCl() +" "+ cliente.getApellidoCl() +" "+ cliente.getDireccion() +" "+ cliente.getNit() +" "+
					 cliente.getDpi());
				}
			}
		}catch(SQLException e){
			System.out.println("Imposible realizar busqueda");
		}
	}
	private Vehiculo vehiculo = null;
	public Vehiculo getVehiculo(){
		return vehiculo;
	}
	public void busquedaSimpleVehiculos(String palabra){
		ResultSet resultado = Conexion.getInstancia().hacerConsulta("SELECT Vehiculo.marca , Vehiculo.modelo" +
		" Vehiculo.placa ,Vehiculo.dpi FROM Vehiculo WHERE 	Vehiculo.marca = '"+palabra+
		"' OR Vehiculo.modelo = '"+palabra+"' OR Vehiculo.placa = '"+palabra+"' OR Vehiculo.dpi = '"+palabra+"'");
		try {
			if(resultado != null){
				while(resultado.next()){
					this.vehiculo = new Vehiculo(0,resultado.getString("marca"),  resultado.getString("modelo") , resultado.getString("placa"), resultado.getString("dpi"));
					System.out.println(vehiculo.getMarca() +" "+ vehiculo.getModelo() +" "+ vehiculo.getPlaca() +" "+ vehiculo.getDpi());
				}
			}
		}catch(SQLException e){
			System.out.println("Imposible realizar busqueda");
		}
	}
	private Stock stock = null;
	public Stock getStock(){
		return stock;
	}
	public void busquedaSimpleStock(String palabra){
		ResultSet resultado = Conexion.getInstancia().hacerConsulta("SELECT Stock.idArticulo , Stock.tipo" +
		" Stock.marca , Stock.datos , Stock.precio , Stock.cantidad FROM Stock WHERE 	Stock.idArticulo = '"+palabra+
		"' OR Stock.tipo = '"+palabra+"' OR Stock.marca = '"+palabra+"' OR Stock.datos = '"+palabra+"'");
		try {
			if(resultado != null){
				while(resultado.next()){
					this.stock = new Stock(0,resultado.getString("tipo"),resultado.getString("marca"), resultado.getString("datos"), resultado.getInt("cantidad") , resultado.getInt("precio"),0);
					System.out.println(stock.getId() +" "+ stock.getTipo() +" "+stock.getMarca()+ " "+ stock.getDatos() +" "+ stock.getExistencia() +" "+ stock.getPrecio());
				}
			}
		}catch(SQLException e){
			System.out.println("Imposible realizar busqueda");
		}
	}
	private Factura factura = null;
	public Factura getFactura(){
		return factura;
	}
	public void busquedaSimpleFactura(String palabra){
		ResultSet resultado = Conexion.getInstancia().hacerConsulta("SELECT Factura.numFac , Factura.fecha" +
		" Factura.nit , Factura.idUsuario , Factura.idServicio , Factura.tarjeta , Factura.efectivo " +
		"FROM Factura WHERE Factura.numFac = '"+palabra+
		"' OR Factura.fecha = '"+palabra+"' OR Factura.nit = '"+palabra+"' OR Factura.idUsuario = '"+palabra+"' OR" +
		" Factura.idServicio = '"+palabra+"'");
		try {
			if(resultado != null){
				while(resultado.next()){
					this.factura = new Factura(resultado.getInt("numFac"),resultado.getInt("fecha"),  resultado.getString("nit") , resultado.getInt("idUsuario"), resultado.getInt("idServicio"),
							resultado.getInt("tarjeta"),resultado.getInt("efectivo"));
					System.out.println(factura.getNumFac() +" "+ factura.getNit() +" "+ factura.getFecha() +" "+ factura.getEfectivo() + " " + factura.getTarjeta() +" "+
						factura.getIdServicio() +" "+ factura.getIdUsaurio());
				}
			}
		}catch(SQLException e){
			System.out.println("Imposible realizar busqueda");
		}
	}
	private Servicio servicio = null;
	public Servicio getServicio(){
		return servicio;
	}
	public void busquedaSimpleServicio(String palabra){
		ResultSet resultado = Conexion.getInstancia().hacerConsulta("SELECT Servicio.idServicio , Servicio.idVenta" +
		"Servicio.numFac , Servicio.Descripcion" +
		"FROM Factura WHERE Servicio.numFac = '"+palabra+
		"' OR Servicio.idServicio = '"+palabra+"' OR Servicio.idVenta = '"+palabra+"'");
		try {
			if(resultado != null){
				while(resultado.next()){
					this.servicio = new Servicio(resultado.getInt("idServicio"),resultado.getString("Descripcion"),  resultado.getInt("idVenta") , resultado.getInt("numFac"));
					System.out.println(servicio.getId() +" "+ servicio.getIdVenta() +" "+ servicio.getNumFac() +" "+ servicio.getDescipcion());
				}
			}
		}catch(SQLException e){
			System.out.println("Imposible realizar busqueda");
		}
	}
	private Venta venta = null;
	public Venta getVenta(){
		return venta;
	}
	public void busquedaSimpleVenta(String palabra){
		ResultSet resultado = Conexion.getInstancia().hacerConsulta("SELECT Venta.idVenta , Venta.numFac" +
		"Venta.cantidad , Venta.idArticulo , Venta.idUsuario" +
		"FROM Factura WHERE Venta.numFac = '"+palabra+
		"' OR Venta.idVenta = '"+palabra+"' OR Venta.idUsuario = '"+palabra+"'");
		try {
			if(resultado != null){
				while(resultado.next()){
					this.venta = new Venta(resultado.getInt("idVenta"),resultado.getInt("numFac"),  resultado.getInt("cantidad") , resultado.getInt("idArticulo") , resultado.getInt("idUsuario"));
					System.out.println(venta.getNumFac() +" "+ venta.getIdArticulo() +" "+ venta.getCantidad() +" "+ venta.getIdUsuario() );
				}
			}
		}catch(SQLException e){
			System.out.println("Imposible realizar busqueda");
		}
	}
	private Orden orden = null;
	public Orden getOrden(){
		return orden;
	}
	public void busquedaSimpleOrden(String palabra){
		ResultSet resultado = Conexion.getInstancia().hacerConsulta("SELECT OrdenTrabajo.dpi , OrdenTrabajo.descripcionTrabajo" +
		"OrdenTrabajo.idVehiculo , OrdenTrabajo.idOrdenTrabajo , OrdenTrabajo.fechaSalida , OrdenTrabajo.FechaEntrada" +
		"FROM OrdenTrabajo WHERE OrdenTrabajo.dpi = '"+palabra+
		"' OR OrdenTrabajo.idVehiculo = '"+palabra+"' OR OrdenTrabajo.idOrdenTrabajo = '"+palabra+"'");
		try {
			if(resultado != null){
				while(resultado.next()){
					this.orden = new Orden(resultado.getString("dpi"),resultado.getString("descripcionTrabajo"),
						resultado.getInt("idVehiculo") , resultado.getInt("idOrdenTrabajo") , resultado.getInt("fechaSalida"),resultado.getInt("fechaEntrada"));
					System.out.println(orden.getId() +" "+ orden.getIdVehiculo() +" "+ orden.getDescipcion() +" "+ orden.getFechaEntrada() +" "+ orden.getFechaSalida());
				}
			}
		}catch(SQLException e){
			System.out.println("Imposible realizar busqueda");
		}
	}
	private Reporte reporte = null;
	public Reporte getReporte(){
		return reporte;
	}
	public void busquedaSimpleReporte(String palabra){
		ResultSet resultado = Conexion.getInstancia().hacerConsulta("SELECT Reportes.idReporte , Reportes.idUsuario" +
		"Reportes.dpi , Reportes.idVenta , Reportes.idServicio , Reportes.idOrdenTrabajo" +
		"FROM Reportes WHERE Reportes.idReporte = '"+palabra+
		"' OR Reportes.idUsuario = '"+palabra+"' OR Reportes.dpi = '"+palabra+"' OR Reportes.idVenta = '"+palabra+"' OR Reportes.idServicio = '"+
		palabra+"' OR Reportes.idOrdenTrabajo = '"+palabra+"'");
		try {
			if(resultado != null){
				while(resultado.next()){
					this.reporte = new Reporte(resultado.getInt("idReporte"),resultado.getInt("idUsuario"),
						resultado.getString("dpi") , resultado.getInt("idVenta") , resultado.getInt("idServicio"),resultado.getInt("idOrdenTrabajo"));
					System.out.println(reporte.getIdOrden() +" "+ reporte.getIdServicio() +" "+ reporte.getIdUsuario() + " "+ reporte.getIdVenta());
				}
			}
		}catch(SQLException e){
			System.out.println("Imposible realizar busqueda");
		}
	}
}
