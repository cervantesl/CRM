package registros;

import ente.Cliente;

public class RegistrosCliente extends Registro {

	private Cliente cliente;

	public void crearCliente(final int id, final String nombre, final String apellidos, final String dni) {
		cliente = new Cliente(id, nombre, apellidos, dni);
		conector.guardarCliente(cliente);
	}

	public void eliminarCliente(final int id) {
		conector.eliminarCliente(id);
	}

	public void mostrarClientes() {
		conector.mostrarClientes();
	}

	public void editarCliente(final int id, final String campo, final String atributo) {

	}

	public void mostrarCliente(final int id) {

	}

	public void mostrarCliente(final String nombre) {

	}

	public void mostrarCliente(final String nombre, final String apellidos) {

	}

}
