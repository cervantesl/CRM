package graficos.menus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import herramientas.CargadorRecursos;
import herramientas.GestorEscritorio;
import principal.Principal;

public class BarraHerramientas extends JToolBar implements ActionListener {

	private JButton nuevo;
	private JButton editarUsuario;
	private JButton consultarTablaClientes;
	private JButton consultarActividades;
	private JButton refrescar;

	public BarraHerramientas() {

		setBackground(Color.GRAY.lightGray);

		nuevo = new JButton();
		nuevo.setIcon(CargadorRecursos.cargarIcono("/imagenes/archivo.png"));
		nuevo.addActionListener(this);
		add(nuevo);

		addSeparator();

		consultarTablaClientes = new JButton("Consultar Tabla Clientes");
		consultarTablaClientes.setIcon(CargadorRecursos.cargarIcono("/imagenes/consultar.png"));
		consultarTablaClientes.addActionListener(this);
		add(consultarTablaClientes);

		addSeparator();

		consultarActividades = new JButton("Consultar Tabla Actividades");
		consultarActividades.setIcon(CargadorRecursos.cargarIcono("/imagenes/consultar.png"));
		consultarActividades.addActionListener(this);
		add(consultarActividades);

		addSeparator();

		refrescar = new JButton();
		refrescar.setIcon(CargadorRecursos.cargarIcono("/imagenes/refrescar.png"));
		refrescar.addActionListener(this);
		add(refrescar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == nuevo) {
			GestorEscritorio.escritorio.crearFormulario();
			Principal.actualizarVentanaPrincipal();
		}
	}

}
