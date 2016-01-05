package org.javierbatres.proyecto.modelos;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import org.javierbatres.proyecto.bean.Usuario;
import org.javierbatres.proyecto.bean.Vehiculo;
//import org.javierbatres.proyecto.iu.Cargando;
//import org.javierbatres.proyecto.iu.VentanaVistaDeUsuarios;
import org.javierbatres.proyecto.manejadores.ManejadorUsuario;
import org.javierbatres.proyecto.manejadores.ManejadorVehiculos;
//import org.javierbatres.proyecto.iu.ErrorDeEntrada;
import org.jvnet.substance.SubstanceLookAndFeel;
public class ModeloVehiculos extends AbstractTableModel{
	private String encabezados[] = {"Marca","Modelo", "Dueño","placa"};
	private ArrayList<Vehiculo> lista = 
		ManejadorVehiculos.getInstancia().consultarVehiculos();
	public void agregar(Vehiculo vehiculo){
		lista.add(vehiculo);
		ManejadorVehiculos.getInstancia().agregar(vehiculo);
		lista = ManejadorVehiculos.getInstancia().consultarVehiculos();
		fireTableDataChanged();
	}
	public void eliminar(Vehiculo vehiculo){
		lista.remove(vehiculo);
		ManejadorVehiculos.getInstancia().eliminar(vehiculo);
		lista = ManejadorVehiculos.getInstancia().consultarVehiculos();
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
		Vehiculo vehiculo = lista.get(fila);
		switch(columna){
			case 0:
				resultado = String.valueOf(vehiculo.getMarca());
				break;
			case 1:
				resultado = String.valueOf(vehiculo.getModelo());
				break;
			case 2: 
				resultado = String.valueOf(vehiculo.getPlaca());
				break;
			case 3:
				resultado = String.valueOf(vehiculo.getDpi());
				break;
		}
		return resultado;
	}
	

}
