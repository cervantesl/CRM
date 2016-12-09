package registros;

import basedatos.GestorBaseDatosSQLite;
import ente.Cliente;

public class RegistrosCliente {

	private Cliente cliente;

	private GestorBaseDatosSQLite conector = new GestorBaseDatosSQLite();

	public void conectarBD() {
		conector.connect();
	}

	public void crearCliente(int id, String nombre, String apellidos, String dni) {

		cliente = new Cliente(id, nombre, apellidos, dni);
		conector.guardarCliente(cliente);
		conector.mostrarClientes();
	}

	public void cerrarConexionBD() {
		conector.close();
	}

	public void eliminarCliente(final int id) {
		conector.eliminarCliente(id);
	}

	public void mostrarClientes() {
		conector.mostrarClientes();
	}

}
