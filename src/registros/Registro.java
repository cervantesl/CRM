package registros;

import basedatos.GestorBaseDatosSQLite;

public abstract class Registro {

	protected GestorBaseDatosSQLite conector = new GestorBaseDatosSQLite();

	public void conectarBD() {
		conector.conectarConexionBD();
	}

	public void cerrarConexionBD() {
		conector.cerrarConexionBD();
	}
}
