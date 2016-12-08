package graficos.menus;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager.LookAndFeelInfo;

import graficos.VentanaPrincipal;
import graficos.apariencia.VentanaApariencia;
import herramientas.CargadorRecursos;
import herramientas.GestorEscritorio;
import principal.Principal;

public class MenuPopup extends JPopupMenu implements ActionListener {

	private JMenuItem nuevoCliente;
	private JMenuItem nuevaActividad;
	private JMenuItem cargarHojaClientes;
	private JMenuItem cargarHojaActividades;
	private JMenuItem refrescar;

	private JMenu vistas;

	private JRadioButtonMenuItem[] botonesRadioTiposAspecto;
	private ButtonGroup grupoBotones;

	public MenuPopup() {

		refrescar = new JMenuItem("Refrescar");
		add(refrescar);
		refrescar.setIcon(CargadorRecursos.cargarIcono("/imagenes/refrescar.png"));
		refrescar.addActionListener(this);
		refrescar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, Event.CTRL_MASK));

		addSeparator();

		nuevoCliente = new JMenuItem("Registrar nuevo cliente");
		nuevoCliente.setIcon(CargadorRecursos.cargarIcono("/imagenes/archivo.png"));
		add(nuevoCliente);
		nuevoCliente.addActionListener(this);
		nuevoCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));

		nuevaActividad = new JMenuItem("Nueva actividad");
		nuevaActividad.setIcon(CargadorRecursos.cargarIcono("/imagenes/archivo.png"));
		add(nuevaActividad);
		nuevaActividad.addActionListener(this);
		nuevaActividad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));

		addSeparator();

		cargarHojaClientes = new JMenuItem("Cargar hoja XML de clientes");
		cargarHojaClientes.setIcon(CargadorRecursos.cargarIcono("/imagenes/copia.png"));
		add(cargarHojaClientes);
		cargarHojaClientes.addActionListener(this);
		cargarHojaClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, Event.CTRL_MASK));

		cargarHojaActividades = new JMenuItem("Cargar hoja XML de actividades");
		cargarHojaActividades.setIcon(CargadorRecursos.cargarIcono("/imagenes/copia.png"));
		add(cargarHojaActividades);
		cargarHojaActividades.addActionListener(this);
		cargarHojaActividades.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK));

		addSeparator();

		vistas = new JMenu("Apariencia del programa");
		vistas.setIcon(CargadorRecursos.cargarIcono("/imagenes/ojo.png"));
		add(vistas);

		LookAndFeelInfo[] aspectos = VentanaApariencia.obtenerAspectos();

		String[] nombreAspectos = VentanaApariencia.obtenerNombresAspectos(aspectos);
		botonesRadioTiposAspecto = new JRadioButtonMenuItem[nombreAspectos.length];

		grupoBotones = new ButtonGroup();

		for (int i = 0; i < nombreAspectos.length; i++) {
			grupoBotones.add(botonesRadioTiposAspecto[i] = new JRadioButtonMenuItem(nombreAspectos[i]));
			vistas.add(botonesRadioTiposAspecto[i]);
			botonesRadioTiposAspecto[i].addActionListener(this);
		}

		botonesRadioTiposAspecto[0].setSelected(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String codigoEvento = e.getActionCommand();

		obtenerBotonVistaSeleccionada(e);

		switch (codigoEvento) {
		case "Registrar nuevo cliente":
			GestorEscritorio.escritorio.crearFormulario();
			break;
		case "Nueva actividad":
			break;
		case "Refrescar":
			VentanaPrincipal p = Principal.obtenerVentanaPrincipal();
			SwingUtilities.updateComponentTreeUI(p);
			break;
		}

	}

	public void obtenerBotonVistaSeleccionada(ActionEvent e) {

		for (int i = 0; i < botonesRadioTiposAspecto.length; i++) {
			if (botonesRadioTiposAspecto[i].isSelected()) {
				VentanaApariencia.establecerAspecto(i);
				Principal.actualizarVentanaPrincipal();
			}
		}
	}
}
