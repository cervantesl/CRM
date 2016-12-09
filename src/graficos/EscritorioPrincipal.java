package graficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JDesktopPane;
import javax.swing.SwingUtilities;

import graficos.menus.MenuPopup;
import herramientas.CargadorRecursos;

public class EscritorioPrincipal extends JDesktopPane implements MouseListener {

	private VentanaFormulario formulario;
	private VentanaUsuario usuario;

	private boolean formularioAbierto = true;

	private BufferedImage imagen;

	private MenuPopup menuPopup;

	public EscritorioPrincipal() {

		imagen = CargadorRecursos.cargarImagen("/imagenes/empresa.png");

		menuPopup = new MenuPopup();

		addMouseListener(this);
		setBackground(Color.WHITE);
	}

	@Override
	protected void paintChildren(Graphics g) {
		super.paintChildren(g);

		g.drawImage(imagen, getWidth() - imagen.getWidth() - 20, getHeight() - imagen.getHeight() - 20, null);
	}

	public void crearFormulario() {
		if (formularioAbierto) {
			formulario = new VentanaFormulario();
			add(formulario);

			formulario.setPreferredSize(new Dimension(500, 500));
			formulario.pack();
			formulario.setClosable(true);
			formulario.setResizable(true);
			formulario.setVisible(true);
			formulario.addInternalFrameListener(formulario);

			formularioAbierto = false;
		} else {
			PanelError.ventanaYaAbierta();
		}
	}

	public void editarUsuario() {
		usuario = new VentanaUsuario();
		add(usuario);

		usuario.setPreferredSize(new Dimension(500, 500));
		usuario.pack();
		usuario.setClosable(true);
		usuario.setResizable(true);
		usuario.setVisible(true);
	}

	public void obtenerTablaCliente() {

	}

	public void establecerFormularioAbierto(boolean abierto) {
		formularioAbierto = abierto;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			menuPopup.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
