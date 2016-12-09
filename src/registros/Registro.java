package registros;

import basedatos.GestorBaseDatosSQLite;

public abstract class Registro {

	protected GestorBaseDatosSQLite conector = new GestorBaseDatosSQLite();

	public void conectarBD() {
		conector.connect();
	}

	public void cerrarConexionBD() {
		conector.close();
	}
}
