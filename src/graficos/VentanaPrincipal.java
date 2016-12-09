package graficos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import graficos.menus.BarraHerramientas;
import graficos.menus.BarraMenuPrincipal;
import herramientas.CargadorRecursos;
import herramientas.Constantes;
import herramientas.GestorEscritorio;

public class VentanaPrincipal extends JFrame {

	private final int ancho;
	private final int alto;

	private final String nombre;

	private final BarraMenuPrincipal menuPrincipal;

	private final ImageIcon icono;

	private static BarraHerramientas barraHerramientas;

	public VentanaPrincipal() {

		setLayout(new BorderLayout());

		ancho = Constantes.ANCHO_VENTANA;
		alto = Constantes.ALTO_VENTANA;

		nombre = Constantes.NOMBRE;

		menuPrincipal = new BarraMenuPrincipal();

		add(GestorEscritorio.escritorio, BorderLayout.CENTER);

		barraHerramientas = new BarraHerramientas();
		barraHerramientas.setOrientation(JToolBar.HORIZONTAL);
		barraHerramientas.setFloatable(false);
		barraHerramientas.setPreferredSize(new Dimension(getWidth(), 30));
		add(barraHerramientas, BorderLayout.NORTH);

		BufferedImage imagen = CargadorRecursos.cargarImagen("/imagenes/icono.png");
		icono = new ImageIcon(imagen);

		setIconImage(icono.getImage());

		setTitle(nombre);
		setPreferredSize(new Dimension(ancho, alto));
		setSize(ancho, alto);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(menuPrincipal);
		setResizable(true);
		setMinimumSize(new Dimension(500, 600));
		repaint();
		pack();
	}

	public static BarraHerramientas obtenerBarraHerramientas() {
		return barraHerramientas;
	}

}
