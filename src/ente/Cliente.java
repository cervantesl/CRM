package ente;

public class Cliente {

	private int id;
	private String nombre;
	private String apellidos;
	private String dni;

	public Cliente(int id, String nombre, String apellidos, String dni) {
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
