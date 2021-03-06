package graficos.menus;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager.LookAndFeelInfo;

import graficos.PanelInformativo;
import graficos.VentanaPrincipal;
import graficos.apariencia.GestorInterfaz;
import herramientas.CargadorRecursos;
import herramientas.GestorEscritorio;
import principal.Principal;

public class BarraMenuPrincipal extends JMenuBar implements ActionListener {

	private final JMenu inicio;
	private final JMenu preferencias;
	private final JMenu ayuda;

	private final JMenuItem acercaDe;
	private final JMenuItem salir;
	private final JMenuItem nuevoCliente;
	private final JMenuItem nuevaActividad;
	private final JMenuItem cargarHojaClientes;
	private final JMenuItem cargarHojaActividades;
	private final JMenuItem refrescar;

	private final JMenu configuracion;
	private final JMenuItem editarUsuario;

	private static JCheckBoxMenuItem mostrarBarraHerramientas;

	private static JRadioButtonMenuItem[] botonesRadioTiposAspecto;
	private final ButtonGroup grupoBotones;

	private final JMenu opciones;
	private final JMenuItem consultarTablaCliente;
	private final JMenuItem consultarTablaActividad;

	private final JMenu vistas;

	public BarraMenuPrincipal() {

		inicio = new JMenu("Inicio");
		add(inicio);

		preferencias = new JMenu("Preferencias");
		add(preferencias);

		ayuda = new JMenu("Ayuda");
		add(ayuda);

		acercaDe = new JMenuItem("Acerca de");
		ayuda.add(acercaDe);
		acercaDe.addActionListener(this);
		acercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.CTRL_MASK));
		acercaDe.setIcon(CargadorRecursos.cargarIcono("/imagenes/info.png"));

		nuevoCliente = new JMenuItem("Registrar nuevo cliente");
		nuevoCliente.setIcon(CargadorRecursos.cargarIcono("/imagenes/archivo.png"));
		inicio.add(nuevoCliente);
		nuevoCliente.addActionListener(this);
		nuevoCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));

		nuevaActividad = new JMenuItem("Registrar nueva actividad");
		nuevaActividad.setIcon(CargadorRecursos.cargarIcono("/imagenes/archivo.png"));
		nuevaActividad.addActionListener(this);
		nuevaActividad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
		inicio.add(nuevaActividad);

		inicio.addSeparator();

		cargarHojaClientes = new JMenuItem("Cargar hoja XML de clientes");
		cargarHojaClientes.setIcon(CargadorRecursos.cargarIcono("/imagenes/copia.png"));
		inicio.add(cargarHojaClientes);
		cargarHojaClientes.addActionListener(this);
		cargarHojaClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, Event.CTRL_MASK));

		cargarHojaActividades = new JMenuItem("Cargar hoja XML de actividades");
		cargarHojaActividades.setIcon(CargadorRecursos.cargarIcono("/imagenes/copia.png"));
		inicio.add(cargarHojaActividades);
		cargarHojaActividades.addActionListener(this);
		cargarHojaActividades.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK));

		inicio.addSeparator();

		refrescar = new JMenuItem("Refrescar");
		refrescar.setIcon(CargadorRecursos.cargarIcono("/imagenes/refrescar.png"));
		refrescar.addActionListener(this);
		refrescar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, Event.CTRL_MASK));
		inicio.add(refrescar);

		configuracion = new JMenu("Configuracion");

		configuracion.setIcon(CargadorRecursos.cargarIcono("/imagenes/ajustes.png"));
		preferencias.add(configuracion);

		editarUsuario = new JMenuItem("Editar Cuenta");
		configuracion.add(editarUsuario);
		editarUsuario.addActionListener(this);
		editarUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, Event.CTRL_MASK));
		editarUsuario.setIcon(CargadorRecursos.cargarIcono("/imagenes/editar.png"));

		vistas = new JMenu("Apariencia del programa");
		vistas.setIcon(CargadorRecursos.cargarIcono("/imagenes/ojo.png"));
		preferencias.add(vistas);

		LookAndFeelInfo[] aspectos = GestorInterfaz.obtenerAspectos();

		String[] nombreAspectos = GestorInterfaz.obtenerNombresAspectos(aspectos);
		botonesRadioTiposAspecto = new JRadioButtonMenuItem[nombreAspectos.length];

		grupoBotones = new ButtonGroup();

		for (int i = 0; i < nombreAspectos.length; i++) {
			grupoBotones.add(botonesRadioTiposAspecto[i] = new JRadioButtonMenuItem(nombreAspectos[i]));
			vistas.add(botonesRadioTiposAspecto[i]);
			botonesRadioTiposAspecto[i].addActionListener(this);
		}

		botonesRadioTiposAspecto[0].setSelected(true);

		preferencias.addSeparator();

		mostrarBarraHerramientas = new JCheckBoxMenuItem("Mostrar barra herramientas");
		preferencias.add(mostrarBarraHerramientas);
		mostrarBarraHerramientas.setSelected(true);
		mostrarBarraHerramientas.addActionListener(this);
		mostrarBarraHerramientas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK));

		inicio.addSeparator();

		opciones = new JMenu("Opciones");
		opciones.setIcon(CargadorRecursos.cargarIcono("/imagenes/opciones.png"));
		inicio.add(opciones);

		consultarTablaCliente = new JMenuItem("Consultar Tabla Clientes");
		consultarTablaCliente.setIcon(CargadorRecursos.cargarIcono("/imagenes/consultar.png"));
		consultarTablaCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, Event.CTRL_MASK));
		opciones.add(consultarTablaCliente);

		consultarTablaActividad = new JMenuItem("Consultar Tabla Actividades");
		consultarTablaActividad.setIcon(CargadorRecursos.cargarIcono("/imagenes/consultar.png"));
		consultarTablaActividad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
		opciones.add(consultarTablaActividad);

		inicio.addSeparator();

		salir = new JMenuItem("Salir");
		salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
		salir.setIcon(CargadorRecursos.cargarIcono("/imagenes/salida.png"));
		salir.addActionListener(this);
		inicio.add(salir);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String codigoEvento = e.getActionCommand();

		obtenerBotonVistaSeleccionada(e);

		switch (codigoEvento) {
		case "Salir":
			salir();
			break;
		case "Acerca de":
			acercaDe();
			break;
		case "Registrar nuevo cliente":
			GestorEscritorio.escritorio.crearFormulario();
			break;
		case "Editar Cuenta":
			GestorEscritorio.escritorio.editarUsuario();
			break;
		case "Consultar Tabla Clientes":
			// GestorEscritorio.escritorio.obtenerTablaCliente();
			break;
		case "Registrar nueva actividad": // ACABAR
			break;
		case "Mostrar barra herramientas":
			activarBarraHerramientas();
			break;
		case "Refrescar":

		}
	}

	private void salir() {
		System.exit(0);
	}

	private void acercaDe() {
		PanelInformativo panelInformativo = new PanelInformativo();

		String[] opciones = { "aceptar" };

		JOptionPane.showOptionDialog(this, panelInformativo, "Acerca de", -1, JOptionPane.DEFAULT_OPTION, null,
				opciones, opciones[0]);
	}

	private void activarBarraHerramientas() {
		if (!mostrarBarraHerramientas.isSelected()) {
			VentanaPrincipal.obtenerBarraHerramientas().setVisible(false);
		} else {
			VentanaPrincipal.obtenerBarraHerramientas().setVisible(true);
		}
	}

	public void obtenerBotonVistaSeleccionada(ActionEvent e) {
		JRadioButtonMenuItem[] botonesEspejo = MenuPopup.obtenerBotonesRadioTiposAspecto();

		for (int i = 0; i < botonesRadioTiposAspecto.length; i++) {
			if (botonesRadioTiposAspecto[i].isSelected()) {
				botonesEspejo[i].setSelected(true);
				GestorInterfaz.establecerAspecto(i);
				Principal.actualizarVentanaPrincipal();
			}
		}
	}

	public static JRadioButtonMenuItem[] obtenerBotonesRadioTiposAspecto() {
		return botonesRadioTiposAspecto;
	}

}
