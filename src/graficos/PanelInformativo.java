package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInformativo extends JPanel {

	private final int ancho = 400;
	private final int alto = 400;

	private final JLabel titulo;
	private final JLabel informacion;
	private final JLabel version;
	private final JLabel autor;
	private final JLabel nombreAutor;

	private final JPanel panelDatos;

	public PanelInformativo() {
		setLayout(new BorderLayout());

		titulo = new JLabel("Acerca de...");
		titulo.setFont(new Font("Arial", Font.PLAIN, 28));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		add(titulo, BorderLayout.NORTH);

		panelDatos = new JPanel();
		panelDatos.setLayout(new GridBagLayout());
		panelDatos.setBackground(Color.GRAY);
		add(panelDatos, BorderLayout.CENTER);

		GridBagConstraints constraints = new GridBagConstraints();

		informacion = new JLabel("Version: ");

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;

		panelDatos.add(informacion, constraints);

		version = new JLabel("1.0");
		version.setFont(new Font("Arial", Font.PLAIN, 14));

		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;

		panelDatos.add(version, constraints);

		autor = new JLabel("Autor: ");

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;

		panelDatos.add(autor, constraints);

		nombreAutor = new JLabel("Lucas Cervantes Leonez");
		nombreAutor.setFont(new Font("Arial", Font.PLAIN, 14));

		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;

		panelDatos.add(nombreAutor, constraints);

		setPreferredSize(new Dimension(ancho, alto));
	}
}
