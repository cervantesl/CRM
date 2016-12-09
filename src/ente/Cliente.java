package ente;

public class Cliente {

	private final int id;
	private final String nombre;
	private final String apellidos;
	private final String dni;

	public Cliente(final int id, final String nombre, final String apellidos, final String dni) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}

	public int obtenerId() {
		return id;
	}

	public String obtenerNombre() {
		return nombre;
	}

	public String obtenerApellidos() {
		return apellidos;
	}

	public String obtenerDni() {
		return dni;
	}

}
