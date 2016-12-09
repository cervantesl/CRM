package graficos;

import javax.swing.JInternalFrame;

public class VentanaUsuario extends JInternalFrame {

	private final PanelUsuario usuario;

	public VentanaUsuario() {

		setTitle("Usuario");

		usuario = new PanelUsuario();
		add(usuario);
	}
}
