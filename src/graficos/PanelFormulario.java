package graficos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import registros.GestorRegistros;

public class PanelFormulario extends JPanel implements ActionListener {

	private final JLabel id;
	private final JLabel nombre;
	private final JLabel apellidos;
	private final JLabel sexo;
	private final JLabel telefono;
	private final JLabel dni;

	private final JTextField campoId;
	private final JTextField campoNombre;
	private final JTextField campoApellidos;
	private final JTextField campoTelefono;
	private final JTextField campoDni;

	private final JComboBox<String> sexos;

	private final JButton guardar;
	private final JButton eliminar;
	private final JButton editar;

	private final JPanel panelBotones;

	public PanelFormulario() {

		setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.anchor = GridBagConstraints.NORTHWEST;

		id = new JLabel("ID:");
		id.setPreferredSize(new Dimension(60, 15));
		constraints.gridx = 0;
		constraints.gridy = 0;

		add(id, constraints);

		campoId = new JTextField(13);

		constraints.gridx = 1;
		constraints.gridy = 0;

		add(campoId, constraints);

		nombre = new JLabel("Nombre:");
		nombre.setPreferredSize(new Dimension(60, 15));
		constraints.gridx = 0;
		constraints.gridy = 1;

		add(nombre, constraints);

		campoNombre = new JTextField(13);

		constraints.gridx = 1;
		constraints.gridy = 1;

		add(campoNombre, constraints);

		apellidos = new JLabel("Apellidos:");
		apellidos.setPreferredSize(new Dimension(60, 15));

		constraints.gridx = 0;
		constraints.gridy = 2;

		add(apellidos, constraints);

		campoApellidos = new JTextField(13);

		constraints.gridx = 1;
		constraints.gridy = 2;

		add(campoApellidos, constraints);

		sexo = new JLabel("Sexo: ");
		sexo.setPreferredSize(new Dimension(60, 15));

		constraints.gridx = 0;
		constraints.gridy = 3;

		add(sexo, constraints);

		sexos = new JComboBox<>();
		sexos.insertItemAt("Hombre", 0);
		sexos.insertItemAt("Mujer", 1);
		sexos.setPreferredSize(new Dimension(100, 20));

		constraints.gridx = 1;
		constraints.gridy = 3;

		add(sexos, constraints);

		telefono = new JLabel("Telefono:");
		telefono.setPreferredSize(new Dimension(60, 15));

		constraints.gridx = 0;
		constraints.gridy = 4;

		add(telefono, constraints);

		campoTelefono = new JTextField(13);

		constraints.gridx = 1;
		constraints.gridy = 4;

		add(campoTelefono, constraints);

		dni = new JLabel("DNI:");
		dni.setPreferredSize(new Dimension(60, 15));

		constraints.gridx = 0;
		constraints.gridy = 5;

		add(dni, constraints);

		campoDni = new JTextField(13);

		constraints.gridx = 1;
		constraints.gridy = 5;

		add(campoDni, constraints);

		panelBotones = new JPanel();

		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 4;
		constraints.gridheight = 4;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;

		panelBotones.setLayout(new FlowLayout());
		add(panelBotones, constraints);

		guardar = new JButton("Guardar");
		guardar.setPreferredSize(new Dimension(85, 25));
		guardar.addActionListener(this);

		panelBotones.add(guardar);

		eliminar = new JButton("Eliminar");
		eliminar.setPreferredSize(new Dimension(85, 25));
		eliminar.addActionListener(this);

		panelBotones.add(eliminar);

		editar = new JButton("Editar");
		editar.setPreferredSize(new Dimension(85, 25));
		editar.addActionListener(this);

		panelBotones.add(editar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == guardar) {
			int id = Integer.parseInt(campoId.getText());
			String nombre = campoNombre.getText();
			String apellidos = campoApellidos.getText();
			String dni = campoDni.getText();

			GestorRegistros.registroCliente.conectarBD();
			GestorRegistros.registroCliente.crearCliente(id, nombre, apellidos, dni);
			GestorRegistros.registroCliente.cerrarConexionBD();

		}

		if (e.getSource() == eliminar) {
			int id = Integer.parseInt(campoId.getText());

			GestorRegistros.registroCliente.conectarBD();
			GestorRegistros.registroCliente.eliminarCliente(id);
			GestorRegistros.registroCliente.cerrarConexionBD();

		}

		if (e.getSource() == editar) {
			GestorRegistros.registroCliente.conectarBD();
			GestorRegistros.registroCliente.mostrarClientes();
			GestorRegistros.registroCliente.cerrarConexionBD();
		}

	}
}
