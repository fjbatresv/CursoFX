package org.javierbatres.proyecto.modelos;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import org.javierbatres.proyecto.bean.Cliente;
import org.javierbatres.proyecto.bean.Usuario;
//import org.javierbatres.proyecto.iu.Cargando;
//import org.javierbatres.proyecto.iu.VentanaVistaDeUsuarios;
import org.javierbatres.proyecto.manejadores.ManejadorCliente;
import org.javierbatres.proyecto.manejadores.ManejadorUsuario;
public class ModeloCliente extends AbstractTableModel{
	private String encabezados[] = {"Nombre","Apellido","Direccion","Nit","DPI"};
	private ArrayList<Cliente> lista = 
		ManejadorCliente.getInstancia().consultarCliente();
	public void agregar(Cliente cliente){
		lista.add(cliente);
		ManejadorCliente.getInstancia().agregar(cliente);
		lista = ManejadorCliente.getInstancia().consultarCliente();
		fireTableDataChanged();
	}
	public void eliminar(Cliente cliente){
		lista.remove(cliente);
		ManejadorCliente.getInstancia().eliminar(cliente);
		lista = ManejadorCliente.getInstancia().consultarCliente();
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
		Cliente cliente = lista.get(fila);
		switch(columna){
			case 0:
				resultado = String.valueOf(cliente.getNombreCl());
				break;
			case 1:
				resultado = String.valueOf(cliente.getApellidoCl());
				break;
			case 2:
				resultado = String.valueOf(cliente.getDireccion());
				break;
			case 3:
				resultado = String.valueOf(cliente.getNit());
				break;
			case 4:
				resultado = String.valueOf(cliente.getDpi());
				break;
		}
		return resultado;
	}
	

}
