package graficos;

import javax.swing.JOptionPane;

import herramientas.GestorEscritorio;

public class PanelError {

	public static void ventanaYaAbierta() {

		JOptionPane.showMessageDialog(GestorEscritorio.escritorio, "Error, ya hay una ventana abierta", "Error",
				JOptionPane.ERROR_MESSAGE);
	}
}
