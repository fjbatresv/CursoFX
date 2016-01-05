package org.javierbatres.proyecto.modelos;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import org.javierbatres.proyecto.bean.Usuario;
//import org.javierbatres.proyecto.iu.Cargando;
//import org.javierbatres.proyecto.iu.VentanaVistaDeUsuarios;
import org.javierbatres.proyecto.manejadores.ManejadorUsuario;
public class ModeloUsuario extends AbstractTableModel{
	private String encabezados[] = {"Nombre","Tipo De Usuario"};
	private ArrayList<Usuario> lista = 
		ManejadorUsuario.getInstancia().consultarUsuarios();
	public void agregar(Usuario usuario){
		lista.add(usuario);
		ManejadorUsuario.getInstancia().agregar(usuario);
		lista = ManejadorUsuario.getInstancia().consultarUsuarios();
		fireTableDataChanged();
	}
	public void eliminar(Usuario usuario){
		lista.remove(usuario);
		ManejadorUsuario.getInstancia().eliminar(usuario);
		lista = ManejadorUsuario.getInstancia().consultarUsuarios();
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
		Usuario usuario = lista.get(fila);
		switch(columna){
			case 0:
				resultado = String.valueOf(usuario.getNombre());
				break;
			case 1:
				if(usuario.getIdTipoDeUsuario() == 1){
					resultado = String.valueOf("Administrador");
				}else if(usuario.getIdTipoDeUsuario() == 2){
					resultado = String.valueOf("Empleado");
				}
				break;
		}
		return resultado;
	}
	
}
