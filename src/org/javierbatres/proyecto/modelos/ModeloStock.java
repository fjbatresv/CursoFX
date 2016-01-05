package org.javierbatres.proyecto.modelos;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

import org.javierbatres.proyecto.bean.Stock;
import org.javierbatres.proyecto.bean.Usuario;
import org.javierbatres.proyecto.bean.Vehiculo;
//import org.javierbatres.proyecto.iu.Cargando;
//import org.javierbatres.proyecto.iu.VentanaVistaDeUsuarios;
import org.javierbatres.proyecto.manejadores.ManejadorStock;
import org.javierbatres.proyecto.manejadores.ManejadorUsuario;
import org.javierbatres.proyecto.manejadores.ManejadorVehiculos;
//import org.javierbatres.proyecto.iu.ErrorDeEntrada;
import org.jvnet.substance.SubstanceLookAndFeel;
public class ModeloStock extends AbstractTableModel{
	private String encabezados[] = {"Id","Nombre", "Existencias","Precio"};
	private ArrayList<Stock> lista = 
		ManejadorStock.getInstancia().consultarStock();
	public void agregar(Stock stock){
		lista.add(stock);
		ManejadorStock.getInstancia().agregar(stock);
		lista = ManejadorStock.getInstancia().consultarStock();
		fireTableDataChanged();
	}
	public int getColumnCount() {
		return encabezados.length;
	}
	public int getRowCount() {
		return lista.size();
	}
	public String getColumnName(int columna){
		return encabezados[columna];
	}
	public Object getValueAt(int fila, int columna) {
		String resultado = "";
		Stock stock = lista.get(fila);
		switch(columna){
			case 0:
				resultado = String.valueOf(stock.getId());
				break;
			case 1:
				resultado = String.valueOf(stock.getTipo());
				break;
			case 2:
				resultado = String.valueOf(stock.getMarca());
				break;
			case 3:
				resultado = String.valueOf(stock.getDatos());
				break;
			case 4: 
				resultado = String.valueOf(stock.getExistencia());
				break;
			case 5:
				resultado = String.valueOf(stock.getPrecio());
				break;
		}
		return resultado;
	}
}
