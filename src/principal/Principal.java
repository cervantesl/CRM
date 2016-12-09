package principal;

import javax.swing.SwingUtilities;

import graficos.VentanaPrincipal;

public class Principal {

	private static VentanaPrincipal ventanaPrincipal;

	public static void main(String[] args) {
		ventanaPrincipal = new VentanaPrincipal();
	}

	public static VentanaPrincipal obtenerVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public static void actualizarVentanaPrincipal() {
		ventanaPrincipal = Principal.obtenerVentanaPrincipal();
		SwingUtilities.updateComponentTreeUI(ventanaPrincipal);
	}
}
