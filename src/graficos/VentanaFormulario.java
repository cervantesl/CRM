package graficos;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import herramientas.GestorEscritorio;

public class VentanaFormulario extends JInternalFrame implements InternalFrameListener {

	private final PanelFormulario formulario;
	private boolean abierto = true;

	public VentanaFormulario() {

		setTitle("Nuevo Cliente");
		formulario = new PanelFormulario();
		add(formulario);
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) {
		GestorEscritorio.escritorio.establecerFormularioAbierto(true);
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
		GestorEscritorio.escritorio.establecerFormularioAbierto(false);
	}

	public boolean obtenerAbierto() {
		return abierto;
	}

	public void establecerAbierto(boolean abierto) {
		this.abierto = abierto;
	}

}
